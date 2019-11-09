package service

import model.Asset
import model.PurchaseLot

class PurchaseLotServiceTest {
    Asset asset = new Asset();
    PurchaseLotService purchaseLotService = new PurchaseLotService();

    void testCreateLot() {
        purchaseLotService.createLot(asset, 1);

    }
}
