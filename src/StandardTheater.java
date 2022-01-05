// Crate a class for the standard theater

public class StandardTheater extends Theater {

    // Constructor

    protected StandardTheater(int theaterNumber) {
        super(5, 10, 40, theaterNumber);
    }

    @Override
    public String toString() {
        return "Standard theater, " + super.toString();
    }
}
