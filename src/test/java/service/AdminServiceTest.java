package service;

import model.*;
import org.junit.Test;
import repository.ClientRepository;
import repository.TerminalRepository;
import util.AssetType;
import util.Fine;
import util.KeyGenerator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

public class AdminServiceTest {

    ClientRepository clientRepository = new ClientRepository();
    TerminalRepository terminalRepository = new TerminalRepository();
    AdminService adminService = new AdminService();
    Client client = new Client("Test", "Test", 111111, "Test");
    Trip trip = new Trip(client);
    Zone zone = new Zone("Test", 1);
    Terminal terminal = new Terminal(zone, "Test");
    AssetType assetType = new AssetType("Test", 200, 200);
    PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, 12);
    Asset asset = new Asset(zone, assetType, terminal, purchaseLot);

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
        clientRepository.create(client);
        clientRepository.create(client1);
        clientRepository.create(client2);
        clientRepository.create(client3);

        terminalRepository.create(terminal);


        adminService.reportTrip(trip, terminal, 1);
        assertSame(true, client.isBlocked());
        assertSame(new Fine(zone, 1), adminService.reportTrip(trip,terminal,1));
        assertSame(terminal, trip.getAsset().getTerminal());
    }

    @Test
    public void createAsset(){
        clientRepository.create(client);
        clientRepository.create(client1);
        clientRepository.create(client2);
        clientRepository.create(client3);

        terminalRepository.create(terminal);

        assertSame(new AssetType("Test", 200, 200), adminService.createAsset(zone, assetType, terminal, purchaseLot));
        assertSame(terminal, asset.getTerminal());
    }

    @Test
    public void createDiscount(){
        clientRepository.create(client);
        clientRepository.create(client1);
        clientRepository.create(client2);
        clientRepository.create(client3);

        terminalRepository.create(terminal);

        adminService.createDiscount(assetType, 100, zone, 100);
        assertSame(new Discount(assetType, 100, zone, 100), adminService.createDiscount(assetType, 100, zone, 100));
    }

    @Test
    public void createTerminal() {
        clientRepository.create(client);
        clientRepository.create(client1);
        clientRepository.create(client2);
        clientRepository.create(client3);

        terminalRepository.create(terminal);

        adminService.createTerminal(zone, "Test");
        assertSame(new Terminal(zone, "Test"), adminService.createTerminal(zone, "Test"));
    }

    @Test
    public void createPurchaseLot() {
        clientRepository.create(client);
        clientRepository.create(client1);
        clientRepository.create(client2);
        clientRepository.create(client3);

        terminalRepository.create(terminal);

        adminService.createPurchaseLot(zone, assetType,terminal, 1);
        assertSame(new PurchaseLot(zone, assetType, 12), adminService.createPurchaseLot(zone, assetType, terminal, 1));
        }
    }