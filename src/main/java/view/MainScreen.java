package view;

import java.util.Scanner;

public class MainScreen {

    private Scanner scanner = new Scanner(System.in);
    private AdminLogIn adminLogIn = new AdminLogIn();
    private ClientSignUp clientSignUp = new ClientSignUp();
    private ClientLogIn clientLogIn = new ClientLogIn();

    public void showScreen() {
        System.out.println("Welcome to MoovMe!");
        System.out.println("Are you an admin or a client? ");

        String userAnswer = scanner.nextLine();

        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (!userAnswer.equals("admin") && !userAnswer.equals("client")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Invalid answer.\n " +
                    "Are you an admin or a client? ");

            scanner.nextLine();
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        if (userAnswer.equals("admin")) {
            adminLogIn.adminLogIn();
        }

        if (userAnswer.equals("client")) {
            System.out.println("Would you like to sign up or log in? ");
            String userAnswer2 = scanner.nextLine();

            System.out.print("\033[H\033[2J");
            System.out.flush();

            while (!userAnswer2.equals("sign up") && !userAnswer2.equals("log in")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("Invalid answer.\n " +
                        "Would you like to sign up or log in? ");
                scanner.nextLine();
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (userAnswer2.equals("sign up")) {
                clientSignUp.clientSignUp();
            }

            if (userAnswer2.equals("log in")) {
                clientLogIn.clientLogIn();
            }
        }

        showScreen();
    }
}
