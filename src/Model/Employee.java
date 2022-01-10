package Model;

public class Employee extends User{

    // Fields
    private int personalNumber;

    // Constructor
    public Employee(int personalNumber){
        this.personalNumber = personalNumber;
    }

    // Check if Employee' personal number and password are valid
    public boolean login(int personalNumber){
        if(this.personalNumber == personalNumber){
            return true;
        }
        return false;
    }

    // Access to user orders
    public void viewUserOrders(Orders userOrders){
        userOrders.displayOrders();
    }



    // updateMovie - At this stage we decided to create a default list of movies...

}
