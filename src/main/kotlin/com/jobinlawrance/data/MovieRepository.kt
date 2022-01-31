package com.jobinlawrance.data

import com.jobinlawrance.sqldelight.MoviesQueries

class MovieRepository(private val moviesQueries: MoviesQueries) {
    fun getAllTheMovies(limit: Long): List<Movie> {
        return moviesQueries.selectAll(limit).executeAsList().map { Movie(it) }
    }
}