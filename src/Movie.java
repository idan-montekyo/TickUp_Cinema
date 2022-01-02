import java.util.ArrayList;

public class Movie {

    // fields

    private String movieName;
    private int serialNumber;
    private int duration;



   // private ArrayList<Screenings> screeningsTime = new ArrayList<Screenings>();


    // Constructor
// public Movie(String movieName, int serialNumber, int duration, ArrayList<Screenings> screeningsTime)
    public Movie(String movieName, int serialNumber, int duration, int i) {
        this.movieName = movieName;
        this.serialNumber = serialNumber;
        this.duration = duration;
       // this.screeningsTime = screeningsTime;
    }

    @Override
    public String toString() {
        return "Movie Name " + this.movieName + ", Duration " + this.duration;
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
 /*
    public ArrayList<Screenings> getScreeningsTime() {
        return screeningsTime;
    }

 */
}
