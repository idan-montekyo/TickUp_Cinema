package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import Model.Enums.EnumScreeningTime;
import Model.Enums.EnumTheaterType;
import Model.Enums.EnumWeekDays;
import Model.MovieOrders.Order;
import Model.MovieOrders.Orders;
import Model.MoviesAndScreenings.Movie;
import Model.MoviesAndScreenings.Screening;
import Model.MoviesAndScreenings.ScreeningTime;
import Model.MoviesAndScreenings.Tickets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class OrdersTest {
    private Order order = null;
    private Orders orders = null;
    ScreeningTime st = new ScreeningTime(EnumWeekDays.SUNDAY, EnumScreeningTime.FOUR);
    Screening screening = new Screening(EnumTheaterType.THEATER_STANDARD, 1, st);
    ArrayList<Screening> screeningsList = new ArrayList<> (Arrays.asList(screening));
    Movie movie = new Movie("Spiderman", 0, null, "", 90, screeningsList);
    Tickets tickets = new Tickets();

    @BeforeEach
    void setUp()
    {
        order = new Order();
        orders = new Orders();
        tickets.setNumOfTypeTickets("Standard", 3);
        tickets.setNumOfTypeTickets("Student", 5);
        order.setUserPhoneNumber("0505050505");
        order.setMovie(movie);
        order.setScreening(screening);
        order.setTickets(tickets);
        order.setTotalBill();
    }

    // Test for Order class's assignments.
    @Test
    void createNewOrder() {
        assertEquals("0505050505", order.getUserPhoneNumber());
        assertEquals(movie, order.getMovie());
        assertEquals(screening, order.getScreening());
        assertEquals(tickets, order.getTickets());
        assertEquals(240, order.getTotalBill());
    }

    // Test for Orders class's addOrder method.
    @Test
    void addOrderToOrdersTest() {
        assertEquals(0, orders.getNumOfOrders());

        orders.addOrder(order);
        assertEquals(1, orders.getNumOfOrders());
    }
}
