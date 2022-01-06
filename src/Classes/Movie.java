package Classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Create a class for a specific movie
public class Movie {

    // fields
    private final String movieName;
    private final int serialNumber;
    private final int duration;
    private final List<Screening> screeningsTime;

    // Constructor
    public Movie(String movieName, int serialNumber, int duration, ArrayList<Screening> screeningsTime) {
        this.movieName = movieName;
        this.serialNumber = serialNumber;
        this.duration = duration;
        this.screeningsTime = screeningsTime;
    }

    @Override
    public String toString() {
        return "Movie Name " + this.movieName + ", Duration " + this.duration
                + "\nScreenings:\n" + this.screeningsTime;
    }

    // Getters
    public String getMovieName() {
        return movieName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getDuration() {
        return duration;
    }

    public List<Screening> getScreeningsTime() {
        return screeningsTime;
    }


}
