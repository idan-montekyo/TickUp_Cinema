package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import Model.Users.Employee;
import Model.Users.Employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeesTest {
    private Employees employees = null;

    @BeforeEach
    void setUp() {
        Employee e1 = new Employee(1);
        Employee e2 = new Employee(2);
        Employee e3 = new Employee(3);

        employees = new Employees();
        employees.addNewEmployee(e1);
        employees.addNewEmployee(e2);
        employees.addNewEmployee(e3);
    }

    // Testing employee's existence in employees list.
    @Test
    void EmployeeIncludedTest() {
        assertTrue(employees.login(1));
        assertTrue(employees.login(2));
        assertTrue(employees.login(3));
    }

    // Testing the existence of not included employee numbers.
    @Test
    void EmployeeNotIncludedTest() {
        assertFalse(employees.login(5));
        assertFalse(employees.login(-5));
    }

}
