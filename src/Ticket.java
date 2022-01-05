import java.util.HashMap;

// Crate a class for representing kind of ticket at the cinema

public class Ticket {

    // Fields

    private HashMap<String, Integer> ticketsPrices = new HashMap<String, Integer>();

    //Constructor - Initialize 3 types of tickets
    public Ticket() {
        this.ticketsPrices = ticketsPrices;
        this.ticketsPrices.put("Standard", 0);
        this.ticketsPrices.put("Student", 0);
        this.ticketsPrices.put("Veteran", 0);
    }

    // Get quantity of specific ticket type at specific order
    public int getNumOfTypeTickets(String type){
       return this.ticketsPrices.get(type);
    }

    // Set quantity of specific ticket type for specific order
    public void SetNumOfTypeTickets(String type, int numOfTickets){
        this.ticketsPrices.put("Student", numOfTickets);
    }

    // Display all quantity of all types of ticket at specific order
    public void displayAllNumOfTypeTickets(){
        for (String i : this.ticketsPrices.keySet()) {
            System.out.println("key: " + i + " value: " + this.ticketsPrices.get(i));
        }
    }
}
