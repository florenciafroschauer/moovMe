package model;

import util.AssetType;
import util.KeyGenerator;

import java.util.List;

/**
 * cantidad de activos
 * cuando compro activos se crea un lote
 */

public class PurchaseLot {
    private List<AssetI> assets;
    private final KeyGenerator key;
    private final Zone zone;
    private final AssetType assetType;

    public PurchaseLot(KeyGenerator key, Zone zone, AssetType assetType) {
        this.key = key;
        this.zone = zone;
        this.assetType = assetType;
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
}
