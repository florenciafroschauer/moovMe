package service;

import model.Client;
import model.Discount;

public class DiscountService {
    private Discount discount;

    public boolean canUse(Discount discount, Client client) {
        return client.getScore() >= discount.getMinScore();
    }
}
