package com.jobinlawrance.plugins

import com.apurebase.kgraphql.GraphQL
import io.ktor.application.*

fun Application.configureGraphQL() {
    install(GraphQL) {
        playground = true
        schema {
            query("hello") {
                resolver { -> "World" }
            }
        }
    }
}