package Model.MoviesAndScreenings;

import Model.Enums.EnumSeats;
import Model.Enums.EnumTheaterType;
import Model.Theaters.Theater;
import Model.Theaters.TheaterCreator;

// Create a class for managing screening time for each movie.
public class Screening {
    // Fields
    private Theater theater;
    private final ScreeningTime screeningTime;

    // Constructor
    public Screening(EnumTheaterType theaterType, int theaterNumber, ScreeningTime screeningTime) {
        theater = TheaterCreator.TheaterCreator(theaterType, theaterNumber);
        this.screeningTime = screeningTime;

        // Initialize theater seats
        int rows = this.theater.getNumRows();
        int cols = this.theater.getNumCols();
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                this.theater.setSeat(row, col, EnumSeats.AVAILABLE);
            }
        }
    }

    // Getters
    public Theater getTheater() {
        return theater;
    }

    public ScreeningTime getScreeningTime() {
        return screeningTime;
    }

    @Override
    public String toString() {
        return theater.toString() + screeningTime.toString();
    }
}

