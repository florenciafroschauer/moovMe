package model;

import util.KeyGenerator;

import java.util.List;

public class PurchaseLot {
    private List<AssetI> assets;
    private final String assetType;
    private final KeyGenerator key;
    private final Zone zone;

    public PurchaseLot(KeyGenerator key, Zone zone) {
        this.assetType = assetType;
        this.key = key;
        this.zone = zone;
    }

    public KeyGenerator getKey() {
        return key;
    }

    public Zone getZone() {
        return zone;
    }
}
