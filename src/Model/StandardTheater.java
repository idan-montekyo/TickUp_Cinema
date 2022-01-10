package Model;

// Crate a class for the standard theater.
public class StandardTheater extends Theater {
    // Defines
    private static final int numRows = 4;
    private static final int numCols = 5;
    private static final int price = 40;

    // Constructor
    public StandardTheater(int theaterNumber) {
        super(numRows, numCols, price, theaterNumber);
    }

    // For VIP and multi-dimensional theater
    public StandardTheater(int rows, int cols, int price, int theaterNumber) {
        super(rows, cols, price, theaterNumber);
    }

    @Override
    public String toString() {
//        return "2D " + super.toString();
        return "2D ";
    }
}
