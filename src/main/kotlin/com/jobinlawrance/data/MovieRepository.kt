package com.jobinlawrance.data

import com.jobinlawrance.sqldelight.MoviesQueries

class MovieRepository(private val moviesQueries: MoviesQueries) {
    fun getAllTheMovies(): List<Movie> {
        return moviesQueries.selectAll().executeAsList().map { Movie(it) }
    }
}