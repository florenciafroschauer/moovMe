package service;

import model.Client;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientServiceTest {
    public Client client = new Client("Test", "Test", "111111", "Test");
    public ClientService clientService = new ClientService();
    @Test
    public void showScore() {
        clientService.showScore(client);
        assertEquals(client.getAccumulatedScore(), clientService.showScore(client));
    }

    @Test
    public void showDiscounts() {
        clientService.showDiscounts(client);
        assertEquals(client.getDiscounts(), clientService.showDiscounts(client));
    }
    @Test

    public void showVouchers(){
        clientService.showDiscounts(client);
        assertEquals(client.getVouchers(), clientService.showVouchers(client));
    }
    @Test
    public void showPhoneNumber(){
        clientService.showPhoneNumber(client);
        assertEquals(client.getPhoneNumber(), clientService.showPhoneNumber(client));
    }

    @Test
    public void showNickname(){
        clientService.showNickname(client);
        assertEquals(client.getNickname(), clientService.showNickname(client));
    }

    @Test
    public void buyDiscounts(){//Hacerlo

    }

    @Test
    public void useDiscounts(){//Hacerlo

    }

    @Test
    public void useVoucher(){//Hacerlo

    }


}