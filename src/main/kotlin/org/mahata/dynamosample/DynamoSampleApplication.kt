package org.mahata.dynamosample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DynamoSampleApplication

fun main(args: Array<String>) {
    runApplication<DynamoSampleApplication>(*args)
}
