package stageonepopmovies.udacity.com.popularmoviesstageone.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieVideosResponse {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("results")
    @Expose
    private List<ResultsItem> results;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setResults(List<ResultsItem> results) {
        this.results = results;
    }

    public List<ResultsItem> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return
                "MovieVideosResponse{" +
                        "id = '" + id + '\'' +
                        ",results = '" + results + '\'' +
                        "}";
    }
}