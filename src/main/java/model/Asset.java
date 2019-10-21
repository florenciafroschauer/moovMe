package model;

import util.KeyGenerator;

public class Asset implements AssetI {

    private final KeyGenerator key;
    private Tariff tariff;
    private Integer score;
    private final Zone zone;
    private final String assetType;
    private Discount discount;
    private PurchaseLot purchaseLot;

    public Asset(KeyGenerator key, Zone zone, String assetType) {
        this.key = key;
        this.zone = zone;
        this.assetType = assetType;
    }

    @Override
    public KeyGenerator getKey() {
        return key;
    }

    // pedir el descuento que se quiere usar al cliente y restarle el porcentaje a la tariff
    @Override
    public Tariff getTariff() {

        return tariff;
    }

    @Override
    public void setScore(Integer score) {
        this.score = score;
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

    public void givePoints(Trip trip) {
        Integer score = trip.getTripTime();
        trip.getClient().sumScore(score);
    }
}
