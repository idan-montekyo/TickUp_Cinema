// Create an abstract class for theater

abstract class Theater {

    //Fields

    private final int numRows;
    private final int numCols;
    private final int price;
    protected int theaterNumber;

    // Constructor

    protected Theater(int numRows, int numCols, int price, int theaterNumber) {
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

    @Override
    public String toString() {
        return "theater " + this.theaterNumber + ", " + this.numRows + " rows, " + this.numCols + " cols, " + this.price + " NIS.";
    }
}
