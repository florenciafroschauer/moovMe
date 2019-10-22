package model;

import util.KeyGenerator;

public interface AssetI {
    KeyGenerator getKey();
    Integer getMinScore();
    Zone getZone();
    String getType();
    Discount getDiscount();
    PurchaseLot getLot();
}
