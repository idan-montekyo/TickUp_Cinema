package Model;

// Crate a class for the VIP theater.
public class VipTheater extends StandardTheater{

    // Constructor
    public VipTheater(int theaterNumber) {
        super(3, 6, 100, theaterNumber);
        setTheaterType("Vip theater");
    }

    @Override
    public String toString() {
        return "Vip theater, " + super.toString();
    }
}
