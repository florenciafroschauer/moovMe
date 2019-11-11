package view;

import model.Client;
import service.SignUpService;
import java.util.Scanner;

public class ClientSignUp {
    private Scanner scanner = new Scanner(System.in);
    private SignUpService signUpService = new SignUpService();
    private Client client;

    public void clientSignUp() {

        System.out.println("Client sign up: \n");
        System.out.println("Please enter your username: "); // le saque el ln

        String username = scanner.nextLine();

        System.out.println("\n\n Please enter your phonenumber: ");

        Integer phoneNumber = scanner.nextInt();

        System.out.println("\033[H\033[2J");
        System.out.flush();

        String valid = signUpService.signUp(username, phoneNumber);

        while (valid.equals("Username or phone number already exists.")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Please enter your username: "); // le saque el ln

            String username2 = scanner.next();

            System.out.println("Please enter your phonenumber: ");

            Integer phoneNumber2 = scanner.nextInt();

            valid = signUpService.signUp(username2, phoneNumber2);
        }

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println(valid);

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println("Please enter your nickname: "); // aca tambien

        String nickname = scanner.next();

        System.out.println("Please enter your password: ");

        String password = scanner.next();

        System.out.println("\033[H\033[2J");
        System.out.flush();

        String valid1 = signUpService.registerClient(username, phoneNumber, nickname, password);

        while (valid1.equals("Nickname already exists.")) {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println("Pleas enter your nickname: "); // aca tambien

            String nickname2 = scanner.nextLine();

            valid1 = signUpService.registerClient(username, phoneNumber, nickname2, password);
        }

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println(valid1);

        System.out.println("\033[H\033[2J");
        System.out.flush();

        client = new Client(username, password, phoneNumber, nickname);
    }

    protected Client getClient() {
        return client;
    }
}
