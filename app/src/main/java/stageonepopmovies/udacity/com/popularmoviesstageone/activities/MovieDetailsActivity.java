package stageonepopmovies.udacity.com.popularmoviesstageone.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import stageonepopmovies.udacity.com.popularmoviesstageone.R;
import stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView mPictureImage;
    private ImageView mLeftNavigation;
    private TextView mMovieTitle;
    private TextView mReleaseDate;

    private TextView mVoteAverage;
    private TextView mOverView;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details_activitty);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mPictureImage = findViewById(R.id.iv_movie_image);
        mLeftNavigation = findViewById(R.id.iv_left_navigation);
        mMovieTitle = findViewById(R.id.tv_movie_title);
        mReleaseDate = findViewById(R.id.tv_movie_release_date);
        mVoteAverage = findViewById(R.id.tv_movie_vote_average);
        mOverView = findViewById(R.id.tv_movie_overview);

        String loadPictureUrl = MovieConstants.MOVIE_IMAGE_URL + getIntent().getExtras().getString(MovieConstants.MOVIE_POSTER_VIEWS);
        if (loadPictureUrl != null) {

            Picasso.get().load(loadPictureUrl).into(mPictureImage);

        }
        mMovieTitle.setText(getIntent().getExtras().getString(MovieConstants.MOVIE_TITLE));
        mReleaseDate.setText(getIntent().getExtras().getString(MovieConstants.MOVIE_RELEASE_DATE));
        mVoteAverage.setText(getIntent().getExtras().getString(MovieConstants.MOVIE_VOTE_AVERAGE));
        mOverView.setText(getIntent().getExtras().getString(MovieConstants.MOVIE_OVERVIEW));
        mLeftNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
