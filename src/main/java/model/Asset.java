package model;

import util.KeyGenerator;

public class Asset implements AssetI {
    private final KeyGenerator key;
    private Tariff tariff;
    private Integer score;
    private final Zone zone;
    private final String assetType;
    private Discount discount;
    private final PurchaseLot purchaseLot;
    private Terminal terminal;


    public Asset(KeyGenerator key, Zone zone, String assetType, PurchaseLot purchaseLot) {
        this.key = key;
        this.zone = zone;
        this.assetType = assetType;
        this.purchaseLot = purchaseLot;
    }

    @Override
    public KeyGenerator getKey() {
        return key;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }

    @Override
    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public Integer getScore() {
        return score;
    }


    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public String getType() {
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
    public Terminal getTerminal() {
        return terminal;
    }
}
