package service;

import model.Discount;
import model.Trip;
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
    private Discount discount;

    public DiscountService(Discount discount) {
        this.discount = discount;
    }

    public List<Discount> showDiscounts(Trip trip) {
        List<Discount> discountsCanUse = new ArrayList<>();

        for (Discount discount: discounts) {
            if (canUse(trip)) {
                discountsCanUse.add(discount);
            }
        }

        return discountsCanUse;
    }

    public boolean canUse(Trip trip) {
        if (trip.getTripState().equals(new ToPlan(trip))) {
            return trip.getClient().getScoreToUse() >= discount.getMinScore() &&
                    trip.getAsset().getType().equals(discount.getAssetType()) &&
                    trip.getZone().equals(discount.getZone());
        }

        return false;
    }
}
