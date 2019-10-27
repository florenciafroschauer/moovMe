package model;

import java.util.List;

public interface ClientI {
    Integer getScore();
    List<Discount> getDiscounts();
    String getNickname();
    void addDiscounts(Discount discounts);
    Integer sumScore(Integer score);
    void setNickname(String nickname);
    void setPhoneNumber(String phoneNumber);
    void addZone(Zone zone);
    void blockClient();
    void unBlockClient();

}
