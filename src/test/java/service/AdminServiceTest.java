package service;

import model.*;
import org.junit.Test;
import repository.ClientRepository;
import repository.TerminalRepository;
import util.AssetType;
import util.Fine;
import util.InProgress;
import util.KeyGenerator;

import static org.junit.Assert.*;

public class AdminServiceTest {

    ClientRepository clientRepository = new ClientRepository();
    TerminalRepository terminalRepository = new TerminalRepository();


    AdminService adminService = new AdminService();
    Client client = new Client("Test", "Test", 111111, "Test");
    Zone zone = new Zone("CABA", 1);
    Terminal terminal = new Terminal(zone, "Hola");
    AssetType assetType = new AssetType("moto", 1, 1);
    PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, 1);
    Asset asset = new Asset(zone, assetType, terminal,purchaseLot);


    Trip trip = new Trip(client);
    InProgress inProgress = new InProgress(trip);
    Discount discount = new Discount(assetType, 1, zone, 1);

    Client client1 = new Client("Test1", "Test1", 1111111, "Test1");
    Client client2 = new Client("Test2", "Test2", 1111112, "Test2");
    Client client3 = new Client("Test3", "Test3", 1111113, "Test3");





    @Test
    public void blockClient() {
        clientRepository.create(client);
        clientRepository.create(client1);
        clientRepository.create(client2);
        clientRepository.create(client3);

        terminalRepository.create(terminal);

        adminService.blockClient(client);
        assertSame(true, client.isBlocked());
    }

    @Test
    public void unBlockClient() {
        clientRepository.create(client);
        clientRepository.create(client1);
        clientRepository.create(client2);
        clientRepository.create(client3);

        terminalRepository.create(terminal);

        adminService.unBlockClient(client);
        assertSame(false, client.isBlocked());
    }

    @Test
    public void reportTrip() {
        trip.setZone(zone);
        trip.setTripState(inProgress);
        Fine fine = new Fine(trip.getZone(), 1);
        assertTrue(fine.equals(adminService.reportTrip(trip, terminal, 1)));
    }

    @Test
    public void createAsset(){
        assertTrue(asset.equals(adminService.createAsset(zone, assetType, terminal, purchaseLot)));
    }

    @Test
    public void createDiscount(){

        assertTrue(discount.equals(adminService.createDiscount(assetType, 1,zone, 1)));
    }

    @Test
    public void createTerminal() {
        assertTrue(terminal.equals(adminService.createTerminal(zone, "Hola")));
    }

    @Test
    public void createPurchaseLot() {
        assertTrue(purchaseLot.equals(adminService.createPurchaseLot(zone, assetType, terminal, 1)));
        }
    }