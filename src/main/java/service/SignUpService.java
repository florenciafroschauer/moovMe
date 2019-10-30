package service;

import model.Client;
import java.util.List;
import java.util.Scanner;

public class SignUpService {

    private List<Client> signedUpClients;

    // Cuando un cliente se registre, que le pida el nombre, numero de telefono, valida los datos
    // y despues que le pida el apodo y la contraseña

    // Chequear que el nickname sea unico

    public Client signUp(String username, String password, String phoneNumber, String nickname) {
        Client client = new Client(username, password, phoneNumber, nickname);
        Scanner sc = new Scanner(System.in);
        for (Client clients:signedUpClients) {
            if(clients.getNickname().equals(nickname)){
                while(clients.getNickname().equals(nickname)){
                    System.out.println("El nombre de usuario ya esta tomado porfavor ingrese otro:");
                    nickname = sc.nextLine();
                }
            }
        }
        signedUpClients.add(client);
        return client;
    }
}
