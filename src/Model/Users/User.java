package Model.Users;

import Model.Enums.EnumSeats;
import Model.MoviesAndScreenings.Movie;
import Model.MoviesAndScreenings.Movies;
import Model.MoviesAndScreenings.Screening;
import Model.MoviesAndScreenings.Tickets;

import java.util.List;

public class User {
    // Fields
    private String phoneNumber;
    String regex = "05[0-9]+";

    // Constructor
    public User() {}

    // Getter
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Phone number validation
    public boolean phoneNumberValidation(String phone) {
        return phone.length() == 10 && phone.matches(regex);
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

        if(x >= 0) {
            return movieList.getAllMovies().get(x);
        } else {
            return null;
        }
    }


    // Select amount of tickets of: Standard, Student and Veteran - Up to 8 tickets
    public Tickets selectTicketsUpToEight(int standard, int student, int veteran, int other) {
        int sum = standard + student + veteran;
        if(sum > 8) {
            return null;
        } else {
            Tickets ticket = new Tickets();
            ticket.setNumOfTypeTickets("Standard", standard);
            ticket.setNumOfTypeTickets("Student", student);
            ticket.setNumOfTypeTickets("Veteran", veteran);
            ticket.setNumOfTypeTickets("Policeman/Soldier", other);

            return ticket;
        }
    }
}