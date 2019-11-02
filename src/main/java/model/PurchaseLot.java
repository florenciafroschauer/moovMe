package model;

import util.AssetType;
import util.KeyGenerator;

import java.util.List;

public class PurchaseLot {
    private List<Asset> assets;
    private final KeyGenerator key;
    private final Zone zone;
    private final AssetType assetType;
    private final int lot;

    public PurchaseLot(KeyGenerator key, Zone zone, AssetType assetType, int lot) {
        this.key = key;
        this.zone = zone;
        this.assetType = assetType;
        this.lot = lot;
    }

    public KeyGenerator getKey() {
        return key;
    }

    public Zone getZone() {
        return zone;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public int getLot() {
        return lot;
    }
}
