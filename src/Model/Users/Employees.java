package Model.Users;

import Model.Users.Employee;

import java.util.ArrayList;

public class Employees {
    private ArrayList<Employee> employees;

    public Employees(){
        employees = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addNewEmployee(Employee employee){
        employees.add(employee);
    }

    public boolean login(int personalNumber){
        for (Employee e: employees) {
            if(e.login(personalNumber))
                return true;
        }

        return false;
    }
}
