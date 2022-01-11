package Model;

import Model.Enums.EnumScreeningTime;
import Model.Enums.EnumTheaterType;
import Model.Enums.EnumWeekDays;
import Model.MovieOrders.OrderBuilder;
import Model.MovieOrders.Orders;
import Model.MovieOrders.UserOrder;
import Model.MoviesAndScreenings.Movie;
import Model.MoviesAndScreenings.Movies;
import Model.MoviesAndScreenings.Screening;
import Model.MoviesAndScreenings.ScreeningTime;
import Model.Users.Employee;
import Model.Users.Employees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DemoData {

    public static Employees initializeDemoEmployees(){
        Employees employees = new Employees();

        Employee e1 = new Employee(1234);
        Employee e2 = new Employee(1122);
        Employee e3 = new Employee(4321);
        Employee e4 = new Employee(5678);

        employees.addNewEmployee(e1);
        employees.addNewEmployee(e2);
        employees.addNewEmployee(e3);
        employees.addNewEmployee(e4);

        return employees;
    }

    public static Movies initializeDemoMovies(){
        ArrayList<ScreeningTime> screeningTimes = initializeDemoScreeningTimes();

        Screening spiderman1 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, screeningTimes.get(0));
        Screening spiderman2 = new Screening(EnumTheaterType.THEATER_THREE_D, 7, screeningTimes.get(5));
        Screening spiderman3 = new Screening(EnumTheaterType.THEATER_IMAX, 7, screeningTimes.get(2));
        Screening spiderman4 = new Screening(EnumTheaterType.THEATER_VIP, 5, screeningTimes.get(7));

        ArrayList<Screening> spidermanScreenings = new ArrayList<>();
        spidermanScreenings.add(spiderman1);
        spidermanScreenings.add(spiderman2);
        spidermanScreenings.add(spiderman3);
        spidermanScreenings.add(spiderman4);

        Movie m_Spiderman = new Movie("Spider-Man: No Way Home", 0,
                "src\\View\\images\\movie1.jpg",
                "With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man.",
                148,
                spidermanScreenings);


        Screening hangover1 = new Screening(EnumTheaterType.THEATER_VIP, 6, screeningTimes.get(1));

        ArrayList<Screening> hangoverScreenings = new ArrayList<>();
        hangoverScreenings.add(hangover1);

        Movie m_Hangover = new Movie("The Hangover", 1,
                "src\\View\\images\\movie2.jpg",
                "Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding.",
                100,
                hangoverScreenings);


        Screening lordoftherings1 = new Screening(EnumTheaterType.THEATER_STANDARD, 3, screeningTimes.get(6));
        Screening lordoftherings2 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, screeningTimes.get(3));
        Screening lordoftherings3 = new Screening(EnumTheaterType.THEATER_STANDARD, 2, screeningTimes.get(0));

        ArrayList<Screening> lordoftheringsScreenings = new ArrayList<>();
        lordoftheringsScreenings.add(lordoftherings1);
        lordoftheringsScreenings.add(lordoftherings2);
        lordoftheringsScreenings.add(lordoftherings3);

        Movie m_LordOfTheRings = new Movie("The Lord of the Rings", 2,
                "src\\View\\images\\movie3.jpg",
                "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
                178,
                lordoftheringsScreenings);


        Screening harrypotter1 = new Screening(EnumTheaterType.THEATER_STANDARD, 2, screeningTimes.get(4));
        Screening harrypotter2 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, screeningTimes.get(5));

        ArrayList<Screening> harrypotterScreenings = new ArrayList<>();
        harrypotterScreenings.add(harrypotter1);
        harrypotterScreenings.add(harrypotter2);

        Movie m_HarryPotter = new Movie("Harry Potter and the Prisoner of Azkaban", 3,
                "src\\View\\images\\movie4.jpg",
                "Harry Potter, Ron and Hermione return to Hogwarts School of Witchcraft and Wizardry for their third year of study, where they delve into the mystery surrounding an escaped prisoner who poses a dangerous threat to the young wizard.",
                142,
                harrypotterScreenings);


        Screening piratesofthecaribbean1 = new Screening(EnumTheaterType.THEATER_VIP, 5, screeningTimes.get(7));
        Screening piratesofthecaribbean2 = new Screening(EnumTheaterType.THEATER_STANDARD, 3, screeningTimes.get(3));

        ArrayList<Screening> piratesofthecaribbeanScreenings = new ArrayList<>();
        piratesofthecaribbeanScreenings.add(piratesofthecaribbean1);
        piratesofthecaribbeanScreenings.add(piratesofthecaribbean2);

        Movie m_PiratesOfTheCaribbean = new Movie("Pirates of the Caribbean", 4,
                "src\\View\\images\\movie1.jpg",
                "Blacksmith Will Turner teams up with eccentric pirate \"Captain\" Jack Sparrow to save his love, the governor's daughter, from Jack's former pirate allies, who are now undead.",
                143,
                piratesofthecaribbeanScreenings);


        List<Movie> m_list = new ArrayList<>();
        m_list.add(m_Spiderman);
        m_list.add(m_Hangover);
        m_list.add(m_LordOfTheRings);
        m_list.add(m_HarryPotter);
        m_list.add(m_PiratesOfTheCaribbean);

        return (new Movies(m_list));
    }

    private static ArrayList<ScreeningTime> initializeDemoScreeningTimes(){
        ArrayList<ScreeningTime> screeningTimes = new ArrayList<>();

        screeningTimes.add(new ScreeningTime(EnumWeekDays.FRIDAY, EnumScreeningTime.EIGHT));
        screeningTimes.add(new ScreeningTime(EnumWeekDays.FRIDAY, EnumScreeningTime.TWELVE));
        screeningTimes.add(new ScreeningTime(EnumWeekDays.FRIDAY, EnumScreeningTime.TEN));
        screeningTimes.add(new ScreeningTime(EnumWeekDays.THURSDAY, EnumScreeningTime.TEN));
        screeningTimes.add(new ScreeningTime(EnumWeekDays.THURSDAY, EnumScreeningTime.FOUR));
        screeningTimes.add(new ScreeningTime(EnumWeekDays.THURSDAY, EnumScreeningTime.EIGHT));
        screeningTimes.add(new ScreeningTime(EnumWeekDays.SATURDAY, EnumScreeningTime.TWELVE));
        screeningTimes.add(new ScreeningTime(EnumWeekDays.SATURDAY, EnumScreeningTime.FOUR));

        return screeningTimes;
    }

    public static ArrayList<Orders> initializeDemoOrders(Movies movies){
        OrderBuilder builder = new OrderBuilder();

        Movie m_Spiderman = movies.getAllMovies().get(0);
        Movie m_Hangover = movies.getAllMovies().get(1);
        Movie m_LordOfTheRings = movies.getAllMovies().get(2);
        Movie m_HarryPotter = movies.getAllMovies().get(3);
        Movie m_PiratesOfTheCaribbean = movies.getAllMovies().get(4);

        builder.buildUserPhoneNumber("050-244-5837");
        builder.buildMovie(m_Spiderman);
        builder.buildScreening(m_Spiderman.getScreeningsTime().get(3));
        HashMap<Integer, Integer[]> takenSeats = new HashMap();
        Integer[] takenSeatsRow4 = {1, 2, 3};
        Integer[] takenSeatsRow2 = {3, 4};
        takenSeats.put(4, takenSeatsRow4);
        takenSeats.put(2, takenSeatsRow2);
        builder.buildTickets();

        UserOrder order1 = new UserOrder("050-244-5837", m_Spiderman,
                m_Spiderman.getScreeningsTime().get(3), 1, 2, 3);

        UserOrder order2 = new UserOrder("052-735-7255", m_Hangover,
                m_Hangover.getScreeningsTime().get(0), 0, 4, 0);

        UserOrder order3 = new UserOrder("054-362-1356", m_LordOfTheRings,
                m_LordOfTheRings.getScreeningsTime().get(2), 2, 0, 3);

        UserOrder order4 = new UserOrder("055-290-3682", m_HarryPotter,
                m_HarryPotter.getScreeningsTime().get(1), 4, 0, 2);

        UserOrder order5 = new UserOrder("057-621-4289", m_PiratesOfTheCaribbean,
                m_PiratesOfTheCaribbean.getScreeningsTime().get(0), 2, 0, 0);


        List<UserOrder> orders_list = new ArrayList<>();
        orders_list.add(order1);
        orders_list.add(order2);
        orders_list.add(order3);
        orders_list.add(order4);
        orders_list.add(order5);

        return (new Orders(orders_list));
    }
}
