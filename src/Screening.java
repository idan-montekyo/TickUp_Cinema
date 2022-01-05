// Create a class for manage screening time for each movie

public class Screening {

    // Fields

    private static int ID = 0;

    private Theater theater;
    private final String startingTime;
    private final int screeningID;

    // Constructor

    // public Screening(int theater_type, int theaterNumber, ScreeningTime st)
    public Screening(EnumTheaterType theater_type, int theaterNumber, String st) {
        switch (theater_type) {
            case THEATER_STANDARD -> this.theater = new StandardTheater(theaterNumber);
            case THEATER_THREE_D -> this.theater = new MultiDimTheater(theaterNumber, EnumDimensions.ThreeD);
            case THEATER_FOUR_D -> this.theater = new MultiDimTheater(theaterNumber, EnumDimensions.FourD);
            case THEATER_IMAX -> this.theater = new MultiDimTheater(theaterNumber, EnumDimensions.IMAX);
            case THEATER_VIP -> this.theater = new VipTheater(theaterNumber);
        }

        if(!(st == null)) {
            startingTime = st;
        }
        else {
            startingTime = "CANCELLED";
        }

        this.screeningID = ID;
        ID++;
    }

    @Override
    public String toString() {
        return "Screening id " + this.screeningID + "\nScreening start time " + this.startingTime
                + "\nTheater info:\n" + this.theater + "\n";
    }
}
