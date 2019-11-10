package service;

import org.junit.Test;

import static org.junit.Assert.*;

public class SignUpServiceTest {
    SignUpService signUpService = new SignUpService();


    @Test
    public void signUp() {
        assertEquals("Username and password validated.", signUpService.signUp("test", 1));
        assertEquals("Username or phone number already exists.", signUpService.signUp("test", 1));
    }


    @Test
    public void registerClient(){
        assertEquals("Nickname already exists.", signUpService.registerClient("Test", 1, "test", "Test"));
        assertEquals("Registered successfully.",signUpService.registerClient("Test", 1, "Test", "Test"));
    }
}