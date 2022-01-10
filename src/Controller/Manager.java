package Controller;
import Model.*;
import View.*;

public class Manager {

    public static void main(String[] args) {
        runProgram();
    }

    private static void runProgram(){
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }
}
