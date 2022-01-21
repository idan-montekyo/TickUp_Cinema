package Model.Users;

import java.util.ArrayList;

// Class that holds all employees data
public class Employees {
    // Field
    private final ArrayList<Employee> employees;

    // Constructor
    public Employees(){
        employees = new ArrayList<>();
    }

    // Getter
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    // Add new employee to the list
    public void addNewEmployee(Employee employee){
        employees.add(employee);
    }

    // Checks if the login data is valid
    public boolean login(int personalNumber){
        for (Employee e: employees) {
            if(e.login(personalNumber))
                return true;
        }

        return false;
    }
}
