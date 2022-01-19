package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import Model.DemoData;
import Model.MoviesAndScreenings.Movies;
import Model.Users.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTests {
    private User user = null;
    Movies movieList = DemoData.initializeDemoMovies();


    @BeforeEach
    void setUp() {
        user = new User();
    }

    // Test for movie selection.
    @Test
    void SelectMovie() {
        assertEquals( movieList.getAllMovies().get(1), user.selectMovieByName(movieList, "Hangover"));
    }

    // Test for selection of invalid amount of tickets (allowed up to total of 8 tickets).
    @Test
    void SelectInValidSumOfTickets() {
        assertNull(user.selectTicketsUpToEight(4, 4, 4, 4));
    }
}
