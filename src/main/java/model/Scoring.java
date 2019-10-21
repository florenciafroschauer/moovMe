package model;

import java.util.ArrayList;
import java.util.List;

public class Scoring {
    private List<AssetI> asset;
    private ArrayList leaderboard;

    public void leaderBoard(List<Client> clients) {
        clients.sort((Client a, Client b)-> b.getScore() -a.getScore());
    }
}


