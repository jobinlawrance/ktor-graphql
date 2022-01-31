package com.jobinlawrance

import com.jobinlawrance.plugins.configureGraphQL
import com.jobinlawrance.plugins.configureHTTP
import com.jobinlawrance.plugins.configureKoin
import com.jobinlawrance.plugins.configureRouting
import com.jobinlawrance.plugins.configureSerialization
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureKoin()
        configureHTTP()
        configureSerialization()
        configureRouting()
        configureGraphQL()
    }.start(wait = true)
}
