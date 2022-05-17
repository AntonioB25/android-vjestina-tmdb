package com.e.tmdb.networking

import com.e.tmdb.R
import com.e.tmdb.models.MovieSearchResponse
import com.e.tmdb.models.movie.Movie
import com.e.tmdb.models.movie.MovieResponse
import com.e.tmdb.models.movieCredits.CastMember
import com.e.tmdb.models.movieCredits.CrewMember
import com.e.tmdb.models.movieCredits.MovieCredits
import com.e.tmdb.models.movieCredits.MovieCreditsResponse
import com.e.tmdb.models.movieDetails.MovieDetails
import com.e.tmdb.models.movieDetails.MovieDetailsResponse
import com.e.tmdb.models.movieDetails.MovieGenre
import com.e.tmdb.models.movieDetails.ProductionCountry
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface MovieApi {
    fun getPopularMovies(): Flow<MovieResponse>
    fun getNowPlayingMovies(): Flow<MovieResponse>
    fun getUpcomingMovies(): Flow<MovieResponse>
    fun getTopRatedMovies(): Flow<MovieResponse>
    fun getMovieDetails(movieId: Int): Flow<MovieDetailsResponse>
    fun getMovieCredits(movieId: Int): Flow<MovieCreditsResponse>
    fun getSearchMovie(query: String): Flow<MovieSearchResponse>
}

internal class MovieApiImpl : MovieApi {
    override fun getPopularMovies(): Flow<MovieResponse> = flowOf(
        MovieResponse(
            //TODO: Change to server calls
            movies = listOf(
                Movie(1, "Ironman", R.drawable.ironman),
                Movie(2, "Ironman", R.drawable.ironman),
                Movie(3, "Ironman", R.drawable.ironman),
                Movie(4, "Ironman", R.drawable.ironman),
                Movie(5, "Ironman", R.drawable.ironman),
                Movie(6, "Ironman", R.drawable.ironman)
            )
        )
    )


    override fun getNowPlayingMovies(): Flow<MovieResponse> = flowOf(
        //TODO: Change to server calls
        MovieResponse(
            movies = listOf(
                Movie(1, "Godzzila", R.drawable.godzzila),
                Movie(2, "Godzzila", R.drawable.godzzila),
                Movie(3, "Godzzila", R.drawable.godzzila),
                Movie(4, "Godzzila", R.drawable.godzzila),
                Movie(5, "Godzzila", R.drawable.godzzila),
                Movie(6, "Godzzila", R.drawable.godzzila),
            )
        )
    )

    override fun getUpcomingMovies(): Flow<MovieResponse> = flowOf(
        //TODO: Change to server calls
        MovieResponse(
            movies = listOf(
                Movie(1, "Puppy Love", R.drawable.puppy_love),
                Movie(2, "Puppy Love", R.drawable.puppy_love),
                Movie(3, "Puppy Love", R.drawable.puppy_love),
                Movie(4, "Puppy Love", R.drawable.puppy_love),
                Movie(5, "Puppy Love", R.drawable.puppy_love),
                Movie(6, "Puppy Love", R.drawable.puppy_love)
            )
        )
    )

    override fun getTopRatedMovies(): Flow<MovieResponse> = flowOf(
        //TODO: Change to server calls
        MovieResponse(
            movies = listOf(
                Movie(1, "Puppy Love", R.drawable.puppy_love),
                Movie(2, "Godzzila", R.drawable.godzzila),
                Movie(3, "Puppy Love", R.drawable.puppy_love),
                Movie(4, "Godzzila", R.drawable.godzzila),
                Movie(5, "Puppy Love", R.drawable.puppy_love),
                Movie(6, "Godzzila", R.drawable.godzzila),
            )
        )
    )

    override fun getMovieDetails(movieId: Int): Flow<MovieDetailsResponse> = flowOf(
        //TODO: add all variables to MovieDetails and MovieDetailsResponse and create it here
        MovieDetailsResponse(
            movieDetails = MovieDetails(
                2,
                "Iron Man",
                "path",
                R.drawable.ironman.toString(),
                listOf(MovieGenre(2, "action"), MovieGenre(3, "Science fiction")),
                "English",
                "Iron man",
                "After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.",
                "05/02/2008",
                128,
                listOf(ProductionCountry("US", "USA"))
            )
        )
    )

    override fun getMovieCredits(movieId: Int): Flow<MovieCreditsResponse> = flowOf(
        MovieCreditsResponse(
            movieCredits = MovieCredits(
                3,
                listOf(
                    CastMember(
                        2,
                        "Robert Downey Jr.",
                        "Tony Stark",
                        R.drawable.rdj.toString(),
                        2,
                        3,
                        4,
                        "Acting",
                        true,
                        0,
                    )
                ),
                listOf(
                    CrewMember(
                        1,
                        "Don Heck",
                        2,
                        "Director",
                        "Direction",
                        "Direction",
                        "nestonesto.jpg",
                    )
                )
            )
        )
    )

    override fun getSearchMovie(query: String): Flow<MovieSearchResponse> = flowOf(
        //TODO: Change to server calls
        MovieSearchResponse()
    )
}

