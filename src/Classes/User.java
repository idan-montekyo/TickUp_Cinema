package Classes;


import java.util.HashMap;
import java.util.List;

public class User {


    // Constructor
    public User() {

    }

    // Display all movies
    public void displayMoviesForSelection(Movies movies) {
        movies.displayMovies();
    }


    // User movie selection
    public Movie selectMovieByName(Movies movieList, String movieName) {
        int x = -1;
        switch(movieName) {
            case "Spiderman" -> x = 0;
            case "Hangover" -> x = 1;
            case "Lord Of The Rings" -> x = 2;
            case "Harry Potter" -> x = 3;
            case "Pirates Of The Caribbean" -> x = 4;
        }

        if(x > 0) {
            return movieList.getAllMovies().get(x);
        } else {
            return null;
        }
    }


    public List<Screening> selectScreening(Movie m) {
        return m.getScreeningsTime();

    }

    public Ticket selectTicketsUpToEight(int standard, int student, int veteran) {
        int sum = standard + student + veteran;
        if(sum > 8) {
            return null;
        } else {
            Ticket ticket = new Ticket();
            ticket.setNumOfTypeTickets("Standard", standard);
            ticket.setNumOfTypeTickets("Student", student);
            ticket.setNumOfTypeTickets("Veteran", veteran);

            return ticket;
        }
    }

    public boolean selectUserSeats(Screening screening, int[][] userSelection) {

        for(int row = 0; row < userSelection.length; row++){
            if(screening.getTheaterMatrix()[userSelection[row][0]][userSelection[row][1]].equals(EnumSeats.TAKEN)){
                return false;
            }
        }

        for(int row = 0; row < userSelection.length; row++){
            screening.selectSeat(userSelection[row][0], userSelection[row][1]);
        }
        return true;

    }

    // public placeOrder()
}