package Model.MovieOrders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Create a class that holds all orders
public class Orders {
    // Fields
    private final ArrayList<Order> allOrders;

    // Constructor
    public Orders() {
        allOrders = new ArrayList<>();
    }

    // Getters
    public List<Order> getAllOrders() {
        return allOrders;
    }

    public int getNumOfOrders(){
        return this.allOrders.size();
    }


    // Add a new order to allOrders list
    public void addOrder(Order order) {
        allOrders.add(order);
    }

    // Display all data about each order: User, movie, duration, starting time, theater type and number, bill.
    public void displayOrders() {
        //Traversing list through Iterator
        Iterator itr = this.allOrders.iterator();//getting the Iterator
        while (itr.hasNext()) {//check if iterator has the elements
            System.out.println();
            System.out.println("------------------------------------------------------------------------");
            System.out.println();
            System.out.println(itr.next());//printing the element and move to next
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
