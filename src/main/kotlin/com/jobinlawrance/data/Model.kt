package com.jobinlawrance.data

import com.jobinlawrance.sqldelight.Movies
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val name: String?,
    val genre: String?,
    val leadStudio: String?,
    val audienceScore: Int?,
    val profitability: Double?,
    val rottenTomatoes: Int?,
    val worldwideGross: String?,
    val year: Int?
) {
    constructor(dbModel: Movies) : this(
        id = dbModel.Id,
        name = dbModel.Name,
        genre = dbModel.Genre,
        leadStudio = dbModel.Lead_Studio,
        audienceScore = dbModel.Audience_score,
        profitability = dbModel.Profitability,
        rottenTomatoes = dbModel.Rotten_Tomatoes,
        worldwideGross = dbModel.Worldwide_Gross,
        year = dbModel.Year
    )
}