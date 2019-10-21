package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scoring {
    private List<AssetI> asset;
    private ArrayList leaderboard;

    public void Leaderboard(){

        Clients.sort((Client a, Client b)-> b.getScore() -a.getScore());
    }
}


