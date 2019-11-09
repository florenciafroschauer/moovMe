package service;

import model.*;
import org.junit.Test;
import util.AssetType;
import util.Fine;
import util.KeyGenerator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

public class AdminServiceTest {
    AdminService adminService = new AdminService();
    Client client = new Client("Test", "Test", "111111", "Test");
    Trip trip = new Trip(client);
    Zone zone = new Zone("Test", 1);
    Terminal terminal = new Terminal(zone, "Test");
    KeyGenerator keyGenerator = new KeyGenerator();
    AssetType assetType = new AssetType("Test", 200, 200);
    PurchaseLot purchaseLot = new PurchaseLot(keyGenerator, zone, assetType, 12);
    Asset asset = new Asset(keyGenerator, zone, assetType, terminal, purchaseLot);




    @Test
    public void blockClient() {
        adminService.blockClient(client);
        assertSame(true, client.isBlocked());
    }

    @Test
    public void unBlockClient() {
        adminService.unBlockClient(client);
        assertSame(false, client.isBlocked());
    }

    @Test
    public void reportTrip() {
        adminService.reportTrip(trip, terminal, 1);
        assertSame(true, client.isBlocked());
        assertSame(new Fine(zone, 1), adminService.reportTrip(trip,terminal,1));
        assertSame(terminal, trip.getAsset().getTerminal());
    }

    @Test
    public void createAsset(){
        adminService.createAsset(zone, assetType, terminal, purchaseLot);
        assertSame(new AssetType("Test", 200, 200), adminService.createAsset(zone, assetType, terminal, purchaseLot));
        assertSame(terminal, asset.getTerminal());
    }

    @Test
    public void createDiscount(){
        adminService.createDiscount(assetType, 100, zone, 100);
        assertSame(new Discount(assetType, 100, zone, 100), adminService.createDiscount(assetType, 100, zone, 100));
    }

    @Test
    public void createTerminal() {
        adminService.createTerminal(zone, "Test");
        assertSame(new Terminal(zone, "Test"), adminService.createTerminal(zone, "Test"));
        //COMPROBAR QUE SE AGREGA A LA LISTA
    }

    @Test
    public void createPurchaseLot() {
        adminService.createPurchaseLot(zone, assetType,terminal, 1);
        assertSame(new PurchaseLot(keyGenerator, zone, assetType, 12), adminService.createPurchaseLot(zone, assetType, terminal, 1));
        }
    }


}