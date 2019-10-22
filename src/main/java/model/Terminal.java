package model;

import java.util.ArrayList;

public class Terminal {
    private ArrayList<Asset> assets;
    private Discount discounts;
    private final Zone zone;
    private final String name;

    public Terminal(Zone zone, String name) {
        this.zone = zone;
        this.name = name;
    }

    public Zone showZone() {
        return zone;
    }

    public String getName() {
        return name;
    }

    public void receive(Asset asset) {
        assets.add(asset);
    }

    /**
    // si entrega a horario sumar 20% de puntos.
    public Asset grant(String assetType) {
        for (Asset asset: assets) {
            if (asset.getType().equals(assetType)) return asset;

        } return null;
    }
     */
}
