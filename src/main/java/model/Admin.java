package model;
import java.util.List;


public class Admin extends User{
    private List<ClientI> clients;
    private List<PurchaseLot> purchaseLot;
    private List<Terminal> terminals;

    public Admin(String username, String password) {
        super(username, password);
    }
}
