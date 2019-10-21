package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Scoring {
    private List<AssetI> asset;
    private ArrayList leaderboard;

    public void Leaderboard(){

        Collections.sort(Clients, new SortByScore(){
            public int compare(Client a, Client b){
                return Integer.valueOf(b.getScore()).compareTo(a.getScore());
            }
        });
    }
}

class SortByScore implements Comparator<Client> {

    public int compare(Client a, Client b){

        return b.getScore() - a.getScore();

    }

}

