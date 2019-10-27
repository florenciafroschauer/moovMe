package service;

import model.Client;
import model.Discount;
import model.Trip;

/**
 * Mostrar los descuentos existentes, chequeando que se puedan usar en un trip especifico.
 */

public class DiscountService {
    private Discount discount;

    public boolean canUse(Discount discount, Trip trip) {
        return trip.getClient().getScore() >= discount.getMinScore() &&
                trip.getAsset().getType().equals(discount.getAssetType()) &&
                trip.getZone().getType().equals(discount.getZone().getType());
    }
}
