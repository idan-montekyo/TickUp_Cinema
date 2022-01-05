import java.util.ArrayList;
import java.util.List;


// Crate a class which represent specific movie
public class Movie {

    // fields

    private String movieName;
    private int serialNumber;
    private int duration;
    private List<Screening> screeningsTime;

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
