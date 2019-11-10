package service;

import model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import util.AssetType;
import util.KeyGenerator;

import static org.junit.Assert.*;

public class DiscountServiceTest {
    Client client = new Client("Test", "Test", 111111, "Test");
    Trip trip = new Trip(client);
    AssetType asettipe = new AssetType("test", 1, 20);
    Zone zone = new Zone("Test", 1);
    Discount descuento = new Discount(asettipe, 5, zone, 5);
    KeyGenerator keyGenerator = new KeyGenerator();
    Zone zone1 = new Zone("Test", 1);
    AssetType assetType = new AssetType("test", 1, 20);
    Terminal terminal = new Terminal(zone1, "Test");
    PurchaseLot purchaseLot = new PurchaseLot( zone1, assetType, 5);
    KeyGenerator keyGenerator1 = new KeyGenerator();
    Asset asset = new Asset(zone1, assetType, terminal, purchaseLot);
    DiscountService discountService = new DiscountService(descuento);
    @Test
    public void showDiscounts() {
        discountService.showDiscounts(trip);

    }

    public void canUse() {
        client.sumScore(10);
        trip.setAsset(asset);
        discountService.canUse(trip);
    }
}