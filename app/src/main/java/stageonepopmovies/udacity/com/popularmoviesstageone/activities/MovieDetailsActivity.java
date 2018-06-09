package stageonepopmovies.udacity.com.popularmoviesstageone.activities;

import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import stageonepopmovies.udacity.com.popularmoviesstageone.R;
import stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView mPictureImage;
    private TextView mReleaseDate;

    private TextView mVoteAverage;
    private TextView mOverView;
    private Toolbar mToolbar;
    private TextView mPopularity;
    private ProgressBar mProgress;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details_activity_new_one);
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
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getIntent().getExtras().getString(MovieConstants.MOVIE_TITLE));


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


    }

    @Override
    protected void onResume() {
        super.onResume();
        mProgress.setVisibility(View.INVISIBLE);

    }
}
