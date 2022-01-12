package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.MoviesAndScreenings.Tickets;


public class TicketTests {
    private Tickets ticket = null;

    @BeforeEach
    void setUp()
    {
        ticket = new Tickets();
    }

    // Test for selecting amount of tickets
    @Test
    void testAmountOfTickets() {
        ticket.setNumOfTypeTickets("Student", 3);
        assertEquals(3, ticket.getNumOfTypeTickets("Student"));
    }
}
