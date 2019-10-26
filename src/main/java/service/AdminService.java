package service;

import model.*;
import util.KeyGenerator;
import java.util.List;

/**
 * Crear descuentos.
 * Crear activos.
 */

public class AdminService {

    private List<Client> blockedClients;
    private List<Client> clients;
    private List<Terminal> terminals;
    private List<PurchaseLot> purchaseLots;


    public void blockClient(Client client){
        for(int i = 0; i<clients.size(); i++){
            if(clients.get(i).equals(client)){
                clients.remove(i);
                clients.remove(null);
                blockedClients.add(blockedClients.size() + 1, client);
            }
        }
    }

    public void unBlockClient(Client client){
        for(int i = 0; i<blockedClients.size(); i++){
            if(blockedClients.get(i).equals(client)){
                blockedClients.remove(i);
                blockedClients.remove(null);
                clients.add(clients.size() + 1, client);
            }
        }
    }

    public Integer reportTrip(Trip trip){//multo, bloqueo, restituyo a donde?
        trip.getAsset().getTariff().getTripValue();
    }

    public Terminal createTerminal(Zone zone, String name){
        Terminal terminal = new Terminal(zone, name);
        return terminal;
    }

    public PurchaseLot createPurchaseLot(KeyGenerator keyGenerator, Zone zone){
        PurchaseLot purchaseLot = new PurchaseLot(keyGenerator, zone);
        return purchaseLot;
    }
}
