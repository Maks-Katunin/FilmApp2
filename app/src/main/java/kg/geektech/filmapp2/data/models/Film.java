package kg.geektech.filmapp2.data.models;

import com.google.gson.annotations.SerializedName;

public class Film {
    @SerializedName("id")
    String id;
    @SerializedName("title")
    String title;
    @SerializedName("original_title")
    String originalTitle;
    @SerializedName("description")
    String description;
    @SerializedName("director")
    String director;
    @SerializedName("producer")
    String producer;
    @SerializedName("release_date")
    String releaseDate;
    @SerializedName("running_time")
    String runningTime;
    @SerializedName("movie_banner")
    String movieBanner;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRunningTime() {
        return runningTime;
    }

    public String getMovieBanner() {
        return movieBanner;
    }

    public String getDescription() {
        return description;
    }
}
