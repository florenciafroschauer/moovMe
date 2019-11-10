package service;

import model.*;
import org.junit.Test;
import util.AssetType;
import util.KeyGenerator;
import util.Voucher;

import static org.junit.Assert.*;

public class ClientServiceTest {
    public Client client = new Client("Test", "Test", 111111, "Test");
    public ClientService clientService = new ClientService(client);
    public Zone zone = new Zone("a", 1);
    public AssetType assetType = new AssetType("a", 1, 1);
    public Discount discount = new Discount(assetType, 10, zone, 10);
    Voucher voucher = new Voucher("Test");

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
    public void buyDiscounts(){//COMPRO EL DESCUENTO???
        clientService.buyDiscount(discount);
        assertTrue(client.getDiscounts().contains(discount));
    }

    @Test
    public void useDiscounts(){
        clientService.useDiscount(discount);
        assertEquals(false, client.getDiscounts().contains(discount));
    }

    @Test
    public void useVoucher(){
        clientService.useVoucher(voucher);
        assertEquals(false, client.getVouchers().contains(voucher));
    }


}