package service;

import com.sun.tools.javac.util.List;
import model.Client;
import model.Scoring;
import model.Zone;
import org.junit.Test;
import org.junit.runner.RunWith;
import util.Voucher;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class ScoringServiceTest {

    ScoringService scoringService = new ScoringService();
    List<String>nickNamesTest;
    Zone zone = new Zone("Test", 1);

    List<Client>clients = new List<>()://SOLUCIONAR

    Scoring scoring = new Scoring(clients, zone);
    Voucher voucher = new Voucher("Test");

    @Test
    public void showLeaders() {
        assertEquals(nickNamesTest, scoringService.showLeaders());
    }

    @Test
    public void createVoucher() {
        assertEquals(new Voucher("Test"), scoringService.createVoucher("Test"));
    }

    @Test
    public void rewardBestThree() {
        scoringService.rewardBestThree();//ACA VA UN DATE
        assertEquals(true, scoring.getLeaderBoard().get(0).getVouchers().contains(voucher));
        assertEquals(true, scoring.getLeaderBoard().get(1).getVouchers().contains(voucher));
        assertEquals(true, scoring.getLeaderBoard().get(2).getVouchers().contains(voucher));
    }
}
