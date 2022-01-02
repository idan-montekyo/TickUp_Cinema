abstract class Theater {

    private final int numRows;
    private final int numCols;
    private final int price;

    protected Theater(int numRows, int numCols, int price) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.price = price;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getPrice() {
        return price;
    }
}
