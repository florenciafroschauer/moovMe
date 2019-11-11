package view;

import service.LogInService;
import java.util.Scanner;

public class AdminLogIn {

    private Scanner scanner = new Scanner(System.in);
    private LogInService adminLogIn = new LogInService();
    private AdminMenu adminMenu = new AdminMenu();


    public void adminLogIn() {

        System.out.println("Admin log in: \n");
        System.out.println("Please enter your username: "); // le saque el ln

        String username = scanner.next();

        System.out.println("\n\n Please enter your password: ");

        String password = scanner.next();

        System.out.println("\033[H\033[2J");
        System.out.flush();

        String valid = adminLogIn.AdminLogIn(username, password);

        while (valid.equals("Invalid username or password.")) {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println("Please enter your username: ");

            String username2 = scanner.next();

            System.out.println("Please enter your password: ");

            String password2 = scanner.next();

            valid = adminLogIn.AdminLogIn(username2, password2);
        }

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println(valid);

        adminMenu.adminMenu();
    }
}
