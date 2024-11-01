package org.mahata.dynamosample

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey
import java.time.Instant

@DynamoDbBean
data class BlogDdbBean(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("uname")
    var uname: String = "",
    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("createdAt")
    var createdAt: Long = Instant.now().epochSecond,
    @get:DynamoDbAttribute("articleTitle")
    var articleTitle: String = "",
    @get:DynamoDbAttribute("articleText")
    var articleText: String = "",
)
