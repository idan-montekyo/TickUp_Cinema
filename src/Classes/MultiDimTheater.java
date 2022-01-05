package Classes;// Crate a class for the Multi dimensions theater

public class MultiDimTheater extends Theater{

    // Fields
    private final EnumDimensions dimension; // ThreeD, FourD, IMAX

    // Constructor
    public MultiDimTheater(int theaterNumber, EnumDimensions dim) {
        super(5, 10, 60, theaterNumber);
        setTheaterType("Multi-dimension theater");
        this.dimension = dim;
    }

    // Getters
    public EnumDimensions getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return "Dimensions = " + this.dimension + ", " + super.toString();
    }
}
