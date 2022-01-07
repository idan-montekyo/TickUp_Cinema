package Classes;

// Create a class for managing screening time for each movie.
public class Screening {

    // Fields
    private static int ID = 0;

    private Theater theater;
    private final String startingTime;
    private final int screeningID;
    private final EnumSeats[][] theaterMatrix;
    private final int rows;
    private final int cols;

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

        this.rows = this.theater.getNumRows();
        this.cols = this.theater.getNumCols();
        theaterMatrix = new EnumSeats[this.rows][this.cols];
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                this.theaterMatrix[row][col] = EnumSeats.AVAILABLE;
            }
        }
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

    public EnumSeats[][] getTheaterMatrix() {
        return theaterMatrix;
    }

    // Select a valid seat
    public boolean selectSeat(int row, int col){
        if(this.theaterMatrix[row][col].equals(EnumSeats.AVAILABLE) && (row < this.rows && row >= 0) && (col < this.cols && col >= 0)) {
            this.theaterMatrix[row][col] = EnumSeats.TAKEN;
            System.out.println("Seats has selected!");
            return true;
        }
        else {
            System.out.println(("This seat is occupied or illegal!"));
            return false;
        }
    }

    // Cancel a seat
    public boolean CancelSeat(int row, int col){
        if(row > this.rows || rows <= 0 || col > this.cols && col <= 0){
            System.out.println(("Error!"));
            return false;
        }
        else if(this.theaterMatrix[row][col].equals(EnumSeats.TAKEN)) {
            this.theaterMatrix[row][col] = EnumSeats.AVAILABLE;
            System.out.println("Seat has canceled!");
            return true;
        }
        else {
            System.out.println(("Error!"));
            return false;
        }
    }
}

