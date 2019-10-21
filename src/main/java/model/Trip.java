package model;

public class Trip implements TripI {
    private final ClientI client;
    private AssetI asset;
    private Zone zone;
    private Integer tripTime;
    private Discount discount;
    private Terminal toHandOver;
    private Tariff tariff;
    private Integer score;

    public Trip(ClientI client, Asset asset, Zone zone) {
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
    public Integer calculateScore() {
        return null;
    }

    @Override
    public Client getClient() {
        return null;
    }

    @Override
    public Asset getAsset() {
        return null;
    }

    @Override
    public Zone getZone() {
        return null;
    }

    @Override
    public Integer getTripTime() {
        return null;
    }

    @Override
    public Discount getDiscount() {
        return null;
    }

    @Override
    public Terminal getTerminal() {
        return null;
    }

    @Override
    public Tariff getTariff() {
        return null;
    }
}
