package service;

import model.Client;
import model.Scoring;
import repository.ClientRepository;
import util.Date;
import util.Voucher;
import java.util.ArrayList;
import java.util.List;

/**
 * Generar vouchers.
 * Mostrar la tabla de lideres.
 * Premiar a los tres primeros con 50% de descuento para proximo viaje.
 */

public class ScoringService {

    private ClientRepository clientRepository = new ClientRepository();

    private List<Client> clients = clientRepository.findAll();
    private Scoring scoring;

    public ScoringService(Scoring scoring) {
        this.scoring = scoring;
    }

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
        return new Voucher(description);
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
