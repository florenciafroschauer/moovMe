package model;

public interface TripI {
    Client getClient();
    Asset getAsset();
    Zone getZone();
    Integer getTripTime();
    Discount getDiscount();
    Terminal getTerminal();
}
