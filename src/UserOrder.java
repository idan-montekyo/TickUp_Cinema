public class UserOrder {

    // Fields
    // Constant

    final double STUDENT_DISCOUNT = 0.4;
    final double VETERAN_DISCOUNT = 0.6;

    private String userPhoneNumber;
    private Movie movie;
    private Screening screening;
    private Ticket[] tickets;
    private double totalBill;

    public UserOrder(String userPhoneNumber, Movie movie, Screening screening, Ticket tickets){
        this.userPhoneNumber = userPhoneNumber;
        this.movie = movie;
        this.screening = screening;
        this.totalBill = getBill();

    }

    // Calculate total price for specific order
    public void getBill() {
        int bill;
        bill = this.ticketsQuantity.get("Standard") *
    }

}
