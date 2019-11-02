package service;

import model.Client;
import java.util.List;

/**
 * Cuando un cliente se registre, que le pida el nombre, numero de telefono,
 * valida los datos y despues que le pida el apodo y la contraseña.
 */

public class SignUpService {
    private List<Client> signedUpClients;

    public void signUp(String username, String phoneNumber) {
        for (Client client: signedUpClients) {

            if (client.getUsername().equals(username) ||
                    client.getPhoneNumber().equals(phoneNumber)) {
                throw new RuntimeException("Username or phone number already exists.");
            }
        }
    }

    public Client registerClient(String username, String phoneNumber, String nickname, String password) {
        for (Client client: signedUpClients) {

            if (client.getNickname().equals(nickname)) {
                throw new RuntimeException("Nickname already exists.");
            }
        }

        Client client = new Client(username, password, phoneNumber, nickname);
        signedUpClients.add(client);

        return client;
    }
}
