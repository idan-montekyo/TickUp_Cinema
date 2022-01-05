import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> Times = new HashMap<>();
        Times.put(8, "8:00");
        Times.put(12, "12:00");
        Times.put(16, "16:00");
        Times.put(20, "20:00");

        Movies movieList = create_movie_list();
        List<UserOrder> userOrders = create_user_orders(movieList);

//        movieList.displayMovies();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(userOrders);

//        System.out.println(Movies_List.);


    }

    public static Movies create_movie_list() {
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

    public static List<UserOrder> create_user_orders(Movies movieList) {
        List<UserOrder> userOrders = new ArrayList<>();


        UserOrder order1 = new UserOrder("050-244-5837", movieList.getAllMovies().get(0),
                movieList.getAllMovies().get(0).getScreeningsTime().get(3), 1, 2, 3);

        userOrders.add(order1);

        return userOrders;
    }





}
