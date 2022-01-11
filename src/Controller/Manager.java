package Controller;
import Model.DemoData;
import Model.MoviesAndScreenings.Movie;
import Model.MoviesAndScreenings.Movies;
import Model.MoviesAndScreenings.Screening;
import Model.Users.Employees;
import View.*;

import javax.swing.*;
import java.util.ArrayList;

public class Manager {
    private static MainScreen mainScreen = new MainScreen();
    private static MoviesFrame currentScreen;
    private static Employees employees;
    private static Movies movies;

    public Manager(){
        employees = DemoData.initializeDemoEmployees();
        movies = DemoData.initializeDemoMovies();
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
        currentScreen = new OrdersManagerScreen();

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

    public static ArrayList<String> getMoviesTitles(){
        ArrayList<String> moviesTitles = new ArrayList<>();

        for (Movie movie : movies.getAllMovies()) {
            moviesTitles.add(movie.getMovieName());
        }

        return moviesTitles;
    }

    public static String getMoviePoster(String movieName){
        String imagePath = "";

        for (Movie movie : movies.getAllMovies()) {
            if (movie.getMovieName().equals(movieName))
                imagePath = movie.getImagePath();
        }

        return imagePath;
    }

    public static void switchToMovieInfoWindow(String movieName, String movieImagePath){
        currentScreen.setVisible(false);

        currentScreen = new MovieInfo(movieName, movieImagePath);
        currentScreen.setVisible(true);
    }

    public static String getMovieSummary(String movieName){
        String summary = "";

        for (Movie movie : movies.getAllMovies()) {
            if (movie.getMovieName().equals(movieName))
                summary = movie.getSummary();
        }

        return summary;
    }

    public static ArrayList<Screening> getMovieScreenings(String movieName){
        ArrayList<Screening> screenings = new ArrayList<>();

        for (Movie movie : movies.getAllMovies()) {
            if (movie.getMovieName().equals(movieName))
                screenings = movie.getScreeningsTime();
        }

        return screenings;
    }

    public static void switchToTicketsWindow(Screening selectedScreening){
        currentScreen.setVisible(false);

        currentScreen = new TicketsScreen();
        currentScreen.setVisible(true);
    }
}
