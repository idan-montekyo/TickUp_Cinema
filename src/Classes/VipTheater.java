package Classes;// Crate a class for the VIP theater

public class VipTheater extends Theater{

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
