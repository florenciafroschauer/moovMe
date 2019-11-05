package service;

import model.*;
import util.AssetType;
import util.Fine;
import util.KeyGenerator;
import java.util.List;

/**
 * Bloquear clientes.
 * Desbloquear clientes.
 * Reportar viajes.
 * Crear descuentos.
 * Crear lotes de compra (activos).
 * Crear terminales.
 */

public class AdminService {

    private List<Client> blockedClients; // persistir
    private List<Client> clients; // persistir
    private List<Terminal> terminals; // persistir
    private List<PurchaseLot> purchaseLots; // persistir
    private List<Discount> discounts; // persistir
    private PurchaseLotService lotService;
    private TerminalService terminalService;


    public void blockClient(Client client) {
        for (Client client1: clients) {
            if (client1.equals(client)) {
                clients.remove(client);
                blockedClients.add(client);
                client.blockClient();
            }
        }
    }

    public void unBlockClient(Client client) {
        for (Client client1: blockedClients) {
            if (client1.equals(client)) {
                blockedClients.remove(client);
                clients.add(client);
                client.unBlockClient();
            }
        }
    }

    public Fine reportTrip(Trip trip, Terminal toHandOver, int baseFine) {
        Fine fine = new Fine(trip.getZone(), baseFine);

        blockClient(trip.getClient());
        trip.setTerminalToHandOver(toHandOver);

         return fine;
    }

    public PurchaseLot createPurchaseLot(Zone zone, AssetType assetType, Terminal terminal, int lot) {
        if (!terminal.showZone().equals(zone)) {
            throw new RuntimeException("Terminal not compatible with the zone.");
        }
            PurchaseLot purchaseLot = new PurchaseLot(new KeyGenerator(), zone, assetType, lot);
            purchaseLots.add(purchaseLot);

            Asset asset = createAsset(zone, assetType, terminal, purchaseLot);

            lotService.createLot(asset, lot);

            return purchaseLot;

    }

    private Asset createAsset(Zone zone, AssetType assetType, Terminal terminal, PurchaseLot purchaseLot) {

        Asset asset = new Asset(new KeyGenerator(), zone, assetType, terminal, purchaseLot);
        terminalService.receive(asset);

        return asset;
    }

    public Discount createDiscount(AssetType assetType, Integer minScore, Zone zone, int percent) {

        Discount discount = new Discount(assetType, minScore, zone, percent);
        discounts.add(discount);

        return discount;
    }

    public Terminal createTerminal(Zone zone, String name) {
        return new Terminal(zone, name);
    }
}
