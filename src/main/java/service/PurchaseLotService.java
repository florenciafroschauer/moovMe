package service;

import model.Asset;
import model.Terminal;
import model.Zone;
import util.KeyGenerator;

/**
 * Los lotes tienen que generar activos y devolverlos.
 * Guardar los service en una terminal.
 * Tambien deben guardar los activos comprados, que serian los generados por el lote.
 */

public class PurchaseLotService {
    public Asset createAsset(KeyGenerator key, Zone zone, String assetType, Terminal terminal) {
        Asset asset = new Asset(key, zone, assetType);
        terminal.receive(asset);
        return asset;
    }
}
