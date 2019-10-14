package model;

import java.util.List;

public interface AdminI {

    Terminal getTerminal();

    List<Terminal>showTerminal();

    PurchaseLot getPurchaseLot();

    List<PurchaseLot>showPL();
}
