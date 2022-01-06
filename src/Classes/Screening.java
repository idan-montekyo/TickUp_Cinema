package Classes;

// Create a class for managing screening time for each movie.
public class Screening {

    // Fields
    private static int ID = 0;

    private Theater theater;
    private final String startingTime;
    private final int screeningID;

    // Constructor
    public Screening(EnumTheaterType theater_type, int theaterNumber, String startingTime) {
        switch (theater_type) {
            case THEATER_STANDARD -> this.theater = new StandardTheater(theaterNumber);
            case THEATER_THREE_D -> this.theater = new MultiDimTheater(theaterNumber, EnumDimensions.ThreeD);
            case THEATER_FOUR_D -> this.theater = new MultiDimTheater(theaterNumber, EnumDimensions.FourD);
            case THEATER_IMAX -> this.theater = new MultiDimTheater(theaterNumber, EnumDimensions.IMAX);
            case THEATER_VIP -> this.theater = new VipTheater(theaterNumber);
        }

        if(!(startingTime == null)) {
            this.startingTime = startingTime;
        }
        else {
            this.startingTime = "CANCELLED";
        }

        this.screeningID = ID;
        ID++;
    }

    @Override
    public String toString() {
        return "Screening id " + this.screeningID + "\nScreening start time " + this.startingTime
                + "\nTheater info:\n" + this.theater + "\n";
    }

    // Getters
    public Theater getTheater() {
        return theater;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public int getScreeningID() {
        return screeningID;
    }
}
