package model;

import java.util.List;

public interface AdminI {
    Terminal getTerminal(Zone zone);
    List<Terminal>showTerminal();
    PurchaseLot getPurchaseLot(PurchaseLot lookPurchaseLot);
    List<PurchaseLot>showPL();
}
