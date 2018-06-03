
package stageonepopmovies.udacity.com.popularmoviesstageone.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Result {

    @SerializedName("adult")
    private Boolean mAdult;
    @SerializedName("backdrop_path")
    private String mBackdropPath;
    @SerializedName("genre_ids")
    private List<Long> mGenreIds;
    @SerializedName("id")
    private Long mId;
    @SerializedName("original_language")
    private String mOriginalLanguage;
    @SerializedName("original_title")
    private String mOriginalTitle;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("popularity")
    private Double mPopularity;
    @SerializedName("poster_path")
    private String mPosterPath;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("video")
    private Boolean mVideo;
    @SerializedName("vote_average")
    private Double mVoteAverage;
    @SerializedName("vote_count")
    private Long mVoteCount;

    public Boolean getAdult() {
        return mAdult;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public List<Long> getGenreIds() {
        return mGenreIds;
    }

    public Long getId() {
        return mId;
    }

    public String getOriginalLanguage() {
        return mOriginalLanguage;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public Double getPopularity() {
        return mPopularity;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public Boolean getVideo() {
        return mVideo;
    }

    public Double getVoteAverage() {
        return mVoteAverage;
    }

    public Long getVoteCount() {
        return mVoteCount;
    }

    public static class Builder {

        private Boolean mAdult;
        private String mBackdropPath;
        private List<Long> mGenreIds;
        private Long mId;
        private String mOriginalLanguage;
        private String mOriginalTitle;
        private String mOverview;
        private Double mPopularity;
        private String mPosterPath;
        private String mReleaseDate;
        private String mTitle;
        private Boolean mVideo;
        private Double mVoteAverage;
        private Long mVoteCount;

        public Result.Builder withAdult(Boolean adult) {
            mAdult = adult;
            return this;
        }

        public Result.Builder withBackdropPath(String backdropPath) {
            mBackdropPath = backdropPath;
            return this;
        }

        public Result.Builder withGenreIds(List<Long> genreIds) {
            mGenreIds = genreIds;
            return this;
        }

        public Result.Builder withId(Long id) {
            mId = id;
            return this;
        }

        public Result.Builder withOriginalLanguage(String originalLanguage) {
            mOriginalLanguage = originalLanguage;
            return this;
        }

        public Result.Builder withOriginalTitle(String originalTitle) {
            mOriginalTitle = originalTitle;
            return this;
        }

        public Result.Builder withOverview(String overview) {
            mOverview = overview;
            return this;
        }

        public Result.Builder withPopularity(Double popularity) {
            mPopularity = popularity;
            return this;
        }

        public Result.Builder withPosterPath(String posterPath) {
            mPosterPath = posterPath;
            return this;
        }

        public Result.Builder withReleaseDate(String releaseDate) {
            mReleaseDate = releaseDate;
            return this;
        }

        public Result.Builder withTitle(String title) {
            mTitle = title;
            return this;
        }

        public Result.Builder withVideo(Boolean video) {
            mVideo = video;
            return this;
        }

        public Result.Builder withVoteAverage(Double voteAverage) {
            mVoteAverage = voteAverage;
            return this;
        }

        public Result.Builder withVoteCount(Long voteCount) {
            mVoteCount = voteCount;
            return this;
        }

        public Result build() {
            Result result = new Result();
            result.mAdult = mAdult;
            result.mBackdropPath = mBackdropPath;
            result.mGenreIds = mGenreIds;
            result.mId = mId;
            result.mOriginalLanguage = mOriginalLanguage;
            result.mOriginalTitle = mOriginalTitle;
            result.mOverview = mOverview;
            result.mPopularity = mPopularity;
            result.mPosterPath = mPosterPath;
            result.mReleaseDate = mReleaseDate;
            result.mTitle = mTitle;
            result.mVideo = mVideo;
            result.mVoteAverage = mVoteAverage;
            result.mVoteCount = mVoteCount;
            return result;
        }

    }

}
