package stageonepopmovies.udacity.com.popularmoviesstageone.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import stageonepopmovies.udacity.com.popularmoviesstageone.R;
import stageonepopmovies.udacity.com.popularmoviesstageone.adapters.MovieDetailsAdapter;
import stageonepopmovies.udacity.com.popularmoviesstageone.adapters.MovieDetailsReviewAdapter;
import stageonepopmovies.udacity.com.popularmoviesstageone.models.MovieVideosResponse;
import stageonepopmovies.udacity.com.popularmoviesstageone.models.moviereview.MovieReviewResponse;
import stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants;
import stageonepopmovies.udacity.com.popularmoviesstageone.utils.NetworkUtils;
import stageonepopmovies.udacity.com.popularmoviesstageone.utils.SimpleDividerItemDecoration;

import static stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants.REVIEWS_END_POINT_URL;
import static stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants.TRAILERS_END_POINT_URL;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView mPictureImage;
    private TextView mReleaseDate;
    private TextView mVoteAverage;
    private TextView mOverView;
    private Toolbar mToolbar;
    private TextView mPopularity;
    private ProgressBar mProgress;
    private String moviePopularSelected;
    private String moveTopRatedSelected;
    private RecyclerView rvloadtheMovie, mReviews_horizontal;
    private ConstraintLayout mConstraintLayout;

    @SuppressLint("CutPasteId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mPictureImage = findViewById(R.id.iv_movie_image);
        mReleaseDate = findViewById(R.id.tv_movie_release_date);
        mVoteAverage = findViewById(R.id.tv_movie_vote_average);
        mOverView = findViewById(R.id.tv_movie_overview);
        mPopularity = findViewById(R.id.tv_movie_popularity);
        mProgress = findViewById(R.id.pb_loading);
        mProgress.setVisibility(View.VISIBLE);
        mToolbar = findViewById(R.id.toolbar);
        mConstraintLayout = findViewById(R.id.movie_details_layout);
        rvloadtheMovie = findViewById(R.id.rv_movies_horizontal);
        mReviews_horizontal = findViewById(R.id.rv_reviews_horizontal);
        setSupportActionBar(mToolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(Objects.requireNonNull(getIntent().getExtras()).getString(MovieConstants.MOVIE_TITLE));
        }


        try {

            String loadPictureUrl = MovieConstants.MOVIE_IMAGE_URL + getIntent().getExtras().getString(MovieConstants.MOVIE_POSTER_VIEWS);
            if (loadPictureUrl != null) {

                Picasso.get().load(loadPictureUrl).into(mPictureImage);

            }
            mReleaseDate.setText(getIntent().getExtras().getString(MovieConstants.MOVIE_RELEASE_DATE));
            mVoteAverage.setText(getIntent().getExtras().getString(MovieConstants.MOVIE_VOTE_AVERAGE).concat("/10"));
            mOverView.setText(getIntent().getExtras().getString(MovieConstants.MOVIE_OVERVIEW));

            mPopularity.setText(getIntent().getExtras().getString(MovieConstants.MOVIE_POPULARITY));


        } catch (Exception e) {

            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        /*API request to load the trailers*/
        try {

            if (NetworkUtils.isOnline(MovieDetailsActivity.this)) {


                Rx2AndroidNetworking.get(TRAILERS_END_POINT_URL)
                        .addPathParameter("id", String.valueOf(getIntent().getExtras().getLong(MovieConstants.MOVIE_ID)))
                        .build()
                        .getObjectObservable(MovieVideosResponse.class)
                        .subscribeOn(Schedulers.io())//worker thread
                        .observeOn(AndroidSchedulers.mainThread())//main thread
                        .subscribe(new Observer<MovieVideosResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                                //d.dispose();
                            }

                            @Override
                            public void onNext(MovieVideosResponse movieVideosResponse) {

                                if (movieVideosResponse != null) {
                                    rvloadtheMovie.setHasFixedSize(true);
                                    Log.d("MovieDetails", "onNext: " + movieVideosResponse.getResults());
                                    rvloadtheMovie.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                                    String youtubekey = movieVideosResponse.getResults().get(0).getKey();
                                    Log.d("Movie Details", "Youtube key:" + youtubekey);
                                    rvloadtheMovie.setAdapter(new MovieDetailsAdapter(movieVideosResponse.getResults(), getApplicationContext()));
                                    new MovieDetailsAdapter(movieVideosResponse.getResults(), getApplicationContext()).notifyDataSetChanged();
                                }
                            }


                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(MovieDetailsActivity.this, "Data not loaded properly", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            } else {
                Snackbar snackbar = Snackbar
                        .make(mConstraintLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

// Changing message text color
                snackbar.setActionTextColor(Color.RED);

// Changing action button text color
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Oops something went wrong!!", Toast.LENGTH_SHORT).show();
        }

        /*API request to load the movie review*/
        try {

            if (NetworkUtils.isOnline(MovieDetailsActivity.this)) {


                Rx2AndroidNetworking.get(REVIEWS_END_POINT_URL)
                        .addPathParameter("id", String.valueOf(getIntent().getExtras().getLong(MovieConstants.MOVIE_ID)))
                        .build()
                        .getObjectObservable(MovieReviewResponse.class)
                        .subscribeOn(Schedulers.io())//worker thread
                        .observeOn(AndroidSchedulers.mainThread())//main thread
                        .subscribe(new Observer<MovieReviewResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                                //d.dispose();
                            }

                            @Override
                            public void onNext(MovieReviewResponse movieReviewResponse) {

                                if (movieReviewResponse != null) {
                                    mReviews_horizontal.setHasFixedSize(true);
                                    Log.d("MovieReviewDetails", "onNext: " + movieReviewResponse.getResults());
                                    mReviews_horizontal.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                                    mReviews_horizontal.addItemDecoration(new SimpleDividerItemDecoration(getApplicationContext()));
                                    mReviews_horizontal.setAdapter(new MovieDetailsReviewAdapter(movieReviewResponse.getResults(), getApplicationContext()));
                                    new MovieDetailsReviewAdapter(movieReviewResponse.getResults(), getApplicationContext()).notifyDataSetChanged();
                                }
                            }


                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(MovieDetailsActivity.this, "Data not loaded properly", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            } else {
                Snackbar snackbar = Snackbar
                        .make(mConstraintLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

// Changing message text color
                snackbar.setActionTextColor(Color.RED);

// Changing action button text color
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Oops something went wrong!!", Toast.LENGTH_SHORT).show();
        }


    }//end of on_create

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (null != savedInstanceState) {
            moviePopularSelected = savedInstanceState.getString("MOVIE_POPULAR_MOVIES");
            moveTopRatedSelected = savedInstanceState.getString("MOVIE_TOP_RATED");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("MOVIE_POPULAR_MOVIES", moviePopularSelected);
        outState.putString("MOVIE_TOP_RATED", moveTopRatedSelected);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mProgress.setVisibility(View.INVISIBLE);

    }
}
