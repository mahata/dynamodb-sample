package org.mahata.dynamosample

import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional

@Repository
class BlogDdbRepository(
    private val dynamoDbEnhancedClient: DynamoDbEnhancedClient,
) {
    fun save(blogDdbBean: BlogDdbBean) {
        val table = dynamoDbEnhancedClient.table("blog-table", TableSchema.fromBean(BlogDdbBean::class.java))
        table.putItem(blogDdbBean)
    }

    fun get(
        uname: String,
        createdAt: String,
    ): BlogDdbBean? {
        val table = dynamoDbEnhancedClient.table("blog-table", TableSchema.fromBean(BlogDdbBean::class.java))
        val key = Key.builder().partitionValue(uname).sortValue(createdAt).build()
        return table.getItem(key)
    }

    fun getAll(uname: String): List<BlogDdbBean> {
        val table = dynamoDbEnhancedClient.table("blog-table", TableSchema.fromBean(BlogDdbBean::class.java))
        val key = Key.builder().partitionValue(uname).build()
        val queryConditional = QueryConditional.keyEqualTo(key)
        return table.query(queryConditional).items().toList()
    }

    fun delete(
        uname: String,
        createdAt: String,
    ) {
        val table = dynamoDbEnhancedClient.table("blog-table", TableSchema.fromBean(BlogDdbBean::class.java))
        val key = Key.builder().partitionValue(uname).sortValue(createdAt).build()
        table.deleteItem(key)
    }
}
