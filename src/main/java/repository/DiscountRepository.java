package repository;

import model.Discount;
import model.Zone;
import util.AssetType;
import java.util.ArrayList;
import java.util.List;

public class DiscountRepository extends AbstractRepository<Discount> {

    private static DiscountRepository discountRepository;

    private DiscountRepository() {}

    public List<Discount> searchByAssetType(AssetType assetType) {
        List<Discount> discounts = findAll();
        List<Discount> assetTypeDiscounts = new ArrayList<>();

        for (Discount discount: discounts) {
            if (discount.getAssetType().equals(assetType)) {
                assetTypeDiscounts.add(discount);
            }
        }

        return assetTypeDiscounts;
    }

    public List<Discount> searchByZone(Zone zone) {
        List<Discount> discounts = findAll();
        List<Discount> discountsInZone = new ArrayList<>();

        for (Discount discount: discounts) {
            if (discount.getZone().equals(zone)) {
                discountsInZone.add(discount);
            }
        }

        return discountsInZone;
    }

    public static DiscountRepository getInstance() {
        if (discountRepository != null) {
            return discountRepository;
        } else {
            discountRepository = new DiscountRepository();
        }

        return discountRepository;
    }
}
