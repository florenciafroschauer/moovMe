package service;

import model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import repository.AssetRepository;
import util.AssetType;

import static org.junit.Assert.*;

public class PurchaseLotServiceTest {
    PurchaseLotService purchaseLotService = new PurchaseLotService();
    public Client client = new Client("Hola", "Hola", 123, "Hola");
    Zone zone = new Zone("Hola", 1);
    Terminal terminal = new Terminal(zone, "Hola");
    AssetType assetType = new AssetType("Hola", 1, 1);
    PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, 1);
    Asset asset = new Asset(zone, assetType, terminal, purchaseLot);
    AssetRepository assetRepository = new AssetRepository();

    @Test
    public void createLot() {
        purchaseLotService.createLot(asset, 1);
        assertTrue(purchaseLotService.getAssetRepository().findAll().contains(asset));
    }
}
