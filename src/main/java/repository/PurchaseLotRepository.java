package repository;

import model.PurchaseLot;
import model.Zone;
import util.AssetType;
import java.util.ArrayList;
import java.util.List;

public class PurchaseLotRepository extends AbstractRepository<PurchaseLot> {

    private static PurchaseLotRepository purchaseLotRepository;

    private PurchaseLotRepository() {
    }

    public List<PurchaseLot> searchByAssetType(AssetType assetType) {
        List<PurchaseLot> purchaseLots = findAll();
        List<PurchaseLot> assetTypeLots = new ArrayList<>();

        for (PurchaseLot lot: purchaseLots) {
            if (lot.getAssetType().equals(assetType)) {
                assetTypeLots.add(lot);
            }
        }

        return assetTypeLots;
    }

    public List<PurchaseLot> searchByZone(Zone zone) {
        List<PurchaseLot> purchaseLots = findAll();
        List<PurchaseLot> lotsInZone = new ArrayList<>();

        for (PurchaseLot lot: purchaseLots) {
            if (lot.getZone().equals(zone)) {
                lotsInZone.add(lot);
            }
        }

        return lotsInZone;
    }

    public static PurchaseLotRepository getInstance() {
        if (purchaseLotRepository != null) {
            return purchaseLotRepository;
        } else {
            purchaseLotRepository = new PurchaseLotRepository();
        }

        return purchaseLotRepository;
    }
}
