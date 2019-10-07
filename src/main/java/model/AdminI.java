package model;

public interface AdminI {
    void blockClient(ClientI client);
    void unblockClient(ClientI client);
    PurchaseLotI createAPurchaseLot();
    TerminalI createATerminal();
}
