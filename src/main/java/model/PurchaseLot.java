package model;

import util.KeyGenerator;

import java.util.List;

public class PurchaseLot {
    private List<AssetI> assets;
    private final String assetType;
    private final KeyGenerator key;

    public PurchaseLot(String assetType, KeyGenerator key) {
        this.assetType = assetType;
        this.key = key;
    }

    public KeyGenerator getKey() {
        return key;
    }

    public String getAssetType() {
        return assetType;
    }
}
