package Model;

// Crate a class for the VIP theater.
public class VipTheater extends StandardTheater {
    private static final int numRows = 3;
    private static final int numCols = 5;
    private static final int price = 100;

    // Constructor
    public VipTheater(int theaterNumber) {
        super(numRows, numCols, price, theaterNumber);
    }

    @Override
    public String toString() {
//        return "VIP " + super.toString();
        return "VIP ";
    }
}
