package view;

import model.Client;
import service.LogInService;
import java.util.Scanner;

public class ClientLogIn {
    private Scanner scanner = new Scanner(System.in);
    private LogInService clientLogIn = new LogInService();
    //private ClientMenu clientMenu = new ClientMenu();
    private Client client;

    public void clientLogIn() {

        System.out.println("Client log in: \n");
        System.out.println("Please enter your nickname: ");

        String nickname = scanner.next();

        System.out.println("\n\n Please enter your password: ");

        String password = scanner.next();

        System.out.println("\033[H\033[2J");
        System.out.flush();

        String valid = clientLogIn.clientLogIn(nickname, password);

        while (valid.equals("Invalid nickname or password.")) {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println("Please enter your nickname: "); // le saque el ln

            String nickname2 = scanner.next();

            System.out.println("Please enter your password: ");

            String password2 = scanner.next();

            valid = clientLogIn.clientLogIn(nickname2, password2);
        }

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println(valid);

        //clientMenu.clientMenu();
    }

    /**
     * Menu:
     *
     * 1. Log in
     * 2. Signup as admin
     * 3. Signup as user
     *
     * 3
     *
     * Nombre: brian
     * Contraseña: asdfasdf
     *
     * 1
     *
     * Nombre: brian
     * Contraseña: asdfasd
     *
     * 1. Realizar viaje
     * 2. Ver perfil
     * 3. Salir
     *
     *
     * ----
     *
     *
     */
}
