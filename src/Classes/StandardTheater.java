package Classes;

// Crate a class for the standard theater.
public class StandardTheater extends Theater {

    // Constructor
    public StandardTheater(int theaterNumber) {
        super(5, 10, 40, theaterNumber);
        setTheaterType("Standard theater");
    }

    @Override
    public String toString() {
        return "Standard theater, " + super.toString();
    }
}
