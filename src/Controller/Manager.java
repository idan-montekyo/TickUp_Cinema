package Controller;
import Model.*;
import View.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static MainScreen mainScreen = new MainScreen();
    private static MoviesFrame currentScreen;
    private static Employees employees = new Employees();
    private static Movies movies = Movies.createMoviesList();

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

    public static String getMoviePicture(String movieName){
        String imagePath = "";
        for (Movie movie : movies.getAllMovies()) {
            if (movie.getMovieName().equals(movieName))
                imagePath = movie.getImagePath();
        }

        return imagePath;
    }
}
