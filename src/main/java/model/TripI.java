package model;

public interface TripI {
    void setDiscount(Discount discount);
    void setToHandOver(Terminal toHandOver);
    void setTripTime(Integer tripTime);
    Client getClient();
    Asset getAsset();
    Zone getZone();
    Integer getTripTime();
    Discount getDiscount();
    Terminal getTerminal();
    Tariff getTariff();
}
