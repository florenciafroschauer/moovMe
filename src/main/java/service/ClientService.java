package service;

import model.Client;
import model.Discount;

import java.util.List;

public class ClientService {

    private Client client;

    public Integer showScore(Client client) {
        return client.getScore();
    }

    public List<Discount>showDiscounts(Client client) {
        return client.getDiscounts();
    }

}
