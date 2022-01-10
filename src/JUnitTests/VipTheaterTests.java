package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.VipTheater;

public class VipTheaterTests {
    private VipTheater vip = null;

    @BeforeEach
    void setUp()
    {
        vip = new VipTheater(5);
    }

    // Test for set the right theater type
    @Test
    void testSetGetTheaterType() {
        vip.setTheaterType("THEATER_VIP");
        assertEquals("THEATER_VIP", vip.getTheaterType());
    }
}
