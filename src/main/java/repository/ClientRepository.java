package repository;

import model.Client;
import model.User;
import util.UserRepositoryInterface;
import java.util.List;

public class ClientRepository extends AbstractRepository<Client> implements UserRepositoryInterface {

    @Override
    public User searchByUsername(String username) {
        List<Client> clients = findAll();

        for (Client client: clients) {
            if ( client.getUsername().equals(username)) return client;
        }

        return null;
    }

    public Client searchByNickname(String nickname) {
        List<Client> clients = findAll();

        for (Client client: clients) {
            if ( client.getNickname().equals(nickname)) return client;
        }

        return null;
    }

    public Client searchByPhoneNumber(Integer phoneNumber) {
        List<Client> clients = findAll();

        for (Client client: clients) {
            if ( client.getPhoneNumber().equals(phoneNumber)) return client;
        }

        return null;
    }
}
