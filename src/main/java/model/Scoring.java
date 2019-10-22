package model;

import java.util.ArrayList;

public class Scoring {
    private ArrayList<Client> leaderBoard;
    private final Zone zone;
    private ArrayList<Discount> discounts;

    public Scoring(ArrayList<Client> leaderBoard, Zone zone) {
        this.leaderBoard = leaderBoard;
        this.zone = zone;
    }

    public void leaderBoard(ArrayList<Client> clients) {
        clients.sort((Client a, Client b)-> b.getScore() - a.getScore());
    }
}
