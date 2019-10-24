package model;

public class Tariff {
    private Integer tripValue = 0;
    private AssetI asset;

    public Integer getTripValue() {
        return tripValue;
    }

    public void setTripValue(Integer tripValue) {
        this.tripValue += tripValue;
    }
}
