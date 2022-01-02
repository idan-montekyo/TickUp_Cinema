import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> Times = new HashMap<>();
        Times.put(8, "8:00");
        Times.put(12, "12:00");
        Times.put(16, "16:00");
        Times.put(20, "20:00");

        Movies Movies_List = create_movies_list();

        Movies_List.displayMovies();

//        System.out.println(Movies_List.);


//        Screening s1 = new Screening(EnumTheaterType.THEATER_STANDARD, 5, Times.get(7));
//        Screening s2 = new Screening(EnumTheaterType.THEATER_IMAX, 3, Times.get(12));
//        Screening s3 = new Screening(EnumTheaterType.THEATER_VIP, 7, Times.get(16));
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
    }

    public static Movies create_movies_list() {
        HashMap<Integer, String> Times = new HashMap<>();
        Times.put(8, "8:00");
        Times.put(12, "12:00");
        Times.put(16, "16:00");
        Times.put(20, "20:00");

        Screening spiderman1 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, Times.get(8));
        Screening spiderman2 = new Screening(EnumTheaterType.THEATER_THREE_D, 7, Times.get(8));
        Screening spiderman3 = new Screening(EnumTheaterType.THEATER_IMAX, 7, Times.get(20));
        Screening spiderman4 = new Screening(EnumTheaterType.THEATER_VIP, 5, Times.get(20));
        ArrayList<Screening> screenings_spiderman = new ArrayList<>();
        screenings_spiderman.add(spiderman1);
        screenings_spiderman.add(spiderman2);
        screenings_spiderman.add(spiderman3);
        screenings_spiderman.add(spiderman4);
        Movie m_Spiderman = new Movie("Spiderman", 0, 100, screenings_spiderman);

        Screening hangover1 = new Screening(EnumTheaterType.THEATER_VIP, 6, Times.get(16));
        ArrayList<Screening> screenings_hangover = new ArrayList<>();
        screenings_hangover.add(hangover1);
        Movie m_Hangover = new Movie("Hangover", 1, 100, screenings_hangover);

        Screening lordoftherings1 = new Screening(EnumTheaterType.THEATER_STANDARD, 3, Times.get(12));
        Screening lordoftherings2 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, Times.get(16));
        Screening lordoftherings3 = new Screening(EnumTheaterType.THEATER_STANDARD, 2, Times.get(20));
        ArrayList<Screening> screenings_lordoftherings = new ArrayList<>();
        screenings_lordoftherings.add(lordoftherings1);
        screenings_lordoftherings.add(lordoftherings2);
        screenings_lordoftherings.add(lordoftherings3);
        Movie m_LordOfTheRings = new Movie("Lord of the rings", 2, 120, screenings_lordoftherings);

        Screening harrypotter1 = new Screening(EnumTheaterType.THEATER_STANDARD, 2, Times.get(12));
        Screening harrypotter2 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, Times.get(20));
        ArrayList<Screening> screenings_harrypotter = new ArrayList<>();
        screenings_harrypotter.add(harrypotter1);
        screenings_harrypotter.add(harrypotter2);
        Movie m_HarryPotter = new Movie("Harry Potter", 3, 150, screenings_harrypotter);

        Screening piratesofthecaribbean1 = new Screening(EnumTheaterType.THEATER_VIP, 5, Times.get(16));
        Screening piratesofthecaribbean2 = new Screening(EnumTheaterType.THEATER_STANDARD, 3, Times.get(20));
        ArrayList<Screening> screenings_piratesofthecaribbean = new ArrayList<>();
        screenings_piratesofthecaribbean.add(piratesofthecaribbean1);
        screenings_piratesofthecaribbean.add(piratesofthecaribbean2);
        Movie m_PiratesOfTheCaribbean = new Movie("Pirates of the Caribbean", 4, 120, screenings_piratesofthecaribbean);


        List<Movie> m_list = new ArrayList<>();
        m_list.add(m_Spiderman);
        m_list.add(m_Hangover);
        m_list.add(m_LordOfTheRings);
        m_list.add(m_HarryPotter);
        m_list.add(m_PiratesOfTheCaribbean);

        return (new Movies(m_list));
    }
}
