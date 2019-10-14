package model;

import java.util.List;

public interface ClientI {
    Integer getScore();
    List<Discount>showDiscounts();
    void addDiscounts(Discount discounts);
}
