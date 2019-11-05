package service;
import model.*;
import util.AssetType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Recibir activos. cuando recibe se fija si es de la misma zona
 * Premiar al cliente si entrega en la hora adecuada.
 */

public class TerminalService {
    private List<Asset> assets; // persistir
    private List<Terminal> terminals; // persistir

    public Asset deliverAsset(AssetType assetType) {
        for (Asset asset: assets) {
            if (asset.getType().equals(assetType)) {
                return asset;
            }
        } return null;
    }

    public void receive(Asset anAsset) {

        for (Terminal terminal: terminals) {
            if (terminal.showZone().equals(anAsset.getZone())) {
                terminal.receive(anAsset);
            }
        }
    }

    public List<Asset> showAssets(Zone zone) {
        List<Asset> assetList = new ArrayList<>();

        for (Asset asset: assets) {
            if (asset.getZone().equals(zone)) {
                assetList.add(asset);
            }
        }

        return assetList;
    }

    public Integer reward(Trip trip) {
        Date date = new Date();

        if (date.compareTo(trip.getTripTime()) <= 0) {
            Integer score = (int)(trip.getScore() * 0.2);
            trip.setScore(score);
        }

        return null;
    }
}
