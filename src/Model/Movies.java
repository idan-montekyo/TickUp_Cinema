package Model;

import Model.Enums.EnumScreeningTime;
import Model.Enums.EnumTheaterType;
import Model.Enums.EnumWeekDays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Create a class that holds all the movies.
public class Movies {
    // Fields
    private final List<Movie> allMovies;

    // Constructor
    public Movies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }


    // Getter
    public List<Movie> getAllMovies() {
        return allMovies;
    }


    // Display all data about each movie at the cinema: Name, Duration and screening times
    public void displayMovies() {
        //Traversing list through Iterator
        Iterator itr = this.allMovies.iterator();//getting the Iterator
        while (itr.hasNext()) {//check if iterator has the elements
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.println(itr.next());//printing the element and move to next
        }
    }

    // Create All movies at cinema and their screenings - default (first version)
    public static Movies createMoviesList() {
        ScreeningTime st1 = new ScreeningTime(EnumWeekDays.FRIDAY, EnumScreeningTime.EIGHT);
        ScreeningTime st2 = new ScreeningTime(EnumWeekDays.FRIDAY, EnumScreeningTime.TWELVE);
        ScreeningTime st3 = new ScreeningTime(EnumWeekDays.FRIDAY, EnumScreeningTime.TEN);
        ScreeningTime st4 = new ScreeningTime(EnumWeekDays.THURSDAY, EnumScreeningTime.TEN);
        ScreeningTime st5 = new ScreeningTime(EnumWeekDays.THURSDAY, EnumScreeningTime.FOUR);
        ScreeningTime st6 = new ScreeningTime(EnumWeekDays.THURSDAY, EnumScreeningTime.EIGHT);
        ScreeningTime st7 = new ScreeningTime(EnumWeekDays.SATURDAY, EnumScreeningTime.TWELVE);
        ScreeningTime st8 = new ScreeningTime(EnumWeekDays.SATURDAY, EnumScreeningTime.FOUR);


        Screening spiderman1 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, st1);
        Screening spiderman2 = new Screening(EnumTheaterType.THEATER_THREE_D, 7, st6);
        Screening spiderman3 = new Screening(EnumTheaterType.THEATER_IMAX, 7, st3);
        Screening spiderman4 = new Screening(EnumTheaterType.THEATER_VIP, 5, st8);
        ArrayList<Screening> screenings_spiderman = new ArrayList<>();
        screenings_spiderman.add(spiderman1);
        screenings_spiderman.add(spiderman2);
        screenings_spiderman.add(spiderman3);
        screenings_spiderman.add(spiderman4);
        Movie m_Spiderman = new Movie("Spiderman", 0,
                "src\\View\\images\\movie1.jpg",
                "scafjnkcbbea",
                100,
                screenings_spiderman);

        Screening hangover1 = new Screening(EnumTheaterType.THEATER_VIP, 6, st2);
        ArrayList<Screening> screenings_hangover = new ArrayList<>();
        screenings_hangover.add(hangover1);
        Movie m_Hangover = new Movie("Hangover", 1,
                "src\\View\\images\\movie2.jpg",
                "scafjnkcbbea",
                88,
                screenings_spiderman);

        Screening lordoftherings1 = new Screening(EnumTheaterType.THEATER_STANDARD, 3, st7);
        Screening lordoftherings2 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, st4);
        Screening lordoftherings3 = new Screening(EnumTheaterType.THEATER_STANDARD, 2, st1);
        ArrayList<Screening> screenings_lordoftherings = new ArrayList<>();
        screenings_lordoftherings.add(lordoftherings1);
        screenings_lordoftherings.add(lordoftherings2);
        screenings_lordoftherings.add(lordoftherings3);
        Movie m_LordOfTheRings = new Movie("Lord of the rings", 2,
                "src\\View\\images\\movie3.jpg",
                "scafjnkcbbea",
                96,
                screenings_spiderman);

        Screening harrypotter1 = new Screening(EnumTheaterType.THEATER_STANDARD, 2, st5);
        Screening harrypotter2 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, st6);
        ArrayList<Screening> screenings_harrypotter = new ArrayList<>();
        screenings_harrypotter.add(harrypotter1);
        screenings_harrypotter.add(harrypotter2);
        Movie m_HarryPotter = new Movie("Harry Potter", 3,
                "src\\View\\images\\movie4.jpg",
                "scafjnkcbbea",
                110,
                screenings_spiderman);

        Screening piratesofthecaribbean1 = new Screening(EnumTheaterType.THEATER_VIP, 5, st8);
        Screening piratesofthecaribbean2 = new Screening(EnumTheaterType.THEATER_STANDARD, 3, st4);
        ArrayList<Screening> screenings_piratesofthecaribbean = new ArrayList<>();
        screenings_piratesofthecaribbean.add(piratesofthecaribbean1);
        screenings_piratesofthecaribbean.add(piratesofthecaribbean2);
        Movie m_PiratesOfTheCaribbean = new Movie("Pirates of the Caribbean", 4,
                "src\\View\\images\\movie1.jpg",
                "scafjnkcbbea",
                120,
                screenings_spiderman);


        List<Movie> m_list = new ArrayList<>();
        m_list.add(m_Spiderman);
        m_list.add(m_Hangover);
        m_list.add(m_LordOfTheRings);
        m_list.add(m_HarryPotter);
        m_list.add(m_PiratesOfTheCaribbean);

        return (new Movies(m_list));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
