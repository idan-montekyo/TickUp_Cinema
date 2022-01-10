package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Crate a class that holds all user-orders.
public class Orders {

    // Fields
    private final List<UserOrder> allOrders;

    // Constructor
    public Orders(List<UserOrder> orders) {
        this.allOrders = orders;
    }

    // Getters
    public List<UserOrder> getAllOrders() {
        return allOrders;
    }

    public int GetNumOfOrders(){
        return this.allOrders.size();
    }


    // Add a new order to allOrders list
    public void addOrder(UserOrder order) {
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

    // Creating and initializing our order-list.
    public static Orders create_user_orders(Movies movieList) {

        // All of our movies
        Movie m_Spiderman = movieList.getAllMovies().get(0);
        Movie m_Hangover = movieList.getAllMovies().get(1);
        Movie m_LordOfTheRings = movieList.getAllMovies().get(2);
        Movie m_HarryPotter = movieList.getAllMovies().get(3);
        Movie m_PiratesOfTheCaribbean = movieList.getAllMovies().get(4);


        UserOrder order1 = new UserOrder("050-244-5837", m_Spiderman,
                m_Spiderman.getScreeningsTime().get(3), 1, 2, 3);

        UserOrder order2 = new UserOrder("052-735-7255", m_Hangover,
                m_Hangover.getScreeningsTime().get(0), 0, 4, 0);

        UserOrder order3 = new UserOrder("054-362-1356", m_LordOfTheRings,
                m_LordOfTheRings.getScreeningsTime().get(2), 2, 0, 3);

        UserOrder order4 = new UserOrder("055-290-3682", m_HarryPotter,
                m_HarryPotter.getScreeningsTime().get(1), 4, 0, 2);

        UserOrder order5 = new UserOrder("057-621-4289", m_PiratesOfTheCaribbean,
                m_PiratesOfTheCaribbean.getScreeningsTime().get(0), 2, 0, 0);


        List<UserOrder> orders_list = new ArrayList<>();
        orders_list.add(order1);
        orders_list.add(order2);
        orders_list.add(order3);
        orders_list.add(order4);
        orders_list.add(order5);

        return (new Orders(orders_list));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
