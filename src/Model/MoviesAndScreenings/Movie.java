package Model.MoviesAndScreenings;

import java.util.ArrayList;

// Class for a specific movie
public class Movie {
    // fields
    private final String movieName;
    private final int serialNumber;
    private final String imagePath;
    private final String summary;
    private final int duration;
    private final ArrayList<Screening> screeningsTime;

    // Constructor
    public Movie(String movieName, int serialNumber, String imagePath, String summary, int duration, ArrayList<Screening> screeningsTime) {
        this.movieName = movieName;
        this.serialNumber = serialNumber;
        this.imagePath = imagePath;
        this.summary = summary;
        this.duration = duration;
        this.screeningsTime = screeningsTime;
    }

    // Getters
    public String getMovieName() {
        return movieName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getSummary() {
        return summary;
    }

    public int getDuration() {
        return duration;
    }

    public ArrayList<Screening> getScreeningsTime() {
        return screeningsTime;
    }

    @Override
    public String toString() {
        return "Movie Name " + movieName + ", Duration " + duration
                + "\n\nSummary: " + summary
                + "\n\nScreenings:\n" + screeningsTime;
    }
}
