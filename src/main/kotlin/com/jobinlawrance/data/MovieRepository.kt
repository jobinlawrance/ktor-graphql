package com.jobinlawrance.data

import com.jobinlawrance.sqldelight.MoviesQueries

class MovieRepository(private val moviesQueries: MoviesQueries) {
    fun getAllTheMovies(limit: Long): List<Movie> {
        return moviesQueries.selectAll(limit).executeAsList().map { it.toModel() }
    }

    fun getMovieById(id: Int) : Movie? {
        return moviesQueries.selectById(id).executeAsOneOrNull()?.toModel()
    }

    fun createMovie(movie: Movie): Long {
        return moviesQueries.transactionWithResult {
            moviesQueries.insert(movie.name, movie.genre, movie.leadStudio, movie.worldwideGross, movie.year)
            moviesQueries.lastInsertRowId().executeAsOne()
        }
    }

    fun updateRTScore(id: Int, rottenTomatoesScore: Int): Movie? {
        return moviesQueries.transactionWithResult {
            moviesQueries.updateRTScore(rottenTomatoesScore, id)
            moviesQueries.selectById(id).executeAsOneOrNull()?.toModel()
        }
    }
}