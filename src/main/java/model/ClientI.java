package model;

import java.util.List;

public interface ClientI {

    Integer getScore();

    List<Discounts>showDiscounts();

    void addDiscounts(Discounts discounts);
}
