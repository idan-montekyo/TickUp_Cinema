package Controller;
import Model.*;
import View.*;

import javax.swing.*;

public class Manager {
    private static MainScreen mainScreen = new MainScreen();
    private static MoviesFrame currentScreen;
    private static Employees employees = new Employees();

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
}
