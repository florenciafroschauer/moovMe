package model;

import java.util.Date;

public interface TripI {
    void setDiscount(Discount discount);
    void setToHandOver(Terminal toHandOver);
    void setTripTime(Date tripTime);
    Client getClient();
    Asset getAsset();
    Zone getZone();
    Date getTripTime();
    Discount getDiscount();
    Terminal getTerminal();
    Tariff getTariff();
}
