package stageonepopmovies.udacity.com.popularmoviesstageone.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import stageonepopmovies.udacity.com.popularmoviesstageone.R;
import stageonepopmovies.udacity.com.popularmoviesstageone.models.moviereview.ResultsItem;

public class MovieDetailsReviewAdapter extends RecyclerView.Adapter<MovieDetailsReviewAdapter.ItemHolder> {

    private List<ResultsItem> movieResponseList;
    private Context mContext;

    public MovieDetailsReviewAdapter(List<ResultsItem> movieResponses, Context context) {
        this.movieResponseList = movieResponses;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_details_review, parent, false);


        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, @SuppressLint("RecyclerView") final int position) {


        /*bind the view from the list*/


            for (int i = 0; i < movieResponseList.size(); i++) {

                if(movieResponseList.size() == 0){
                    holder.tvReviewsView.setText(mContext.getResources().getString(R.string.no_data));
                }else{
                    holder.tvReviewsView.setText(mContext.getResources().getString(R.string.click_here_to_load_the_review) + " " + "by author" + " " + movieResponseList.get(position).getAuthor());
                }



            }



        holder.tvReviewsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(movieResponseList.get(position).getUrl())));


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
        private TextView tvReviewsView;

        public ItemHolder(View itemView) {
            super(itemView);
            tvReviewsView = itemView.findViewById(R.id.tv_reviews);
        }
    }
}
