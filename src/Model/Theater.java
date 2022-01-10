package Model;

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
        seats[row][col] = seatStatus;
    }

    public void selectSeat(int row, int col){
        seats[row][col] = EnumSeats.SELECTED;
    }

//    @Override
//    public String toString() {
////        StringBuilder theaterInfo = new StringBuilder();
//
////        theaterInfo.append("number ").append(this.theaterNumber).append(", ")
////                .append(this.numRows).append(" rows, ").append(this.numCols)
////                .append(" cols, ").append(this.price).append(" NIS.");
//
//        return theaterInfo.toString();
//    }
}
