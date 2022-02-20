package com.jobinlawrance.plugins

import com.apurebase.kgraphql.GraphQL
import com.jobinlawrance.data.Movie
import com.jobinlawrance.data.MovieRepository
import io.ktor.application.Application
import io.ktor.application.install
import org.koin.ktor.ext.inject

fun Application.configureGraphQL() {
    val movieRepository by inject<MovieRepository>()
    install(GraphQL) {
        playground = true
        schema {
            type<Movie>() {
                description = "Movie object"
            }

            query("movies") {
                description = "Returns a list of movie"
                resolver { first: Long -> movieRepository.getAllTheMovies(first) }.withArgs {
                    arg<Long> { name = "first"; defaultValue = 10L }
                }
            }

            query("movie") {
                description = "Returns a movie matched by :id or null if id is invalid"
                resolver { id: Int -> movieRepository.getMovieById(id) }
            }

            inputType<Movie> {
                name = "movieInput"
            }

            mutation("addMovie") {
                description = "Adds a new movie and returns the id"
                resolver { movie: Movie -> movieRepository.createMovie(movie) }
            }

            mutation("updateRTScore") {
                description = "Updates the Rotten tomatoes score and returns the updated movie"
                resolver { id: Int, rtScore: Int -> movieRepository.updateRTScore(id, rtScore) }
            }
        }
    }
}