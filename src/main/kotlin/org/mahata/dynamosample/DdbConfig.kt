package org.mahata.dynamosample

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient
import software.amazon.awssdk.services.dynamodb.DynamoDbClient
import java.net.URI

@Configuration
class DdbConfig {
    @Bean
    fun ddbClient(): DynamoDbClient {
        return DynamoDbClient
            .builder()
            .endpointOverride(URI.create("http://localhost:7776"))
            .httpClient(UrlConnectionHttpClient.builder().build())
            .build()
    }

    @Bean
    fun ddbEnhancedClient(
        @Qualifier("ddbClient") ddbClient: DynamoDbClient,
    ): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(ddbClient)
            .build()
    }
}
