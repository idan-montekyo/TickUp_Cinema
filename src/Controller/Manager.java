package Controller;
import Model.DemoData;
import Model.MovieOrders.Orders;
import Model.MovieOrders.Order;
import Model.MoviesAndScreenings.Movie;
import Model.MoviesAndScreenings.Movies;
import Model.MoviesAndScreenings.Screening;
import Model.Theaters.MultiDimTheater;
import Model.Theaters.StandardTheater;
import Model.Theaters.VipTheater;
import Model.Users.Employees;
import View.*;
import View.SeatsMultiDimScreen;
import View.SeatsRegularScreen;
import View.SeatsVIPScreen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager {
    private static MainScreen mainScreen = new MainScreen();
    private static MoviesFrame currentScreen;
    private static Employees employees;
    private static Movies movies;
    private static Orders orders;

    public Manager(){
        employees = DemoData.initializeDemoEmployees();
        movies = DemoData.initializeDemoMovies();
        orders = DemoData.initializeDemoOrders(movies);
    }


    public void ShowMainScreen(){
        mainScreen.setVisible(true);
    }

    public static void switchToMoviesWindow(){
        currentScreen = new MoviesScreen();

        currentScreen.setVisible(true);
        mainScreen.setVisible(false);
    }

    public static void switchToOrdersWindow(){
        currentScreen = new OrdersScreen();

        currentScreen.setVisible(true);
        mainScreen.setVisible(false);
    }

    public static boolean loginUser(){
        String message = "Please enter your employee id number:";
        String userId = JOptionPane.showInputDialog(mainScreen, message, null);

        if(employees.login(Integer.parseInt(userId)))
            return true;

        return false;
    }

    public static ArrayList<String> getOrdersPhones(){
        ArrayList<String> ordersPhones = new ArrayList<>();

        for (Order order : orders.getAllOrders()) {
            ordersPhones.add(order.getUserPhoneNumber());
        }

        return ordersPhones;
    }

    public static String getOrderInfo(int orderIndex){
        return orders.getAllOrders().get(orderIndex).toString();
    }

    public static ArrayList<String> getMoviesTitles(){
        ArrayList<String> moviesTitles = new ArrayList<>();

        for (Movie movie : movies.getAllMovies()) {
            moviesTitles.add(movie.getMovieName());
        }

        return moviesTitles;
    }

    public static String getMovieName(int movieIndex){
        return movies.getAllMovies().get(movieIndex).getMovieName();
    }

    public static String getMoviePoster(int movieIndex){
        return movies.getAllMovies().get(movieIndex).getImagePath();
    }

    public static void switchToMovieInfoWindow(int movieIndex){
        currentScreen.setVisible(false);

        currentScreen = new MovieInfo(movieIndex);
        currentScreen.setVisible(true);
    }

    public static String getMovieSummary(int movieIndex){
        return movies.getAllMovies().get(movieIndex).getSummary();
    }

    public static ArrayList<Screening> getMovieScreenings(int movieIndex){
        return movies.getAllMovies().get(movieIndex).getScreeningsTime();
    }

    public static void switchToTicketsWindow(Screening selectedScreening){
        currentScreen.setVisible(false);

        currentScreen = new TicketsScreen(selectedScreening);
        currentScreen.setVisible(true);
    }

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

    public static void IsValidNumberOfTickets(Screening selectedScreening, int[] tickets){
        int numOfTickets = Arrays.stream(tickets).sum();
        boolean flag =  selectedScreening.getTheater().isValidNumberOfTickets(numOfTickets);

        if (flag)
            switchToSeatsWindow(selectedScreening, numOfTickets);
        else{
            String message = "There is not enough seats in the theater.\nPlease select less tickets.";
            JOptionPane.showMessageDialog(currentScreen, message, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
