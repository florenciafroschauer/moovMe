package repository;

import model.Discount;
import model.Zone;
import util.AssetType;
import java.util.ArrayList;
import java.util.List;

public class DiscountRepository extends AbstractRepository<Discount> {

    private static DiscountRepository discountRepository;

    private DiscountRepository() {
        create(new Discount(new AssetType("Bici",
                10, 15), 40,
                new Zone("CABA", 10),
                20));

        create(new Discount(new AssetType("Moto",
                5, 30), 50,
                new Zone("Pilar", 15),
                25));

        create(new Discount(new AssetType("Scooter",
                5, 20), 30,
                new Zone("Vicente Lopez", 10),
                10));

        create(new Discount(new AssetType("Bici Moto",
                20, 15), 30,
                new Zone("Munro", 18),
                5));

        create(new Discount(new AssetType("MonoPatin",
                13, 15), 80,
                new Zone("Villa Crespo", 5),
                35));

        create(new Discount(new AssetType("Clio",
                15, 15), 60,
                new Zone("Pacheco", 10),
                20));

        create(new Discount(new AssetType("BatiMovil",
                20, 15), 80,
                new Zone("La lucila", 10),
                30));
    }

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
