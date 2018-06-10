
package stageonepopmovies.udacity.com.popularmoviesstageone.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Result implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mAdult);
        dest.writeString(this.mBackdropPath);
        dest.writeList(this.mGenreIds);
        dest.writeValue(this.mId);
        dest.writeString(this.mOriginalLanguage);
        dest.writeString(this.mOriginalTitle);
        dest.writeString(this.mOverview);
        dest.writeValue(this.mPopularity);
        dest.writeString(this.mPosterPath);
        dest.writeString(this.mReleaseDate);
        dest.writeString(this.mTitle);
        dest.writeValue(this.mVideo);
        dest.writeValue(this.mVoteAverage);
        dest.writeValue(this.mVoteCount);
    }

    public Result() {
    }

    protected Result(Parcel in) {
        this.mAdult = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.mBackdropPath = in.readString();
        this.mGenreIds = new ArrayList<Long>();
        in.readList(this.mGenreIds, Long.class.getClassLoader());
        this.mId = (Long) in.readValue(Long.class.getClassLoader());
        this.mOriginalLanguage = in.readString();
        this.mOriginalTitle = in.readString();
        this.mOverview = in.readString();
        this.mPopularity = (Double) in.readValue(Double.class.getClassLoader());
        this.mPosterPath = in.readString();
        this.mReleaseDate = in.readString();
        this.mTitle = in.readString();
        this.mVideo = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.mVoteAverage = (Double) in.readValue(Double.class.getClassLoader());
        this.mVoteCount = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}
