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
data class TmdbDetailsFilmResult(
    val page: Int = 0,
    val results: List<TmdbDetailsFilm> = listOf()
)

data class TmdbDetailsFilm(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: Any,
    val budget: Int,
    val credits: Credits,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) {

}


// Details d'une série

data class TmdbDetailsTvResult(
    val page: Int = 0,
    val results: List<TmdbDetailsTv> = listOf()
)
data class TmdbDetailsTv(
    val adult: Boolean,
    val backdrop_path: String,
    val created_by: List<CreatedBy>,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val homepage: String,
    val id: Int,
    val in_production: Boolean,
    val languages: List<String>,
    val last_air_date: String,
    val last_episode_to_air: LastEpisodeToAir,
    val name: String,
    val networks: List<Network>,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val seasons: List<Season>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
    val vote_count: Int,
    val credits: Credits
)

data class CreatedBy(
    val id: Int,
    val credit_id: String,
    val name: String,
    val gender: Int,
    val profile_path: String?
)

data class LastEpisodeToAir(
    val id: Int,
    val name: String,
    val overview: String,
    val vote_average: Double,
    val vote_count: Int,
    val air_date: String,
    val episode_number: Int,
    val episode_type: String,
    val production_code: String,
    val runtime: Int,
    val season_number: Int,
    val show_id: Int,
    val still_path: String?
)

data class Network(
    val id: Int,
    val logo_path: String?,
    val name: String,
    val origin_country: String
)

data class Season(
    val air_date: String,
    val episode_count: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String?,
    val season_number: Int,
    val vote_average: Double
)

data class Credits(
    val cast: List<Cast>,
    val crew: List<Crew>
)

data class Cast(
    val adult: Boolean,
    val gender: Int,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String?,
    val character: String,
    val credit_id: String,
    val order: Int
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
    val profile_path: String?
)

// liste acteurs

data class TmdbPersonResult(
    val page: Int,
    val results: List<TmdbPerson>
)

data class TmdbPerson(
    val adult: Boolean,
    val id: Int,
    val name: String,
    val original_name: String,
    val media_type: String,
    val popularity: Double,
    val gender: Int,
    val known_for_department: String,
    val profile_path: String?,
    val known_for: List<KnownFor>
)

data class KnownFor(
    val adult: Boolean,
    val backdrop_path: String,
    val id: Int,
    val title: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val media_type: String,
    val genre_ids: List<Int>,
    val popularity: Double,
    val release_date: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)
