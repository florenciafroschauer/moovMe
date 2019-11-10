package service;

import model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import util.AssetType;

import static org.junit.Assert.*;


public class TerminalServiceTest {

    Zone zone = new Zone("Test", 1);
    TerminalService terminalService = new TerminalService();
    Terminal terminal = new Terminal(zone, "Test");
    Client client = new Client("Test", "Test", 111, "Test");
    Trip trip = new Trip(client);
    AssetType assetType = new AssetType("test", 1, 1);
    PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, 1);

    Asset asset = new Asset(zone, assetType, terminal, purchaseLot);

    @Test
    public void showAssets() {
        assertEquals(terminal.getAssets(), terminalService.showAssets(zone));
    }

    @Test
    public void receive() {
        terminalService.receive(asset);
        assertTrue(terminal.getAssets().contains(asset));
    }

    @Test
    public void reward() {
        Integer clientInt = client.getAccumulatedScore();
        terminalService.showAssets(zone);
        assertEquals(clientInt, client.getAccumulatedScore());
    }
}
