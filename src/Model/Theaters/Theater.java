package Model.Theaters;

import Model.Enums.EnumSeats;

// Create an abstract class for theater.
public abstract class Theater {

    //Fields
    private final int numRows;
    private final int numCols;
    private final EnumSeats[][] seats;
    private final int price;
    private final int theaterNumber;

    // Constructor
    public Theater(int numRows, int numCols, int price, int theaterNumber) {
        this.seats = new EnumSeats[numRows][numCols];
        this.numRows = numRows;
        this.numCols = numCols;
        this.price = price;
        this.theaterNumber = theaterNumber;
    }

    // Getters
    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getPrice() {
        return price;
    }

    public int getTheaterNumber() {
        return theaterNumber;
    }

    public EnumSeats[][] getSeats() {
        return seats;
    }

    // Setters
    public void setSeat(int row, int col, EnumSeats seatStatus) {
        seats[row-1][col-1] = seatStatus;
    }


    public void selectSeat(int row, int col){
        seats[row-1][col-1] = EnumSeats.SELECTED;
    }

    public boolean isValidNumberOfTickets(int numOfSelectedTickets){
        int numOfAvailableTickets = 0;

        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                if (seats[i][j].equals(EnumSeats.AVAILABLE))
                    numOfAvailableTickets++;
            }
        }

        return numOfSelectedTickets <= numOfAvailableTickets;
    }
}
