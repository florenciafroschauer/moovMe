package model;

import java.util.List;

public class Terminal {
    private List<AssetI> assets;
    private Discount discounts;
    private Zone zone;

    public Terminal(){

    }
    public Zone showZone() {
        return zone;
    }

    public void receive(AssetI asset) {
        assets.add(asset);
    }

    public AssetI grant() {

        return asset;
    }

}
