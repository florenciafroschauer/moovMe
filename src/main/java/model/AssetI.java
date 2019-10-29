package model;

import util.AssetType;
import util.KeyGenerator;

public interface AssetI {
    KeyGenerator getKey();
    Integer getMinScore();
    Zone getZone();
    AssetType getType();
    Discount getDiscount();
    PurchaseLot getLot();
    Tariff getTariff();
    void setPurchaseLot(PurchaseLot lot);
}
