package view;


import service.LogInService;
import service.SignUpService;

import java.util.Scanner;

public class LogInView {



    public static void main(String[] args) {
        LogInService logInService = new LogInService();
        SignUpService signUpService = new SignUpService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to MoovMe!");
        System.out.println("Would you like to login or register as an user? insert yes or no.");

        String loginAsUser = scanner.nextLine();
        while (loginAsUser.equals("yes") || loginAsUser.equals("no")){
        if(loginAsUser.equals("yes")){

            System.out.println("Would you like to register or login?");

            String registerOrLogin = scanner.nextLine();

            System.out.print("\033[H\033[2J");
            System.out.flush();

            if (registerOrLogin.equals("login")){

                System.out.println("Please insert your nickname.");
                String loginNickname = scanner.nextLine();

                System.out.println("Please insert your password.");
                String loginPassword = scanner.nextLine();

                logInService.clientLogIn(loginNickname, loginPassword);

                System.out.print("\033[H\033[2J");
                System.out.flush();

            }else if (registerOrLogin.equals("register")){

                System.out.println("Please insert your username.");
                String registerUsername = scanner.nextLine();

                System.out.println("Please insert your phone number.");
                String registerPhoneNumber = scanner.nextLine();

                signUpService.signUp(registerUsername, registerPhoneNumber);

                System.out.println("Please insert your password.");
                String registerPassword = scanner.nextLine();
                System.out.println("Please insert your nickname.");
                String registerNickname = scanner.nextLine();

                signUpService.registerClient(registerUsername, registerPhoneNumber, registerNickname, registerPassword);

                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } else if(loginAsUser.equals("no")){

            System.out.println("Logging as an admin.");

            System.out.println("Please insert your nickname.");
            String loginAdminNickname = scanner.nextLine();

            System.out.println("Please insert your password.");
            String loginAdminPassword = scanner.nextLine();

            logInService.AdminLogIn(loginAdminNickname, loginAdminPassword);

            System.out.print("\033[H\033[2J");
            System.out.flush();

        }
    }
}
}

