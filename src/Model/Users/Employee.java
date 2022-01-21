package Model.Users;

public class Employee extends User{
    // Fields
    private final int personalNumber;

    // Constructor
    public Employee(int personalNumber){
        this.personalNumber = personalNumber;
    }

    // Check if Employee's personal number is valid
    public boolean login(int personalNumber){
        return this.personalNumber == personalNumber;
    }
}
