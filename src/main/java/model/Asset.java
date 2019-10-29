package model;

import util.AssetType;
import util.KeyGenerator;

/**
 * puntos
 * multa
 * tarifa
 */

public class Asset implements AssetI {

    private final KeyGenerator key;
    private Tariff tariff;

    private final Zone zone;
    private Discount discount;
    private Integer minScore;
    private PurchaseLot purchaseLot;
    private final AssetType assetType;

    public Asset(KeyGenerator key, Zone zone, AssetType assetType) {
        this.key = key;
        this.zone = zone;
        this.assetType = assetType;
    }

    @Override
    public KeyGenerator getKey() {
        return key;
    }

    @Override
    public Integer getMinScore() {
        return minScore;
    }

    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public AssetType getType() {
        return assetType;
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    @Override
    public PurchaseLot getLot() {
        return purchaseLot;
    }

    @Override
    public Tariff getTariff() { return tariff; }

    @Override
    public void setPurchaseLot(PurchaseLot purchaseLot) {
        this.purchaseLot = purchaseLot;
    }
}
