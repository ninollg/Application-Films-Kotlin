package com.ninoleliege.mmi.myapplication

// Films
data class TmdbMovieResult(
    val page: Int = 0,
    val results: List<TmdbMovie> = listOf()
)

data class TmdbMovie(
    val backdrop_path: String = "",
    val genre_ids: List<Int> = listOf(),
    val id: Int = 0,
    val original_title: String = "",
    val overview: String = "",
    val poster_path: String = "",
    val release_date: String = "",
    val title: String = ""
)


//Series
data class TmdbTvResult(
    val page: Int,
    val results: List<TmdbTv>,
    val total_pages: Int,
    val total_results: Int
)

data class TmdbTv(
    val adult: Boolean,
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int
)


//details d'un film
data class TmdbDetailsFilm(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val credits: Credits,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

data class Credits(
    val cast: List<Cast>,
    val crew: List<Crew>
)

data class Genre(
    val id: Int,
    val name: String
)

data class ProductionCompany(
    val id: Int,
    val logo_path: Any,
    val name: String,
    val origin_country: String
)

data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
)

data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)

data class Cast(
    val adult: Boolean,
    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val gender: Int,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val order: Int,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)

data class Crew(
    val adult: Boolean,
    val credit_id: String,
    val department: String,
    val gender: Int,
    val id: Int,
    val job: String,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)