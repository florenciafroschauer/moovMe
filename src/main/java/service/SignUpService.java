package service;

import model.Client;
import repository.ClientRepository;
import java.util.List;

/**
 * Cuando un cliente se registre, que le pida el nombre, numero de telefono,
 * valida los datos y despues que le pida el apodo y la contraseña.
 */

public class SignUpService {

    private ClientRepository clientRepository = ClientRepository.getInstance();

    private List<Client> signedUpClients = clientRepository.findAll();

    public String signUp(String username, Integer phoneNumber) {
        for (Client client: signedUpClients) {
            if (client.getUsername().equals(username) ||
                    client.getPhoneNumber().equals(phoneNumber)) {

                return "Username or phone number already exists.";
            }
        }

        return "Username and password validated.";
    }

    public String registerClient(String username, Integer phoneNumber, String nickname, String password) {
        for (Client client: signedUpClients) {
            if (client.getNickname().equals(nickname)) {
                return "Nickname already exists.";
            }
        }

        Client client = new Client(username, password, phoneNumber, nickname);
        clientRepository.create(client);

        return "Registered successfully.";
    }

    public List<Client> getSignedUpClients() {
        return signedUpClients;
    }
}
