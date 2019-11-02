package model;

import util.AssetType;
import util.KeyGenerator;
import util.Tariff;

public class Asset implements AssetI {

    private final KeyGenerator key;
    private final AssetType assetType;
    private PurchaseLot purchaseLot;
    private final Zone zone;
    private Terminal terminal;
    private Tariff tariff;
    private Integer minScore;

    public Asset(KeyGenerator key, Zone zone, AssetType assetType, Terminal terminal, PurchaseLot purchaseLot) {
        this.key = key;
        this.zone = zone;
        this.assetType = assetType;
        this.terminal = terminal;
        this.purchaseLot = purchaseLot;
    }


    @Override
    public KeyGenerator getKey() {
        return key;
    }

    @Override
    public AssetType getType() {
        return assetType;
    }

    @Override
    public PurchaseLot getLot() {
        return purchaseLot;
    }

    @Override
    public Zone getZone() {
        return zone;
    }

    @Override
    public Terminal getTerminal() {
        return terminal;
    }

    @Override
    public Integer getMinScore() {
        return minScore;
    }

    @Override
    public void setTerminalToHandOver(Terminal terminal) {
        this.terminal = terminal;
    }
}
