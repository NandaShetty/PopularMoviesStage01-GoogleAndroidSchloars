
package stageonepopmovies.udacity.com.popularmoviesstageone.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PopularMovieResponse {

    @SerializedName("page")
    private Long mPage;
    @SerializedName("results")
    private List<Result> mResults;
    @SerializedName("total_pages")
    private Long mTotalPages;
    @SerializedName("total_results")
    private Long mTotalResults;

    public Long getPage() {
        return mPage;
    }

    public List<Result> getResults() {
        return mResults;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public Long getTotalResults() {
        return mTotalResults;
    }

    public static class Builder {

        private Long mPage;
        private List<Result> mResults;
        private Long mTotalPages;
        private Long mTotalResults;

        public PopularMovieResponse.Builder withPage(Long page) {
            mPage = page;
            return this;
        }

        public PopularMovieResponse.Builder withResults(List<Result> results) {
            mResults = results;
            return this;
        }

        public PopularMovieResponse.Builder withTotalPages(Long totalPages) {
            mTotalPages = totalPages;
            return this;
        }

        public PopularMovieResponse.Builder withTotalResults(Long totalResults) {
            mTotalResults = totalResults;
            return this;
        }

        public PopularMovieResponse build() {
            PopularMovieResponse popularMovieResponse = new PopularMovieResponse();
            popularMovieResponse.mPage = mPage;
            popularMovieResponse.mResults = mResults;
            popularMovieResponse.mTotalPages = mTotalPages;
            popularMovieResponse.mTotalResults = mTotalResults;
            return popularMovieResponse;
        }

    }

}
