package Model;

import java.util.ArrayList;

public class Employees {
    private ArrayList<Employee> employees;

    public Employees(){
        employees = new ArrayList<>();
        initializeDemoEmployees();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    private void initializeDemoEmployees(){
        Employee e1 = new Employee(1234);
        Employee e2 = new Employee(1235);
        Employee e3 = new Employee(1236);
        Employee e4 = new Employee(1237);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
    }

    public boolean login(int personalNumber){
        for (Employee e: employees) {
            if(e.login(personalNumber))
                return true;
        }

        return false;
    }
}
