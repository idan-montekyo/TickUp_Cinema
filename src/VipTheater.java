public class VipTheater extends Theater{

    protected VipTheater(int theaterNumber) {
        super(3, 6, 100, theaterNumber);
    }

    @Override
    public String toString() {
        return "Vip theater, " + super.toString();
    }
}
