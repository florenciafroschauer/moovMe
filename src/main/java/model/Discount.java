package model;

import util.AssetType;

public class Discount {
    private final AssetType assetType;
    private final Integer minScore;
    private final Zone zone;
    private final int percent;

    public Discount(AssetType assetType, Integer minScore, Zone zone, int percent) {
        this.assetType = assetType;
        this.minScore = minScore;
        this.zone = zone;
        this.percent = percent;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public Zone getZone() {
        return zone;
    }

    public int getPercent() {
        return percent;
    }
}
