package model;
import java.util.List;


public class Admin extends User{
    private List<ClientI> clients;
    private List<PurchaseLot> purchaseLot;
    private List<Terminal> terminals;

    public Admin(String username, String password) {
        super(username, password);
    }


    public Terminal getTerminal(Zone zone){
        for(int i = 0; i<terminals.size(); i++){
            if(terminals.get(i).showZone().equals(zone.getType()){
                return terminals.get(i);
            }
        }
    }

    public List<Terminal> showTerminal(){
        return terminals;
    }

    public PurchaseLot getPurchaseLot(PurchaseLot lookPurchaseLot){
        for(int i = 0; i<purchaseLot.size(); i++){
            if(purchaseLot.get(i).getKey().equals(lookPurchaseLot.getKey())){
                return purchaseLot.get(i)
            }
        }
    }

    public List<PurchaseLot> showPL(){
        return purchaseLot;
    }


}
