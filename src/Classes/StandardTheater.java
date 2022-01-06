package Classes;

// Crate a class for the standard theater.
public class StandardTheater extends Theater {

    // Constructor
    public StandardTheater(int theaterNumber) {
        super(5, 10, 40, theaterNumber);
        setTheaterType("Standard theater");
    }

    public StandardTheater(int numRows, int numCols, int price, int theaterNumber) {
        super(numRows, numCols, price, theaterNumber);
    }

    @Override
    public String toString() {
        return "Standard theater, " + super.toString();
    }
}
