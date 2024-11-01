package org.mahata.dynamosample

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

data class BlogRequest(
    val articleTitle: String,
    val articleText: String,
)

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(
    private val ddbRepo: BlogDdbRepository,
) {
    @GetMapping
    fun getArticles(): List<BlogDdbBean> {
        return ddbRepo.getAll("foo")
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postArticle(
        @RequestBody blogRequest: BlogRequest,
    ) {
        ddbRepo.save(
            BlogDdbBean(
                uname = "foo",
                articleTitle = blogRequest.articleTitle,
                articleText = blogRequest.articleText,
            ),
        )
    }
}
