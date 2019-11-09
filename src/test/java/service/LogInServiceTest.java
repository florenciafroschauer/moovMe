package service;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class LogInServiceTest {
    LogInService logInService = new LogInService();

    @Test
    public void clientLogIn() {
        logInService.clientLogIn("test", "test");
    }

    @Test
    public void adminLogIn() {
        logInService.AdminLogIn("test", "test");

    }
}
