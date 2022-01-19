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
        ticket.setNumOfTypeTickets("Standard", 1);
        ticket.setNumOfTypeTickets("Student", 2);
        ticket.setNumOfTypeTickets("Veteran", 3);
        assertEquals(1, ticket.getNumOfTypeTickets("Standard"));
        assertEquals(2, ticket.getNumOfTypeTickets("Student"));
        assertEquals(3, ticket.getNumOfTypeTickets("Veteran"));
    }
}
