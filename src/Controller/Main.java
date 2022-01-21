package Controller;

public class Main {

    public static void main(String[] args) {
        runProgram();
    }

    // Runs the app manager
    private static void runProgram(){
        ProgramManager manager = new ProgramManager();

        manager.ShowMainScreen();
    }
}
