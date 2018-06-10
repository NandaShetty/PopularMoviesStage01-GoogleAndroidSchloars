package stageonepopmovies.udacity.com.popularmoviesstageone.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import stageonepopmovies.udacity.com.popularmoviesstageone.R;
import stageonepopmovies.udacity.com.popularmoviesstageone.adapters.PopMovieAdapter;
import stageonepopmovies.udacity.com.popularmoviesstageone.models.PopularMovieResponse;
import stageonepopmovies.udacity.com.popularmoviesstageone.models.Result;
import stageonepopmovies.udacity.com.popularmoviesstageone.utils.NetworkUtils;

import static stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants.MOST_POPULAR_MOVIES_URL;
import static stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants.MOST_TOP_RATED_MOVIES_URL;

public class MovieActivity extends AppCompatActivity {

    public MovieActivity activity;
    private String moviePopularSelected;
    private String moveTopRatedSelected;


    private int id;
    public static final String TAG = MovieActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    private PopMovieAdapter popMovieAdapter;
    private List<Result> popularMovieResponseList;
    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        // Adding an Network Interceptor for Debugging purpose :
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.activity = MovieActivity.this;

        mRecyclerView = findViewById(R.id.rv_movies);
        popularMovieResponseList = new ArrayList<>();
        coordinatorLayout = findViewById(R.id.movie_layout);


    }


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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_most_popular) {
            fetchThePopularMovies();
            return true;
        } else if (id == R.id.action_top_rated) {
            fetchTheTopRatedMovies();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void fetchTheTopRatedMovies() {


        try {

            if (NetworkUtils.isOnline(MovieActivity.this)) {


                Rx2AndroidNetworking.get(MOST_TOP_RATED_MOVIES_URL)
                        .build()
                        .getObjectObservable(PopularMovieResponse.class)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<PopularMovieResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(PopularMovieResponse response) {

                                if (response != null) {
                                    Log.d(TAG, "MOVIE_RESULTS" + response.getResults());
                                    popularMovieResponseList = response.getResults();
                                    mLayoutManager = new GridLayoutManager(MovieActivity.this, numberOfColumns());
                                    mRecyclerView.setLayoutManager(mLayoutManager);

                                    popMovieAdapter = new PopMovieAdapter(popularMovieResponseList, activity);
                                    mRecyclerView.setAdapter(popMovieAdapter);
                                    popMovieAdapter.notifyDataSetChanged();

                                }


                            }


                            @Override
                            public void onError(Throwable e) {


                                Toast.makeText(MovieActivity.this, "Data not loaded properly", Toast.LENGTH_SHORT).show();


                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            } else {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
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

    }

    private void fetchThePopularMovies() {
        try {

            if (NetworkUtils.isOnline(MovieActivity.this)) {


                Rx2AndroidNetworking.get(MOST_POPULAR_MOVIES_URL)
                        .build()
                        .getObjectObservable(PopularMovieResponse.class)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<PopularMovieResponse>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(PopularMovieResponse response) {

                                if (response != null) {
                                    Log.d(TAG, "MOVIE_RESULTS" + response.getResults());
                                    popularMovieResponseList = response.getResults();
                                    mLayoutManager = new GridLayoutManager(MovieActivity.this, numberOfColumns());
                                    mRecyclerView.setLayoutManager(mLayoutManager);

                                    popMovieAdapter = new PopMovieAdapter(popularMovieResponseList, activity);
                                    mRecyclerView.setAdapter(popMovieAdapter);
                                    popMovieAdapter.notifyDataSetChanged();

                                }


                            }


                            @Override
                            public void onError(Throwable e) {


                                Toast.makeText(MovieActivity.this, "Data not loaded properly", Toast.LENGTH_SHORT).show();


                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            } else {
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
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

    }


    private int numberOfColumns() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        // You can change this divider to adjust the size of the poster
        int widthDivider = 500;
        int width = displayMetrics.widthPixels;
        int nColumns = width / widthDivider;
        if (nColumns < 2) return 2;
        return nColumns;
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchThePopularMovies();

    }
}
