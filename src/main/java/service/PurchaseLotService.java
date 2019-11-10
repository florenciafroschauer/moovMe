package service;

import model.Asset;
import repository.AssetRepository;

/**
 * Deben guardar los activos comprados, que serian los generados por el lote.
 */

public class PurchaseLotService {
    private AssetRepository assetRepository = new AssetRepository();

    public void createLot(Asset asset, int lot) {
        for (int i = 0; i <= lot; i++) {
            assetRepository.create(asset);
        }
    }

    public AssetRepository getAssetRepository() {
        return assetRepository;
    }
}
