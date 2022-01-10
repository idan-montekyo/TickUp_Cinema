package JUnitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.MultiDimTheater;
import Model.Enums.EnumDimensions;


public class MultiDimTheaterTest {
    private MultiDimTheater multiDim = null;

    @BeforeEach
    void setUp()
    {
        multiDim = new MultiDimTheater(7, EnumDimensions.IMAX);
    }

    // Test for set the right theater type
    @Test
    void testSetGetTheaterType() {
//        multiDim.setTheaterType("THEATER_IMAX");
//        assertEquals("THEATER_IMAX", multiDim.getTheaterType());

    }

}
