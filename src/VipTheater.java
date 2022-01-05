// Crate a class for the VIP theater

public class VipTheater extends Theater{

    // Constructor

    protected VipTheater(int theaterNumber) {
        super(3, 6, 100, theaterNumber);
    }

    @Override
    public String toString() {
        return "Vip theater, " + super.toString();
    }
}
