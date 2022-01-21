package Model.MoviesAndScreenings;

import Model.Enums.EnumScreeningTime;
import Model.Enums.EnumWeekDays;

// Class that represents the screening time: day + starting hour
public class ScreeningTime {
    private EnumWeekDays day;
    private EnumScreeningTime time;

    // Constructor
    public ScreeningTime(EnumWeekDays day, EnumScreeningTime time){
        this.day = day;
        this.time = time;
    }

    @Override
    public String toString() {
        String day = "", time = "";

        switch (this.day){
            case SUNDAY -> day = "sunday";
            case MONDAY -> day = "monday";
            case TUESDAY -> day = "tuesday";
            case WEDNESDAY -> day = "wednesday";
            case THURSDAY -> day = "thursday";
            case FRIDAY -> day = "friday";
            case SATURDAY -> day = "saturday";
        }

        switch (this.time){
            case TWELVE -> time = "12:00";
            case FOUR -> time = "16:00";
            case EIGHT -> time = "20:00";
            case TEN -> time = "22:00";
        }

        return "on " + day + " at " + time;
    }
}
