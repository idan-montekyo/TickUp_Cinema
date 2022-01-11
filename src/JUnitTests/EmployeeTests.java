package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Users.Employee;

public class EmployeeTests {
    private Employee employee = null;


    @BeforeEach
    void setUp() {
        employee = new Employee(1234);
    }

    // Test for success login
    @Test
    void validLogin() {
        assertEquals(true, employee.login(1234));
    }

    // Test for unsuccessful login
    @Test
    void InValidLogin() {
        assertEquals(false, employee.login(1234));
        assertEquals(false, employee.login(1254));
    }
}
