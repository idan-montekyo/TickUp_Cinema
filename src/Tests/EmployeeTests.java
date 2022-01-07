package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Classes.Employee;

public class EmployeeTests {
    private Employee employee = null;


    @BeforeEach
    void setUp() {
        employee = new Employee(1234, 7453);
    }

    @Test
    void validLogin() {
        assertEquals(true, employee.login(1234, 7453));
    }

    @Test
    void InValidLogin() {
        assertEquals(false, employee.login(1234, 7454));
        assertEquals(false, employee.login(1254, 7454));

    }
}
