package service;

import model.*;
import repository.*;
import util.AssetType;
import util.Fine;
import util.InProgress;

/**
 * Bloquear clientes.
 * Desbloquear clientes.
 * Reportar viajes.
 * Crear descuentos.
 * Crear lotes de compra (activos).
 * Crear terminales.
 */

public class AdminService {

    private ClientRepository clientRepository = new ClientRepository();
    private BlockedClientRepository blockedClientRepository = new BlockedClientRepository();
    private PurchaseLotRepository purchaseLotRepository = new PurchaseLotRepository();
    private DiscountRepository discountRepository = new DiscountRepository();
    private TerminalRepository terminalRepository = new TerminalRepository();
    private PurchaseLotService lotService = new PurchaseLotService();
    private TerminalService terminalService = new TerminalService();

    public void blockClient(Client aClient) {

        clientRepository.delete(aClient.getKey());
        blockedClientRepository.create(aClient);
        aClient.blockClient();
    }

    public void unBlockClient(Client aClient) {

        clientRepository.create(aClient);
        blockedClientRepository.delete(aClient.getKey());
        aClient.unBlockClient();
    }

    public Fine reportTrip(Trip trip, Terminal toHandOver, int baseFine) {

        if (trip.getTripState().equals(new InProgress(trip))) {
            Fine fine = new Fine(trip.getZone(), baseFine);

            blockClient(trip.getClient());
            trip.setTerminalToHandOver(toHandOver);

            return fine;
        }

        return null;
    }

    public PurchaseLot createPurchaseLot(Zone zone, AssetType assetType, Terminal terminal, int lot) {

        if (!terminal.showZone().equals(zone)) {
            return null;
        }

        PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, lot);
        purchaseLotRepository.create(purchaseLot);

        Asset asset = createAsset(zone, assetType, terminal, purchaseLot);

        lotService.createLot(asset, lot);

        return purchaseLot;
    }

    public Asset createAsset(Zone zone, AssetType assetType, Terminal terminal, PurchaseLot purchaseLot) {

        Asset asset = new Asset(zone, assetType, terminal, purchaseLot);
        terminalService.receive(asset);

        return asset;
    }

    public Discount createDiscount(AssetType assetType, Integer minScore, Zone zone, int percent) {

        Discount discount = new Discount(assetType, minScore, zone, percent);
        discountRepository.create(discount);

        return discount;
    }

    public Terminal createTerminal(Zone zone, String name) {

        Terminal terminal = new Terminal(zone, name);
        terminalRepository.create(terminal);

        return terminal;
    }
}
