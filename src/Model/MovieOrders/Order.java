package Model.MovieOrders;

import Model.MoviesAndScreenings.Movie;
import Model.MoviesAndScreenings.Screening;
import Model.MoviesAndScreenings.Tickets;

// Crate a class for a single order.
public class Order {
    // Defines
    private static final double STUDENT_UNIFORM_DISCOUNT = 0.6;
    private static final double VETERAN_DISCOUNT = 0.4;

    // Fields
    private String userPhoneNumber;
    private Movie movie;
    private Screening screening;
    private Tickets tickets;
    private String selectedSeats;
    private double totalBill;

    // Constructor
    public Order(){
        this.tickets = new Tickets();
    }

    // Getters
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screening getScreening() {
        return screening;
    }

    public Tickets getTickets() {
        return tickets;
    }

    public double getTotalBill() {
        return totalBill;
    }

    // Setters
    public void setUserPhoneNumber(String userPhoneNumber){
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public void setScreening(Screening screening){
        this.screening = screening;
    }

    public void setTickets(Tickets tickets){
        this.tickets = tickets;
    }

    public void setTotalBill(){
        this.totalBill = calculateBill();
    }

    public void setSeats(String seats){
        this.selectedSeats = seats;
    }


    // Calculate total price for specific order
    public int calculateBill() {
        int bill = 0;
        int originalPrice = this.screening.getTheater().getPrice();
        bill += this.tickets.getNumOfTypeTickets("Standard") * originalPrice;
        bill += this.tickets.getNumOfTypeTickets("Student") * originalPrice * STUDENT_UNIFORM_DISCOUNT;
        bill += this.tickets.getNumOfTypeTickets("Veteran") * originalPrice * VETERAN_DISCOUNT;
        bill += this.tickets.getNumOfTypeTickets("Policeman/Soldier") * originalPrice * STUDENT_UNIFORM_DISCOUNT;

        return bill;
    }

    @Override
    public String toString() {
        return "Movie: " + movie.getMovieName() +
                "\n\nTheater number " + screening.getTheater().getTheaterNumber() +
                ": " + screening.toString() +
                "\n" + tickets.toString() +
                "\n\nSelected seats: " + selectedSeats +
                "\n\n\nTotal bill: " + totalBill;
    }
}
