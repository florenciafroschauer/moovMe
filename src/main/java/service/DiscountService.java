package service;

import model.*;
import repository.DiscountRepository;
import util.ToPlan;
import java.util.ArrayList;
import java.util.List;

/**
 * Mostrar los descuentos existentes, chequeando que se puedan usar en un trip especifico.
 */

public class DiscountService {

    private DiscountRepository discountRepository = new DiscountRepository();
    private List<Discount> discounts = discountRepository.findAll();

    public List<Discount> showDiscounts(Trip trip) {
        List<Discount> discountsCanUse = new ArrayList<>();

        for (Discount discount: discounts) {
            if (canUse(trip.getClient(), trip.getAsset(), trip.getZone(), discount)) {
                discountsCanUse.add(discount);
            }
        }

        return discountsCanUse;
    }

    public boolean canUse(Client client, Asset asset, Zone zone, Discount discount) {
            return client.getScoreToUse() >= discount.getMinScore() &&
                    asset.getType().equals(discount.getAssetType()) &&
                    zone.equals(discount.getZone());
    }
}
