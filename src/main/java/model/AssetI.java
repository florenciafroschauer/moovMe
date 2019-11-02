package model;

import util.AssetType;
import util.KeyGenerator;

public interface AssetI {
    KeyGenerator getKey();
    AssetType getType();
    PurchaseLot getLot();
    Zone getZone();
    Terminal getTerminal();
    Integer getMinScore();
    void setTerminalToHandOver(Terminal terminal);
}
