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

    // Test for successful login
    @Test
    void validLogin() {
        assertTrue(employee.login(1234));
    }

    // Test for unsuccessful login
    @Test
    void InValidLogin() {
        assertFalse(employee.login(1243));
    }
}
