package Model;

public class Employee extends User{

    // Fields
    private int personalNumber;
    private int password;

    // Constructor
    public Employee(int personalNumber, int password){
        this.personalNumber = personalNumber;
        this.password = password;
    }


    // Check if Employee' personal number and password are valid
    public boolean login(int personalNumber, int password){
        if(this.personalNumber == personalNumber && this.password == password){
            System.out.println("Login Success!");
            return true;
        }
        System.out.println("Login Fail!");
        return false;
    }

    // Access to user orders
    public void viewUserOrders(Orders userOrders){
        userOrders.displayOrders();
    }



    // updateMovie - At this stage we decided to create a default list of movies...

}
