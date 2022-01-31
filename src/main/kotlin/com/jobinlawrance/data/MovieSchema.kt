package com.jobinlawrance.data

import com.apurebase.kgraphql.KGraphQL

class MovieSchema(val movieRepository: MovieRepository) {
    val schema = KGraphQL.schema {
        query("movies") {
            resolver { size: Long ->  }.withArgs {
                arg<Long> { name = "size"}
            }
        }
        type<Movie>() {
            description = "Movie object with attribute film\n" +
                    "genre\n" +
                    "leadStudio\n" +
                    "audienceScore\n" +
                    "profitability\n" +
                    "rottenTomatoes\n" +
                    "worldwideGross\n" +
                    "year"
        }
    }
}