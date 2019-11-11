package repository;

import model.Asset;
import model.PurchaseLot;
import model.Terminal;
import model.Zone;
import util.AssetType;
import java.util.ArrayList;
import java.util.List;

public class AssetRepository extends AbstractRepository<Asset> {

    private static AssetRepository assetRepository;

    private AssetRepository() {
        final Zone zone = new Zone("CABA", 10);
        final AssetType assetType = new AssetType("Bici", 10, 15);
        create(new Asset(zone, assetType , new Terminal(zone, "Terminal en CABA"),
                new PurchaseLot(zone, assetType, 15 )));
    }

    public Asset searchByAssetType(AssetType assetType) {
        List<Asset> assets = findAll();

        for (Asset asset: assets) {
            if (asset.getType().equals(assetType)) return asset;
        }

        return null;
    }

    public List<Asset> searchByZone(Zone zone) {
        List<Asset> assets = findAll();
        List<Asset> assetsInZone = new ArrayList<>();

        for (Asset asset: assets) {
            if (asset.getZone().equals(zone)) {
                assetsInZone.add(asset);
            }
        }

        return assetsInZone;
    }

    public static AssetRepository getInstance() {

        if (assetRepository != null) {
            return assetRepository;
        } else {
            assetRepository = new AssetRepository();
        }

        return assetRepository;
    }
}
