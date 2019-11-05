package service;

import model.Asset;
import model.PurchaseLot;
import model.Terminal;
import model.Zone;
import util.AssetType;
import util.KeyGenerator;

import java.util.List;

/**
 * Deben guardar los activos comprados, que serian los generados por el lote.
 */

public class PurchaseLotService {
    private List<Asset> purchasedAssets; // persistir

    public void createLot(Asset asset, int lot) {
        for (int i = 0; i <= lot; i++) {
            purchasedAssets.add(asset);
        }
    }
}
