package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class UserTests {
    private User user = null;
    Movies movieList = Movies.create_movie_list();


    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void SelectMovie() {
        assertEquals( movieList.getAllMovies().get(1), user.selectMovieByName(movieList, "Hangover"));
    }

    @Test
    void SelectUnValidSumOfTickets() {
        assertEquals( null, user.selectTicketsUpToEight(4, 4, 4));
    }

    @Test
    void SelectValidSeats() {
        Screening screening = new Screening(EnumTheaterType.THEATER_STANDARD, 1, "8:00");
        int[][] userSelection= {{1, 2}, {1, 3}};
        assertEquals( true, user.selectUserSeats(screening, userSelection));
    }

    @Test
    void SelectInValidSeats() {
        Screening screening = new Screening(EnumTheaterType.THEATER_STANDARD, 1, "8:00");
        int[][] userSelection= {{1, 2}, {1, 3}};
        screening.selectSeat(1, 2);
        assertEquals( false, user.selectUserSeats(screening, userSelection));
    }


}
