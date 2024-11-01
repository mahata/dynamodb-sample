package org.mahata.dynamosample

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@SpringBootTest
class DynamoDbConfigTest {
    @Autowired
    private lateinit var dynamoDbClient: DynamoDbClient

    @Autowired
    private lateinit var dynamoDbEnhancedClient: DynamoDbEnhancedClient

    @Test
    fun contextLoads() {
        assertNotNull(dynamoDbClient)
        assertNotNull(dynamoDbEnhancedClient)
    }
}
