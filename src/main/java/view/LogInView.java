package view;


import java.util.Scanner;

public class LogInView {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to MoovMe!");
        System.out.println("Would you like to login or register as an user? insert yes or no.");

        String loginAsUser = scanner.nextLine();
        while (loginAsUser.equals("yes") || loginAsUser.equals("no")){
        if(loginAsUser.equals("yes")){

            System.out.println("Would you like to register or login?");

            String registerOrLogin = scanner.nextLine();

            if (registerOrLogin.equals("login")){
                System.out.println("Please insert your username and password.");

                String loginUsername = scanner.nextLine();
                String loginPassword = scanner.nextLine();
            }
        }
    }
}
}

