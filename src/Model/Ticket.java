package Model;

import java.util.HashMap;

// Crate a class for holding all three kinds of tickets.
public class Ticket {

    // Fields
    private HashMap<String, Integer> ticketsQuantity;

    //Constructor - Initialize 3 types of tickets
    public Ticket() {
        this.ticketsQuantity = new HashMap<>();
        this.ticketsQuantity.put("Standard", 0);
        this.ticketsQuantity.put("Student", 0);
        this.ticketsQuantity.put("Veteran", 0);
    }

    // Get quantity of specific ticket type at specific order
    public int getNumOfTypeTickets(String type) {
        return this.ticketsQuantity.get(type);
    }

    // Set quantity of specific ticket type for specific order
    public void setNumOfTypeTickets(String type, int numOfTickets) {

        this.ticketsQuantity.put(type, numOfTickets);
    }


    // Display all quantity of all types of ticket at specific order
    public void displayAllNumOfTypeTickets() {
        for (String i : this.ticketsQuantity.keySet()) {
            System.out.println("key: " + i + " value: " + this.ticketsQuantity.get(i));
        }
    }

    @Override
    public String toString() {
        return "Amount of Standard-tickets: " + this.ticketsQuantity.get("Standard") +
                "\nAmount of Student-tickets: " + this.ticketsQuantity.get("Student") +
                "\nAmount of Veteran-tickets: " + this.ticketsQuantity.get("Veteran");
    }
}
