package model;

import util.KeyGenerator;

public interface AssetI {
    KeyGenerator getKey();
    Tariff getTariff();
    void setScore(Integer score);
    Zone getZone();
    String getType();
    Discount getDiscount();
    PurchaseLot getLot();
    void givePoints(Trip trip);
}
