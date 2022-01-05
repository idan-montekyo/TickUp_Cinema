package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Classes.StandardTheater;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.StandardTheater;


class StandardTheaterTests {
    private StandardTheater standard = null;

    @BeforeEach
    void setUp() {
        standard = new StandardTheater(1);
    }

    @Test
    void testAddRemoveItem() {
        standard.setTheaterType("THEATER_STANDARD");
        assertEquals("THEATER_STANDARD", standard.getTheaterType());

    }
}
