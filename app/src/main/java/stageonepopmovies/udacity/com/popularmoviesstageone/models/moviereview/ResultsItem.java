package stageonepopmovies.udacity.com.popularmoviesstageone.models.moviereview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultsItem {

    @SerializedName("author")
    @Expose
    private String author;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("url")
    @Expose
    private String url;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return
                "ResultsItem{" +
                        "author = '" + author + '\'' +
                        ",id = '" + id + '\'' +
                        ",content = '" + content + '\'' +
                        ",url = '" + url + '\'' +
                        "}";
    }
}