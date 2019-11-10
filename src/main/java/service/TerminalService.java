package service;

import model.*;
import repository.AssetRepository;
import repository.TerminalRepository;
import util.AssetType;
import util.Finished;
import java.util.Date;
import java.util.List;

/**
 * Recibir activos. cuando recibe se fija si es de la misma zona
 * Premiar al cliente si entrega en la hora adecuada.
 */

public class TerminalService {

    private AssetRepository assetRepository = new AssetRepository();
    private TerminalRepository terminalRepository = new TerminalRepository();

    private List<Terminal> terminals = terminalRepository.findAll();

    public List<Asset> showAssets(Zone zone) {
        Terminal terminal = terminalRepository.searchByZone(zone);

        return terminal.getAssets();
    }

    public void receive(Asset anAsset) {

        for (Terminal terminal: terminals) {
            if (terminal.showZone().equals(anAsset.getZone())) {
                terminal.receive(anAsset);
            }
        }
    }

    public void reward(Trip trip) {
        if (trip.getTripState().equals(new Finished(trip))) {
            Date date = new Date();

            if (date.compareTo(trip.getTripTime()) <= 0) {
                Integer score = (int)(trip.getScore() * 0.2);
                trip.setScore(score);
            }
        }
    }
}
