package Model.Theaters;

import Model.Enums.EnumDimensions;
import Model.Enums.EnumTheaterType;

public class TheaterCreator {
    // Factory design pattern for Theater object:
    private static Theater theater;

    public static Theater TheaterCreator(EnumTheaterType theaterType, int theaterNumber){
        switch (theaterType){
            case THEATER_STANDARD:
                theater = new StandardTheater(theaterNumber);
                break;
            case THEATER_VIP:
                theater = new VipTheater(theaterNumber);
                break;
            case THEATER_IMAX:
                theater = new MultiDimTheater(theaterNumber, EnumDimensions.IMAX);
                break;
            case THEATER_THREE_D:
                theater = new MultiDimTheater(theaterNumber, EnumDimensions.ThreeD);
                break;
            case THEATER_FOUR_D:
                theater = new MultiDimTheater(theaterNumber, EnumDimensions.FourD);
                break;
        }

        return theater;
    }
}
