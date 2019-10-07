package model;

public interface ClientI {
    // void clientPays(Bill bill);
    void rentAnAsset(AssetI asset);
    void exchangePoints(int points);
    int howManyPoints();
    double chooseTimeofAsset(double chooseTimeofAsset);
    // List<Discount> showDiscounts();
}
