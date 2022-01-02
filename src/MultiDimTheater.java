public class MultiDimTheater extends Theater{

    private final EnumDimensions dimension;

    protected MultiDimTheater(int theaterNumber, EnumDimensions dim) {
        super(5, 10, 60, theaterNumber);
        this.dimension = dim;
    }

    public EnumDimensions getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return "Dimensions = " + this.dimension + ", " + super.toString();
    }
}
