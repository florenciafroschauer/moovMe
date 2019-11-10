package service;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class LogInServiceTest {
    LogInService logInService = new LogInService();

    @Test
    public void clientLogIn() {
        assertEquals("Invalid nickname or password.", logInService.clientLogIn("test", "test"));
        assertEquals("Successful log in!", logInService.clientLogIn("test", "test"));

    }

    @Test
    public void adminLogIn() {
        assertEquals("Invalid username or password.",logInService.AdminLogIn("test", "test"));
        assertEquals("Successful log in!",logInService.AdminLogIn("test", "test"));

    }
}
