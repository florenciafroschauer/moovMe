package model;

public interface AssetI {
    KeyGenerator getKey();
    Tariff getTariff();
    Integer getInteger();
    Zone getZone();
    String getType();
    Discount getDiscount();
    PurchaseLot getLot();
    Terminal getTerminal();
}
