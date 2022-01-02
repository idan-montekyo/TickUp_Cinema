import java.util.*;

public class Main {

    public static Movies create_movies_list() {

        Movie m_Spiderman = new Movie("Spiderman", 0, 100, 0);
        Movie m_Hangover = new Movie("Hangover", 1, 100, 0);
        Movie m_LordOfTheRings = new Movie("Lord of the rings", 2, 120, 0);
        Movie m_HarryPotter = new Movie("Harry Potter", 3, 150, 0);
        Movie m_PiratesOfTheCaribbean = new Movie("Pirates of the Caribbean", 4, 120, 0);

        List<Movie> m_list = new ArrayList<>();
        m_list.add(m_Spiderman);
        m_list.add(m_Hangover);
        m_list.add(m_LordOfTheRings);
        m_list.add(m_HarryPotter);
        m_list.add(m_PiratesOfTheCaribbean);
        return (new Movies(m_list));
    }


    public static void main(String[] args) {
        HashMap<Integer, String> Times = new HashMap<>();
        Times.put(8, "8:00");
        Times.put(12, "12:00");
        Times.put(16, "16:00");
        Times.put(20, "20:00");

        Movies Movies_List = create_movies_list();

        Movies_List.displayMovies();

        Screening s1 = new Screening(EnumTheaterType.THEATER_STANDARD, 5, Times.get(7));
        Screening s2 = new Screening(EnumTheaterType.THEATER_IMAX, 3, Times.get(12));
        Screening s3 = new Screening(EnumTheaterType.THEATER_VIP, 7, Times.get(16));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }



}
