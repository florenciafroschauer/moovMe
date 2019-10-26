package service;

import model.Client;
import model.Discount;
import model.Trip;

public class DiscountService {
    private Discount discount;

    public boolean canUse(Discount discount, Client client, Trip trip) {
        return client.getScore() >= discount.getMinScore() && trip.getAsset().getType().equals(discount.getAssetType());
    }
}
