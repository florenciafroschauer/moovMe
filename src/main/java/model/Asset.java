package model;

public class Asset {
    private final KeyGenerator key;
    private Tariff tariff;
    private Integer score;
    private final Zone zone;
    private final String assetType;
    private Discount discount;
    private final PurchaseLot purchaseLot;
    private Terminal terminals;


    public Asset(KeyGenerator key, Zone zone, String assetType, PurchaseLot purchaseLot) {
        this.key = key;
        this.zone = zone;
        this.assetType = assetType;
        this.purchaseLot = purchaseLot;
    }
}
