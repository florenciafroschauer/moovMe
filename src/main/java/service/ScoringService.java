package service;

import model.Client;
import model.Discount;
import model.Scoring;
import model.Zone;
import util.AssetType;
import util.Voucher;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Generar vouchers.
 * Mostrar la tabla de lideres.
 * Premiar a los tres primeros con 50% de descuento para proximo viaje.
 */

public class ScoringService {
    private Scoring scoring;
    private List<Client> clients; // persistir

    // En algun lado se tienen que separar listas de clientes por zona, los tableros son por zona.

    public List<String> showLeaders() {

        scoring.sortLeaderBoard(clients);
        List<String> nicknames = new ArrayList<>(10);

        int i = 1;

        for (Client client: clients) {
            if (nicknames.size() <= 10) {
                nicknames.add(i + ". " + client.getNickname());
                i++;
            }
        }

        return nicknames;
    }

    public Voucher createVoucher(String description) {
        return new Voucher((description));
    }

    public void rewardBestThree(Date date) {
        Voucher voucher = createVoucher("Best in the area: 50% discount");

        if (date.getDay() >= 28) {
            scoring.getLeaderBoard().get(0).addVoucher(voucher);
            scoring.getLeaderBoard().get(1).addVoucher(voucher);
            scoring.getLeaderBoard().get(2).addVoucher(voucher);
        }
    }
}
