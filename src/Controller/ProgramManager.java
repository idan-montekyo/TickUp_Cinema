package Controller;

import Model.DemoData;
import Model.Enums.EnumSeats;
import Model.MovieOrders.OrderBuilder;
import Model.MovieOrders.Orders;
import Model.MovieOrders.Order;
import Model.MoviesAndScreenings.Movie;
import Model.MoviesAndScreenings.Movies;
import Model.MoviesAndScreenings.Screening;
import Model.MoviesAndScreenings.Tickets;
import Model.Theaters.MultiDimTheater;
import Model.Theaters.Theater;
import Model.Theaters.VipTheater;
import Model.Users.Employees;
import Model.Users.User;
import View.*;
import View.SeatsMultiDimScreen;
import View.SeatsRegularScreen;
import View.SeatsVIPScreen;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

// The app manager, connects between the logic (model) and the GUI (view)
public class ProgramManager {
    // Fields
    private static MainScreen mainScreen = new MainScreen();
    private static MoviesFrame currentScreen; // Changing screen
    private static Employees employees;
    private static Movies movies;
    private static Orders orders;
    private static OrderBuilder orderBuilder;
    private static Order currentOrder;
    private static User user;

    // Constructor
    public ProgramManager(){
        // Demo data loading
        employees = DemoData.initializeDemoEmployees();
        movies = DemoData.initializeDemoMovies();
        orders = DemoData.initializeDemoOrders(movies);
        // Order builder object
        orderBuilder = new OrderBuilder();
    }

    // App starting
    public void ShowMainScreen(){
        mainScreen.setVisible(true);
    }

    // Show movies screen
    public static void switchToMoviesWindow(){
        currentScreen = new MoviesScreen();

        currentScreen.setVisible(true);
        mainScreen.setVisible(false);
    }

    // Show orders screen
    public static void switchToOrdersWindow(){
        currentScreen = new OrdersScreen();

        currentScreen.setVisible(true);
        mainScreen.setVisible(false);
    }

    // Checks login data and return if the data is valid
    public static boolean loginUser(){
        String message = "Please enter your employee id number:";
        String userId = JOptionPane.showInputDialog(mainScreen, message, null);

        if(employees.login(Integer.parseInt(userId)))
            return true;

        return false;
    }

    // Return orders' phone numbers
    public static ArrayList<String> getOrdersPhones(){
        ArrayList<String> ordersPhones = new ArrayList<>();

        for (Order order : orders.getAllOrders()) {
            ordersPhones.add(order.getUserPhoneNumber());
        }

        return ordersPhones;
    }

    // Returns specific order data
    public static String getOrderInfo(int orderIndex){
        return orders.getAllOrders().get(orderIndex).toString();
    }

    // Changes to main screen
    public static void backToMainScreen(){
        currentScreen.setEnabled(false);
        mainScreen.setVisible(true);
    }

    // Returns movies' names
    public static ArrayList<String> getMoviesTitles(){
        ArrayList<String> moviesTitles = new ArrayList<>();

        for (Movie movie : movies.getAllMovies()) {
            moviesTitles.add(movie.getMovieName());
        }

        return moviesTitles;
    }

    // Returns specific movie name
    public static String getMovieName(int movieIndex){
        return movies.getAllMovies().get(movieIndex).getMovieName();
    }

    // Returns specific movie image
    public static String getMoviePoster(int movieIndex){
        return movies.getAllMovies().get(movieIndex).getImagePath();
    }

    // Show the specific movie screen
    public static void switchToMovieInfoWindow(int movieIndex){
        orderBuilder.buildMovie(movies.getAllMovies().get(movieIndex));

        currentScreen.setVisible(false);

        currentScreen = new MovieInfo(movieIndex);
        currentScreen.setVisible(true);
    }

    // Returns specific movie content
    public static String getMovieSummary(int movieIndex){
        return movies.getAllMovies().get(movieIndex).getSummary();
    }

    // Returns specific movie screenings
    public static ArrayList<Screening> getMovieScreenings(int movieIndex){
        return movies.getAllMovies().get(movieIndex).getScreeningsTime();
    }

    // Show the tickets screen
    public static void switchToTicketsWindow(Screening selectedScreening){
        orderBuilder.buildScreening(selectedScreening);

        currentScreen.setVisible(false);

        currentScreen = new TicketsScreen(selectedScreening);
        currentScreen.setVisible(true);
    }

    // Show the theater top view (seats) screen
    public static void switchToSeatsWindow(Screening selectedScreening, int numOfTickets){
        currentScreen.setVisible(false);

        if (selectedScreening.getTheater() instanceof MultiDimTheater)
            currentScreen = new SeatsMultiDimScreen(numOfTickets, selectedScreening.getTheater());
        else if (selectedScreening.getTheater() instanceof VipTheater)
            currentScreen = new SeatsVIPScreen(numOfTickets, selectedScreening.getTheater());
        else
            currentScreen = new SeatsRegularScreen(numOfTickets, selectedScreening.getTheater());

        currentScreen.setVisible(true);
    }

    // Checks if there is enough empty seats in the theater
    public static void IsValidNumberOfTickets(Screening selectedScreening, int[] tickets){
        int numOfTickets = Arrays.stream(tickets).sum();
        boolean flag =  selectedScreening.getTheater().isValidNumberOfTickets(numOfTickets);

        if (flag){
            buildTickets(tickets);
            switchToSeatsWindow(selectedScreening, numOfTickets);
        }
        else{
            String message = "There is not enough seats in the theater.\nPlease select less tickets.";
            JOptionPane.showMessageDialog(currentScreen, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Tickets builder for the order (data from the screen)
    private static void buildTickets(int[] numOfTickets){
        Tickets tickets = new Tickets();

        tickets.setNumOfTypeTickets("Standard", numOfTickets[0]);
        tickets.setNumOfTypeTickets("Student", numOfTickets[1]);
        tickets.setNumOfTypeTickets("Veteran", numOfTickets[2]);
        tickets.setNumOfTypeTickets("Policeman/Soldier", numOfTickets[3]);

        orderBuilder.buildTickets(tickets);
        orderBuilder.buildTotalBill();
    }

    // Changes the selected seats status to TAKEN and changes to the order summary screen
    public static void switchToOrderDetailsAndConfirmation(Theater theater, int rows, int cols){
        StringBuilder selectedSeats = new StringBuilder("");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (theater.getSeats()[i][j] == EnumSeats.SELECTED) {
                    theater.setSeat(i+1, j+1, EnumSeats.TAKEN);
                    selectedSeats.append("\nRow - ").append(i+1).append(" Col - ").append(j+1);
                }
            }
        }

        orderBuilder.buildSeats(selectedSeats.toString());

        currentScreen.setVisible(false);

        currentOrder = orderBuilder.getOrder();
        currentScreen = new OrderSummaryScreen(currentOrder);
        currentScreen.setVisible(true);
    }

    // Checks if the phone number is valid and saves the order
    public static void PlaceOrder(String phoneNumber){
        user = new User();

        if (!user.phoneNumberValidation(phoneNumber)){
            String message = "The phone number is invalid.";
            JOptionPane.showMessageDialog(currentScreen, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            user.setPhoneNumber(phoneNumber);
            currentOrder.setUserPhoneNumber(phoneNumber);
            orders.addOrder(currentOrder);

            mainScreen.setVisible(true);
            currentScreen.setVisible(false);
        }
    }
}
