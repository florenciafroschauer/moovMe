package model;

import java.util.ArrayList;

public class Terminal {
    private ArrayList<Asset> assets;
    private Discount discounts;
    private Zone zone;

    public Terminal() {

    }
    public Zone showZone() {
        return zone;
    }

    public void receive(Asset asset) {
        assets.add(asset);
    }

    public Asset grant(String assetType) {
        for (Asset asset: assets) {
            if (asset.getType().equals(assetType)) return asset;

        } return null;
    }
}
