package com.jobinlawrance.plugins

import com.jobinlawrance.data.MovieRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val moviesRepository by inject<MovieRepository>()

    routing {
        get("/movies") {
            call.respond(moviesRepository.getAllTheMovies(Long.MAX_VALUE))
        }
    }
}
