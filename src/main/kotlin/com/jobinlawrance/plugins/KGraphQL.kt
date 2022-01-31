package com.jobinlawrance.plugins

import com.apurebase.kgraphql.GraphQL
import com.jobinlawrance.data.Movie
import com.jobinlawrance.data.MovieRepository
import io.ktor.application.*
import org.koin.ktor.ext.inject

fun Application.configureGraphQL() {
    val movieRepository by inject<MovieRepository>()
    install(GraphQL) {
        playground = true
        schema {
            query("movie") {
                resolver { size: Long -> movieRepository.getAllTheMovies(size) }.withArgs {
                    arg<Long> { name = "size"; defaultValue = 10L }
                }
            }
            type<Movie>() {
                description = "Movie object"
            }
        }
    }
}