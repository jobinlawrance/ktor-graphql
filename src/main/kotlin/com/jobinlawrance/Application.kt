package com.jobinlawrance

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.jobinlawrance.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureHTTP()
        configureRouting()
    }.start(wait = true)
}
