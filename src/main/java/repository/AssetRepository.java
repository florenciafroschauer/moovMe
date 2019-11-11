package repository;

import model.Asset;
import model.Zone;
import util.AssetType;
import java.util.ArrayList;
import java.util.List;

public class AssetRepository extends AbstractRepository<Asset> {

    private static AssetRepository assetRepository;

    private AssetRepository() {}

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
