package view;

import model.Client;
import service.LogInService;
import java.util.Scanner;

public class ClientLogIn {
    private Scanner scanner = new Scanner(System.in);
    private LogInService clientLogIn = new LogInService();
    private ClientMenu clientMenu = new ClientMenu();
    private Client client;

    public void clientLogIn() {

        System.out.println("Client log in: \n");
        System.out.print("Please enter your nickname: "); // le saque el ln

        String nickname = scanner.nextLine();

        System.out.print("\n\n Please enter your password: ");

        String password = scanner.nextLine();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String valid = clientLogIn.clientLogIn(nickname, password);

        while (valid.equals("Invalid nickname or password.")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.print("Please enter your nickname: "); // le saque el ln

            String nickname2 = scanner.nextLine();

            System.out.print("Please enter your password: ");

            String password2 = scanner.nextLine();

            valid = clientLogIn.clientLogIn(nickname2, password2);
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(valid);

        clientMenu.clientMenu();
    }


}
