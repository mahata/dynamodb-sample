package org.mahata.dynamosample

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI

@Configuration
class DynamoDbConfig {
    @Bean
    fun dynamoDbClient(): DynamoDbClient {
        return DynamoDbClient
            .builder()
            .endpointOverride(URI.create("http://localhost:7776"))
            .httpClient(UrlConnectionHttpClient.builder().build())
            .build()
    }

    @Bean
    fun dynamoDbEnhancedClient(
        @Qualifier("dynamoDbClient") dynamoDbClient: DynamoDbClient,
    ): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(dynamoDbClient)
            .build()
    }
}
