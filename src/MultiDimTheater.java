public class MultiDimTheater extends Theater{

    private final EnumDimensions dimension;

    protected MultiDimTheater(EnumDimensions dim) {
        super(5, 10, 60);
        this.dimension = dim;
    }

    public EnumDimensions getDimension() {
        return dimension;
    }
}
