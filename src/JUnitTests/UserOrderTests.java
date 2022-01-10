package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.UserOrder;
import Model.Screening;
import Model.Movie;
import Model.Enums.EnumTheaterType;

import java.util.ArrayList;
import java.util.Arrays;

public class UserOrderTests {
    private UserOrder userOrder = null;
//    Screening screening = new Screening(EnumTheaterType.THEATER_STANDARD, 1, "12:00");
//    ArrayList<Screening> screeningsList = new ArrayList<> (Arrays.asList(screening));
//    Movie movie = new Movie("Spiderman", 0, 100, screeningsList);

    @BeforeEach
//    void setUp()
//    {
//        userOrder = new UserOrder("050-123-4567", movie, screening, 1,2,3);
//    }

    // Test for calculate the right bill
    @Test
    void testBill() {
        userOrder.getBill();
        assertEquals(136, userOrder.getBill());
    }
}
