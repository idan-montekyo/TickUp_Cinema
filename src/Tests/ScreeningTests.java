package Tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Classes.Screening;
import Classes.EnumTheaterType;

public class ScreeningTests {
    private Screening screening = null;

    @BeforeEach
    void setUp()
    {
        screening = new Screening(EnumTheaterType.THEATER_STANDARD, 1, "8:00");
    }

    @Test
    void AddValidSeat() {
        assertEquals(true, screening.selectSeat(0, 0));

    }

    @Test
    void AddInValidSeat() {
        screening.selectSeat(0, 0);
        assertEquals(false, screening.selectSeat(0, 0));

    }

    void CancelSeat() {
        screening.selectSeat(0, 0);
        assertEquals(true, screening.CancelSeat(0, 0));

    }
}
