package service;

import model.Discount;
import model.Zone;

public class DiscountService {
    private Discount discount;

    public String showAssetType(Discount discount) {
        return discount.getAssetType();
    }

    public Integer showMinScore(Discount discount) {
        return discount.getMinScore();
    }

    public Zone showZone(Discount discount) {
        return discount.getZone();
    }

    public int showPercent(Discount discount) {
        return discount.getPercent();

    }
}
