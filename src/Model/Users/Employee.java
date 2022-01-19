package Model.Users;

import Model.MovieOrders.Orders;

public class Employee extends User{

    // Fields
    private final int personalNumber;

    // Constructor
    public Employee(int personalNumber){
        this.personalNumber = personalNumber;
    }

    // Check if Employee' personal number and password are valid
    public boolean login(int personalNumber){
        return this.personalNumber == personalNumber;
    }


}
