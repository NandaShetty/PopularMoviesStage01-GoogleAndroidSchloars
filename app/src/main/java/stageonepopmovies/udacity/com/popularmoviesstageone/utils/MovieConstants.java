package stageonepopmovies.udacity.com.popularmoviesstageone.utils;

import stageonepopmovies.udacity.com.popularmoviesstageone.BuildConfig;
import stageonepopmovies.udacity.com.popularmoviesstageone.R;

public class MovieConstants {
    private MovieConstants() {

    }
    public static final String MOVIE_IMAGE_URL = "http://image.tmdb.org/t/p/w185/";
    public static final String MOST_POPULAR_MOVIES_URL = "http://api.themoviedb.org/3/movie/popular?api_key=" + "b6b7a875d978c3b553d11ffae6765aee";
    public static final String MOST_TOP_RATED_MOVIES_URL = "http://api.themoviedb.org/3/movie/top_rated?api_key=" + "b6b7a875d978c3b553d11ffae6765aee";
    public static final String TRAILERS_END_POINT_URL = "https://api.themoviedb.org/3/movie/{id}/videos?api_key=" + "b6b7a875d978c3b553d11ffae6765aee";
    public static final String REVIEWS_END_POINT_URL = "";
    public static final String YOUTUBE_END_POINT_URL = "https://www.youtube.com/watch?v=";
    public static final String YOUTUBE_MOVIE_THUMBNAIL_URL = "https://img.youtube.com/vi/";
    public static final String MOVIE_TITLE = "movie_title";
    public static final String MOVIE_RELEASE_DATE = "movie_release_date";
    public static final String MOVIE_OVERVIEW = "movie_overView";
    public static final String MOVIE_VOTE_AVERAGE = "movie_vote_average";
    public static final String MOVIE_POSTER_VIEWS = "movie_poster_paths";
    public static final String MOVIE_POPULARITY = "movie_popularity";
    public static final String POPULAR_MOVIES = "Most Popular";
    public static final String TOP_RATED = "Top Rated";
    public static final String MOVIE_ID = "movie_id";
}
