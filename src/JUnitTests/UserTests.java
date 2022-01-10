package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import Model.Enums.EnumTheaterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.*;

public class UserTests {
    private User user = null;
//    Movies movieList = Movies.create_movie_list();


    @BeforeEach
    void setUp() {
        user = new User();
    }

    // Test for select exist movie
    @Test
    void SelectMovie() {
//        assertEquals( movieList.getAllMovies().get(1), user.selectMovieByName(movieList, "Hangover"));
    }

    // Test for select invalid amount of tickets
    @Test
    void SelectInValidSumOfTickets() {
        assertEquals( null, user.selectTicketsUpToEight(4, 4, 4));
    }


    // Test for select valid seats
    @Test
    void SelectValidSeats() {
//        Screening screening = new Screening(EnumTheaterType.THEATER_STANDARD, 1, "8:00");
        int[][] userSelection= {{1, 2}, {1, 3}};
//        assertEquals( true, user.selectUserSeats(screening, userSelection));
    }

    // Test for select unvalid seats
    @Test
    void SelectInValidSeats() {
//        Screening screening = new Screening(EnumTheaterType.THEATER_STANDARD, 1, "8:00");
        int[][] userSelection= {{1, 2}, {1, 3}};
//        screening.selectSeat(1, 2);
//        assertEquals( false, user.selectUserSeats(screening, userSelection));
    }
}
