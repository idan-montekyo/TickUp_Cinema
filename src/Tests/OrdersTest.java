package Tests;
import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Classes.UserOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdersTest {
    private Orders order = null;
    Screening screening = new Screening(EnumTheaterType.THEATER_STANDARD, 1, "12:00");
    ArrayList<Screening> screeningsList = new ArrayList<> (Arrays.asList(screening));
    Movie movie = new Movie("Spiderman", 0, 100, screeningsList);
    UserOrder userOrder1 = new UserOrder("050-123-4567", movie, screening, 1,2,3);
    List<UserOrder> orders_list = new ArrayList<>(Arrays.asList(userOrder1));


    @BeforeEach
    void setUp()
    {
        order = new Orders(orders_list);
    }

    @Test
    void testSetGetTheaterType() {
        Screening screening2 = new Screening(EnumTheaterType.THEATER_VIP, 5, "16:00");
        ArrayList<Screening> screeningsList2 = new ArrayList<> (Arrays.asList(screening2));
        Movie movie2 = new Movie("Harry Potter", 3, 150, screeningsList2);
        UserOrder userOrder2 = new UserOrder("050-145-9999", movie2, screening2, 4,0,1);
        order.addOrder(userOrder2);
        assertEquals(2, order.GetNumOfORders());
    }
}
