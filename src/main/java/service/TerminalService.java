package service;

import model.*;
import repository.TerminalRepository;
import util.Finished;
import util.Hour;
import java.util.List;

/**
 * Recibir activos. cuando recibe se fija si es de la misma zona
 * Premiar al cliente si entrega en la hora adecuada.
 */

public class TerminalService {

    private TerminalRepository terminalRepository = new TerminalRepository();

    private List<Terminal> terminals = terminalRepository.findAll();

    public List<Asset> showAssets(Zone zone) {
        Terminal terminal = terminalRepository.searchOneByZone(zone);

        return terminal.getAssets();
    }

    public void receive(Asset anAsset) {

        for (Terminal terminal: terminals) {
            if (terminal.showZone().equals(anAsset.getZone())) {
                terminal.receive(anAsset);
            }
        }
    }

    public void reward(Trip trip, Hour hour) {
        if (trip.getTripState().equals(new Finished(trip))) {

            if (hour.compareTo(trip.getTripTime()) <= 0) {
                Integer score = (int)(trip.getScore() * 0.2);
                trip.setScore(score);
                trip.getClient().sumScore(score);
            }
        }
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }
}
