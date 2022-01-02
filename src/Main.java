import java.util.*;

public class Main {
    public static void main(String[] args) {
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
        Movies Movies_List = new Movies(m_list);

//        Movies_List.displayMovies();

        for(EnumDimensions D : EnumDimensions.values()) {
            System.out.println(D);
        }
    }

}
