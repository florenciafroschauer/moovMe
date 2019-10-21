package model;
import java.util.ArrayList;
import java.util.List;



public class Client extends User implements ClientI{
    private String phoneNumber;
    private String nickname;
    private Boolean state;
    private List<Zone> zones;
    private Integer score;
    private List<Discount> discounts;


    public Client(String username, String password, String phoneNumber, String nickname) {
        super(username, password);
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
    }

    public Integer getScore(){
        return score;
    }

    @Override
    public List<Discount> showDiscounts() {
        return discounts;
    }

    public void addDiscounts(Discount discountToAdd){
        discounts.add(discounts.size() + 1, discountToAdd);
    }


}
