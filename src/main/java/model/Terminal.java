package model;

import java.util.List;

public class Terminal {
    private List<AssetI>assets;
    private Discount discounts;
    private Zone zone;

    public Terminal(){

    }
    public String showzone(){return zone; }
    public void receive(AssetI asset){}
    public AssetI grant(){return discounts; }

}
