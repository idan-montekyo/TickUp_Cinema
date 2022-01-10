package Model;

// Create an abstract class for theater.
public abstract class Theater {

    //Fields
    private final int numRows;
    private final int numCols;
    private final int price;
    private final int theaterNumber;
    private String theaterType;

    // Constructor
    public Theater(int numRows, int numCols, int price, int theaterNumber) {
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

    public String getTheaterType() {
        return theaterType;
    }

    // Setter
    public void setTheaterType(String theaterType) {
        this.theaterType = theaterType;
    }

    @Override
    public String toString() {
        return "theater " + this.theaterNumber + ", " + this.numRows + " rows, " + this.numCols + " cols, " + this.price + " NIS.";
    }
}
