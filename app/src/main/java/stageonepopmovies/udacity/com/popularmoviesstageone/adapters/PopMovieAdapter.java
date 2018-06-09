package stageonepopmovies.udacity.com.popularmoviesstageone.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import stageonepopmovies.udacity.com.popularmoviesstageone.MovieApplication;
import stageonepopmovies.udacity.com.popularmoviesstageone.R;
import stageonepopmovies.udacity.com.popularmoviesstageone.activities.MovieDetailsActivity;
import stageonepopmovies.udacity.com.popularmoviesstageone.models.PopularMovieResponse;
import stageonepopmovies.udacity.com.popularmoviesstageone.models.Result;
import stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants;

public class PopMovieAdapter extends RecyclerView.Adapter<PopMovieAdapter.ItemHolder> {

    private List<Result> movieResponseList;
    private Context mContext;


    public PopMovieAdapter(List<Result> movieResponses, Context context) {
        this.movieResponseList = movieResponses;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list, parent, false);


        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, @SuppressLint("RecyclerView") final int position) {


        /*bind the view fro the list*/
        final String movieImageUrl = MovieConstants.MOVIE_IMAGE_URL.concat(movieResponseList.get(position).getPosterPath());

        Picasso.get().load(movieImageUrl).into(holder.movieView);

        holder.movieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MovieDetailsActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString(MovieConstants.MOVIE_TITLE, movieResponseList.get(position).getTitle());
                bundle.putString(MovieConstants.MOVIE_POSTER_VIEWS, movieResponseList.get(position).getPosterPath());
                bundle.putString(MovieConstants.MOVIE_RELEASE_DATE, movieResponseList.get(position).getReleaseDate());
                bundle.putString(MovieConstants.MOVIE_OVERVIEW, movieResponseList.get(position).getOverview());
                bundle.putString(MovieConstants.MOVIE_VOTE_AVERAGE, String.valueOf(movieResponseList.get(position).getVoteAverage()));
                bundle.putString(MovieConstants.MOVIE_POPULARITY, String.valueOf(movieResponseList.get(position).getPopularity()));
                intent.putExtras(bundle);

                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return movieResponseList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private ImageView movieView;

        public ItemHolder(View itemView) {
            super(itemView);
            movieView = (ImageView) itemView.findViewById(R.id.iv_movies);
        }
    }
}
