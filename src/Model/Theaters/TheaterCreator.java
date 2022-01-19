package Model.Theaters;

import Model.Enums.EnumDimensions;
import Model.Enums.EnumTheaterType;

public class TheaterCreator {
    // Factory design pattern for Theater object:
    private static Theater theater;

    public static Theater TheaterCreator(EnumTheaterType theaterType, int theaterNumber){
        switch (theaterType) {
            case THEATER_STANDARD -> theater = new StandardTheater(theaterNumber);
            case THEATER_VIP -> theater = new VipTheater(theaterNumber);
            case THEATER_IMAX -> theater = new MultiDimTheater(theaterNumber, EnumDimensions.IMAX);
            case THEATER_THREE_D -> theater = new MultiDimTheater(theaterNumber, EnumDimensions.ThreeD);
            case THEATER_FOUR_D -> theater = new MultiDimTheater(theaterNumber, EnumDimensions.FourD);
        }

        return theater;
    }
}
