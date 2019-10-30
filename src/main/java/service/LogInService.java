package service;

import model.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class LogInService {

    // tenemos que hacer que los usuarios entran con nickname y contraseña, pero los admin no tienen nickname
    Boolean loginStatus;
    public void logIn(String loginUsername, String loginPassword, Client client, ArrayList clients){


        for(int i = 0; i < clients.size(); i++){

            /** Falta aclarar la lista de clientes */

            if(loginUsername.equals(clients(i).getUsername) && loginPassword.equals(clients(i).getPassword)){

                loginStatus = true;
                System.out.println("Successfuly logged in.");

                break;

            }

        }
    }
}
