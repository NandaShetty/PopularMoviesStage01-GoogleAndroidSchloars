package stageonepopmovies.udacity.com.popularmoviesstageone.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import stageonepopmovies.udacity.com.popularmoviesstageone.R;

import stageonepopmovies.udacity.com.popularmoviesstageone.models.ResultsItem;

import static stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants.YOUTUBE_END_POINT_URL;
import static stageonepopmovies.udacity.com.popularmoviesstageone.utils.MovieConstants.YOUTUBE_MOVIE_THUMBNAIL_URL;

public class MovieDetailsAdapter extends RecyclerView.Adapter<MovieDetailsAdapter.ItemHolder> {

    private List<ResultsItem> movieResponseList;
    private Context mContext;

    public MovieDetailsAdapter(List<ResultsItem> movieResponses, Context context) {
        this.movieResponseList = movieResponses;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details, parent, false);


        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, @SuppressLint("RecyclerView") final int position) {


        /*bind the view from the list*/
        final String movieImageUrl = YOUTUBE_MOVIE_THUMBNAIL_URL + movieResponseList.get(position).getKey() + "/0.jpg";
        final String openYoutube = YOUTUBE_END_POINT_URL + movieResponseList.get(position).getKey();
        Log.d("MovieImageUrl", "youtube load url" + openYoutube);
        Picasso.get().load(movieImageUrl)
                .into(holder.movieView);
        holder.movieView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(openYoutube)));


            }
        });


    }

    @Override
    public int getItemCount() {
        if (movieResponseList == null) {
            return 0;
        }
        return movieResponseList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private ImageView movieView;

        public ItemHolder(View itemView) {
            super(itemView);
            movieView = itemView.findViewById(R.id.iv_movies);
        }
    }
}
