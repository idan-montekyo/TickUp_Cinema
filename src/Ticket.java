import java.util.HashMap;

// Crate a class for representing kind of ticket at the cinema

public class Ticket {

    // Fields


    private HashMap<String, Integer> ticketsQuantity = new HashMap<String, Integer>();

    //Constructor - Initialize 3 types of tickets
    public Ticket() {
        this.ticketsQuantity.put("Standard", 0);
        this.ticketsQuantity.put("Student", 0);
        this.ticketsQuantity.put("Veteran", 0);
    }

    // Get quantity of specific ticket type at specific order
    public int getNumOfTypeTickets(String type) {

        return this.ticketsQuantity.get(type);
    }

    // Set quantity of specific ticket type for specific order
    public void SetNumOfTypeTickets(String type, int numOfTickets) {

        this.ticketsQuantity.put("Student", numOfTickets);
    }



    // Display all quantity of all types of ticket at specific order
    public void displayAllNumOfTypeTickets() {
        for (String i : this.ticketsQuantity.keySet()) {
            System.out.println("key: " + i + " value: " + this.ticketsQuantity.get(i));
        }
    }
}
