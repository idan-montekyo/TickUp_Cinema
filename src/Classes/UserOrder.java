package Classes;

// Crate a class for a single order.
public class UserOrder {

    // Constant
    final double STUDENT_DISCOUNT = 0.6;
    final double VETERAN_DISCOUNT = 0.4;

    // Fields
    private final String userPhoneNumber;
    private final Movie movie;
    private final Screening screening;
    private final Ticket tickets = new Ticket();
    private final double totalBill;

    // Constructor
    public UserOrder(String userPhoneNumber, Movie movie, Screening screening, int standard , int student, int veteran){

        this.userPhoneNumber = userPhoneNumber;
        this.movie = movie;
        this.screening = screening;
        this.tickets.setNumOfTypeTickets("Standard", standard);
        this.tickets.setNumOfTypeTickets("Student", student);
        this.tickets.setNumOfTypeTickets("Veteran", veteran);
        this.totalBill = getBill();
    }

    // Calculate total price for specific order
    public int getBill() {
        int bill = 0;
        int originalPrice = this.screening.getTheater().getPrice();
        bill += this.tickets.getNumOfTypeTickets("Standard") * originalPrice;
        bill += this.tickets.getNumOfTypeTickets("Student") * originalPrice * STUDENT_DISCOUNT;
        bill += this.tickets.getNumOfTypeTickets("Veteran") * originalPrice * VETERAN_DISCOUNT;

        return bill;
    }

    @Override
    public String toString() {
        return "Order for user: " + userPhoneNumber +
                "\nClasses.Movie: " + movie.getMovieName() +
                "\nDuration: " + movie.getDuration() +
                "\nStarts at: " + screening.getStartingTime() +
                "\n" + screening.getTheater().getTheaterType() + " - " + screening.getTheater().getTheaterNumber() +
                "\n" + tickets +
                "\nTotal bill: " + totalBill;
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

    public Ticket getTickets() {
        return tickets;
    }

    public double getTotalBill() {
        return totalBill;
    }
}
