package service;

import model.Admin;
import model.Client;

import java.util.List;

/**
 * Perguntar si es admin o client, son dos log in separados.
 */
public class LogInService {
    private List<Client> signedUpClients; // persisitr
    private List<Admin> signedUpAdmins; // persistir

    public void clientLogIn(String nickname, String password) {
        Client client1 = null;

        for (Client client: signedUpClients) {

            if (client.getNickname().equals(nickname) &&
                    client.getPassword().equals(password)) {
                client1 = client;
            }
        }

        if (client1 == null) {
            throw new RuntimeException("Invalid nickname or password.");
        }
    }

    public void AdminLogIn(String username, String password) {
        Admin admin1 = null;

        for (Admin admin: signedUpAdmins ) {

            if (admin.getUsername().equals(username) &&
                    admin.getPassword().equals(password)) {
                admin1 = admin;
            }
        }

        if (admin1 == null) {
            throw new RuntimeException("Invalid username or password.");
        }
    }
}
