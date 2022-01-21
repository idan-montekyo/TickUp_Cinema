package Model.MoviesAndScreenings;

import java.util.HashMap;

// Class for holding all four kinds of tickets
public class Tickets {
    // Fields
    private HashMap<String, Integer> ticketsQuantity;

    //Constructor - Initialize 4 types of tickets and their quantities
    public Tickets() {
        this.ticketsQuantity = new HashMap<>();
        this.ticketsQuantity.put("Standard", 0);
        this.ticketsQuantity.put("Student", 0);
        this.ticketsQuantity.put("Veteran", 0);
        this.ticketsQuantity.put("Policeman/Soldier", 0);
    }

    // Get quantity of specific ticket type at specific order
    public int getNumOfTypeTickets(String type) {
        return this.ticketsQuantity.get(type);
    }

    // Set quantity of specific ticket type for specific order
    public void setNumOfTypeTickets(String type, int numOfTickets) {

        this.ticketsQuantity.put(type, numOfTickets);
    }

    // Display all quantities of all types of ticket at specific order
    public void displayAllNumOfTypeTickets() {
        for (String i : this.ticketsQuantity.keySet()) {
            System.out.println("key: " + i + " value: " + this.ticketsQuantity.get(i));
        }
    }

    // Returns the sum of the tickets quantities
    private int totalNumberOfTickets(){
        int total = 0;

        for (int tickets : this.ticketsQuantity.values()){
            total += tickets;
        }

        return total;
    }

    @Override
    public String toString() {
        return "\nTickets:" +
                "\nStandard tickets - " + this.ticketsQuantity.get("Standard") +
                "\nStudent tickets - " + this.ticketsQuantity.get("Student") +
                "\nVeteran tickets - " + this.ticketsQuantity.get("Veteran") +
                "\nPoliceman / Soldier tickets - " + this.ticketsQuantity.get("Policeman/Soldier");
    }
}
