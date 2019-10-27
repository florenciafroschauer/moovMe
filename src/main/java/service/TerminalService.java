package service;
import model.Asset;
import model.Discount;
import model.Trip;
import model.Zone;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Recibir activos. cuando recibe se fija si es de la misma zona
 * Premiar al cliente si entrega en la hora adecuada.
 */

public class TerminalService {
    private List<Asset> assets;

    public Asset deliverAsset(String assetType) {
        for (Asset asset: assets) {
            if (asset.getType().equals(assetType)) {
                return asset;
            }
        } return null;
    }

    public void receive(Asset anAsset) {
        for (Asset asset: assets) {
            if (asset.getZone().equals(anAsset.getZone())) {
                assets.add(anAsset);
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

    public Discount reward(Trip trip) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        if (date.compareTo(trip.getTripTime()) <= 0) {
            return new Discount(trip.getAsset().getType(),
                    trip.getAsset().getMinScore(),
                    trip.getZone(), 20);
        } return null;
    }
}
