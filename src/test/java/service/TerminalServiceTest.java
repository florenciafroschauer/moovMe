package service;

import model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import util.AssetType;
import util.Finished;
import util.Hour;

import static org.junit.Assert.*;


public class TerminalServiceTest {

    Zone zone = new Zone("Test", 1);
    TerminalService terminalService = new TerminalService();
    Terminal terminal = new Terminal(zone, "Test");
    Client client = new Client("Test", "Test", 111, "Test");
    Trip trip = new Trip(client);
    AssetType assetType = new AssetType("test", 1, 1);
    PurchaseLot purchaseLot = new PurchaseLot(zone, assetType, 1);
    Hour hour;
    Hour hour2;
    Finished finished = new Finished(trip);

    Asset asset = new Asset(zone, assetType, terminal, purchaseLot);


    @Test
    public void showAssets() {
        terminal.getAssets().add(asset);
        terminalService.getTerminals().add(terminal);
        assertEquals(terminal.getAssets(), terminalService.showAssets(zone));
    }

    @Test
    public void receive() {
        terminal.getAssets().add(asset);
        terminalService.receive(asset);
        assertTrue(terminal.getAssets().contains(asset));
    }

    @Test
    public void reward() {
        hour2 = new Hour(1,1);
        trip.setTripState(finished);
        trip.setTripTime(hour2);
        hour = new Hour(0, 0);
        Integer clientInt = trip.getClient().getScoreToUse() + trip.getScore();
        terminalService.reward(trip, hour);
        assertEquals(clientInt, trip.getClient().getScoreToUse());
    }
}
