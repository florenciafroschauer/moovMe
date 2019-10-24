package model;

import util.KeyGenerator;

import java.util.List;

public class PurchaseLot {
    private List<AssetI> assets;
    private final KeyGenerator key;
    private final Zone zone;

    public PurchaseLot(KeyGenerator key, Zone zone) {
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
