package org.mahata.dynamosample

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey
import java.time.Instant

@DynamoDbBean
data class BlogDynamoDbBean(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("uname")
    var uname: String = "",
    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("createdAt")
    var createdAt: Instant = Instant.now(),
    @get:DynamoDbAttribute("articleTitle")
    var articleTitle: String = "",
    @get:DynamoDbAttribute("articleText")
    var articleText: String = "",
    @get:DynamoDbAttribute("modifiedAt")
    var modifiedAt: Instant = Instant.now(),
)
