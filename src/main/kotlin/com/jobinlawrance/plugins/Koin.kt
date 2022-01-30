package com.jobinlawrance.plugins


import com.jobinlawrance.di.appModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.modules
import org.koin.logger.SLF4JLogger

fun Application.configureKoin() {
    install(Koin){
        SLF4JLogger()
        modules(appModule)
    }
}