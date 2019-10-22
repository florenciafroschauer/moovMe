package model;

public class Trip implements TripI {
    private final Client client;
    private Asset asset;
    private Zone zone;
    private Integer tripTime;
    private Discount discount;
    private Terminal toHandOver;
    private Tariff tariff;
    private Integer score;

    public Trip(Client client, Asset asset, Zone zone) {
        this.client = client;
        this.asset = asset;
        this.zone = zone;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setToHandOver(Terminal toHandOver) {
        this.toHandOver = toHandOver;
    }

    public void setTripTime(Integer tripTime) {
        this.tripTime = tripTime;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public Asset getAsset() {
        return asset;
    }

    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public Integer getTripTime() {
        return tripTime;
    }

    @Override
    public Discount getDiscount() {
        return discount;
    }

    @Override
    public Terminal getTerminal() {
        return toHandOver;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }
}
