package Model.Theaters;

import Model.Enums.EnumDimensions;

// Crate a class for the Multi dimension's theater.
public class MultiDimTheater extends StandardTheater {
    // Defines
    private static final int numRows = 5;
    private static final int numCols = 6;
    private static final int price = 50;

    // Fields
    private final EnumDimensions dimension; // 3D, 4D, IMAX

    // Constructor
    public MultiDimTheater(int theaterNumber, EnumDimensions dim) {
        super(numRows, numCols, price, theaterNumber);
        this.dimension = dim;
    }

    // Getters
    public EnumDimensions getDimension() {
        return dimension;
    }


    @Override
    public String toString() {
        String dim = "";

        switch (dimension){
            case IMAX -> dim = "IMAX";
            case ThreeD -> dim = "3D";
            case FourD -> dim = "4D";
        }

//        return dim + " " + super.toString();
        return dim + " ";
    }
}
