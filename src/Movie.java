import java.util.ArrayList;

public class Movie {

    // fields

    private String movieName;
    private int serialNumber;
    private int duration;
    private ArrayList<Screenings> screeningsTime = new ArrayList<Screenings>();


    // Constructor

    public Movie(String movieName, int serialNumber, int duration, ArrayList<Screenings> screeningsTime) {
        this.movieName = movieName;
        this.serialNumber = serialNumber;
        this.duration = duration;
        this.screeningsTime = screeningsTime;
    }

    @Override
    public String toString() {
        return "Movie Name " + this.movieName + "";
    }
}
