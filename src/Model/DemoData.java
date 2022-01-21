package Model;

import Model.Enums.EnumScreeningTime;
import Model.Enums.EnumSeats;
import Model.Enums.EnumTheaterType;
import Model.Enums.EnumWeekDays;
import Model.MovieOrders.OrderBuilder;
import Model.MovieOrders.Orders;
import Model.MovieOrders.Order;
import Model.MoviesAndScreenings.Movie;
import Model.MoviesAndScreenings.Movies;
import Model.MoviesAndScreenings.Screening;
import Model.MoviesAndScreenings.ScreeningTime;
import Model.MoviesAndScreenings.Tickets;
import Model.Users.Employee;
import Model.Users.Employees;
import java.util.ArrayList;
import java.util.List;

// Class that creates demo data for the app
public class DemoData {
    // Demo employees who have permissions to view all orders
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

    // Demo movies for movies list + their screenings and theaters
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
                "src\\View\\images\\spidermanPoster.jpg",
                "With Spider-Man's identity now revealed, Peter asks Doctor Strange for help. When a spell goes wrong, dangerous foes from other worlds start to appear, forcing Peter to discover what it truly means to be Spider-Man.",
                148,
                spidermanScreenings);


        Screening hangover1 = new Screening(EnumTheaterType.THEATER_VIP, 6, screeningTimes.get(1));

        ArrayList<Screening> hangoverScreenings = new ArrayList<>();
        hangoverScreenings.add(hangover1);

        Movie m_Hangover = new Movie("The Hangover", 1,
                "src\\View\\images\\hangoverPoster.jpg",
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
                "src\\View\\images\\lordRingsPoster.jpg",
                "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
                178,
                lordoftheringsScreenings);


        Screening harrypotter1 = new Screening(EnumTheaterType.THEATER_STANDARD, 2, screeningTimes.get(4));
        Screening harrypotter2 = new Screening(EnumTheaterType.THEATER_STANDARD, 1, screeningTimes.get(5));

        ArrayList<Screening> harrypotterScreenings = new ArrayList<>();
        harrypotterScreenings.add(harrypotter1);
        harrypotterScreenings.add(harrypotter2);

        Movie m_HarryPotter = new Movie("Harry Potter and the Prisoner of Azkaban", 3,
                "src\\View\\images\\harry3Poster.jpg",
                "Harry Potter, Ron and Hermione return to Hogwarts School of Witchcraft and Wizardry for their third year of study, where they delve into the mystery surrounding an escaped prisoner who poses a dangerous threat to the young wizard.",
                142,
                harrypotterScreenings);


        Screening piratesofthecaribbean1 = new Screening(EnumTheaterType.THEATER_VIP, 5, screeningTimes.get(7));
        Screening piratesofthecaribbean2 = new Screening(EnumTheaterType.THEATER_STANDARD, 3, screeningTimes.get(3));

        ArrayList<Screening> piratesofthecaribbeanScreenings = new ArrayList<>();
        piratesofthecaribbeanScreenings.add(piratesofthecaribbean1);
        piratesofthecaribbeanScreenings.add(piratesofthecaribbean2);

        Movie m_PiratesOfTheCaribbean = new Movie("Pirates of the Caribbean", 4,
                "src\\View\\images\\piratesPoster.jpg",
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

    // Demo screenings for the demo movies
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

    // Demo orders for orders list (includes taken seats)
    public static Orders initializeDemoOrders(Movies movies){
        OrderBuilder builder = new OrderBuilder();

        // Create demo orders
        StringBuilder selectedSeats1 = new StringBuilder("");
        StringBuilder selectedSeats2 = new StringBuilder("");

        Movie m_Spiderman = movies.getAllMovies().get(0);
        Screening spidermanSc = m_Spiderman.getScreeningsTime().get(2);
        spidermanSc.getTheater().setSeat(5, 3, EnumSeats.TAKEN);
        spidermanSc.getTheater().setSeat(5, 4, EnumSeats.TAKEN);
        spidermanSc.getTheater().setSeat(5, 5, EnumSeats.TAKEN);
        spidermanSc.getTheater().setSeat(5, 6, EnumSeats.TAKEN);
        spidermanSc.getTheater().setSeat(4, 1, EnumSeats.TAKEN);
        spidermanSc.getTheater().setSeat(4, 2, EnumSeats.TAKEN);
        spidermanSc.getTheater().setSeat(4, 3, EnumSeats.TAKEN);

        selectedSeats1.append("\nRow - ").append(5).append(" Col - ").append(3);
        selectedSeats1.append("\nRow - ").append(5).append(" Col - ").append(4);
        selectedSeats1.append("\nRow - ").append(5).append(" Col - ").append(5);
        selectedSeats1.append("\nRow - ").append(5).append(" Col - ").append(6);

        selectedSeats2.append("\nRow - ").append(54).append(" Col - ").append(1);
        selectedSeats2.append("\nRow - ").append(54).append(" Col - ").append(2);
        selectedSeats2.append("\nRow - ").append(54).append(" Col - ").append(3);

        Tickets spidermanTickets1 = new Tickets();
        Tickets spidermanTickets2 = new Tickets();
        spidermanTickets1.setNumOfTypeTickets("Standard", 3);
        spidermanTickets2.setNumOfTypeTickets("Standard", 2);
        spidermanTickets2.setNumOfTypeTickets("Student", 2);

        // Using builder
        builder.buildUserPhoneNumber("0502445837");
        builder.buildMovie(m_Spiderman);
        builder.buildScreening(spidermanSc);
        builder.buildTickets(spidermanTickets1);
        builder.buildSeats(selectedSeats1.toString());
        builder.buildTotalBill();
        Order order1 = builder.getOrder();

        builder.buildUserPhoneNumber("0523562227");
        builder.buildMovie(m_Spiderman);
        builder.buildScreening(spidermanSc);
        builder.buildTickets(spidermanTickets2);
        builder.buildSeats(selectedSeats2.toString());
        builder.buildTotalBill();
        Order order2 = builder.getOrder();


        Movie m_Hangover = movies.getAllMovies().get(1);
        Movie m_LordOfTheRings = movies.getAllMovies().get(2);
        Movie m_HarryPotter = movies.getAllMovies().get(3);
        Movie m_PiratesOfTheCaribbean = movies.getAllMovies().get(4);


        Orders orders = new Orders();
        orders.addOrder(order1);
        orders.addOrder(order2);

        return (orders);
    }
}
