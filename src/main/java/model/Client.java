package model;
import java.util.List;


public class Client extends User {
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
}
