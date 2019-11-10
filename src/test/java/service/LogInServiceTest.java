package service;


import model.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import repository.ClientRepository;

import static org.junit.Assert.*;

public class LogInServiceTest {
    LogInService logInService = new LogInService();
    ClientRepository clientRepository = new ClientRepository();
    Client client = new Client("Hola", "Hola", 12, "Hola");

    @Test
    public void clientLogIn() {

        assertEquals("Invalid nickname or password.", logInService.clientLogIn("Hola", "Hola"));
        assertEquals("Successful log in!", logInService.clientLogIn("test", "test"));

    }

    @Test
    public void adminLogIn() {
        assertEquals("Invalid username or password.",logInService.AdminLogIn("Hola", "Hola"));
        assertEquals("Successful log in!",logInService.AdminLogIn("test", "test"));

    }
}
