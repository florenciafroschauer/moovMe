package model;

import util.KeyGenerator;

public interface AssetI {
    KeyGenerator getKey();
    Tariff getTariff();
    void setScore(Integer score);
    Integer getScore();
    Zone getZone();
    String getType();
    Discount getDiscount();
    PurchaseLot getLot();
    Terminal getTerminal();
}
