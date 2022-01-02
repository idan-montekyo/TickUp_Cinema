import java.util.HashMap;

public class Ticket {


    private HashMap<String, Integer> ticketsPrices = new HashMap<String, Integer>();

    public Ticket() {
        this.ticketsPrices = ticketsPrices;
        this.ticketsPrices.put("Standard", 0);
        this.ticketsPrices.put("Soldier", 0);
        this.ticketsPrices.put("Cup", 0);
        this.ticketsPrices.put("Student", 0);
        this.ticketsPrices.put("Veteran", 0);
    }

    public int getNumOfTypeTickets(String type){
       return this.ticketsPrices.get(type);
    }

    public void SetNumOfTypeTickets(String type, int numOfTickets){
        this.ticketsPrices.put("Student", numOfTickets);
    }

    public void displayAllNumOfTypeTickets(){
        for (String i : this.ticketsPrices.keySet()) {
            System.out.println("key: " + i + " value: " + this.ticketsPrices.get(i));
        }
    }
}
