package service;

import model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import util.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DiscountServiceTest {
    public Client client = new Client("Test", "Test", 111111, "Test");
    public Trip trip = new Trip(client);
    public ArrayList<Discount> discounts = new ArrayList<>();
    public Zone zone = new Zone("CABA", 1);
    public Terminal terminal = new Terminal(zone, "TerminalPepito");
    public AssetType assetType = new AssetType("Bici", 1, 2);
    public Discount discount = new Discount(assetType, 20, zone, 1);
    public ToPlan toPlan = new ToPlan(trip);
    public Zone zone2 = new Zone("Error", 1);
    public PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, 12);
    public Asset asset = new Asset(zone, assetType, terminal, purchaseLot);
    public DiscountService discountService = new DiscountService();


    @Test
    public void showDiscounts() {
        assertEquals(discounts, discountService.showDiscounts(trip));
    }

    @Test
    public void canUse() {
        client.addZone(zone);
        client.sumScore(300);
        trip.setZone(zone);
        trip.setDiscount(discount);
        trip.setAsset(asset);
        trip.setTripState(toPlan);
        assertTrue(discountService.canUse(client,asset,zone,discount));
    }
}