package view;

import model.*;
import service.ScoringService;
import service.TripService;
import util.Date;
import util.Hour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientMenuView {
    private List<Asset> assets = new ArrayList<>();
    private List<Zone> zones = new ArrayList<>();
    private List<Terminal> terminals = new ArrayList<>();
    private List<Discount> discounts = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    private ScoringService scoringService = null;
    private TripService tripService = null;
    private LogInView logInView = new LogInView();
    private Scanner scanner = new Scanner(System.in);

    public void clientMainMenu(){

        LogInView logInView = new LogInView();

        System.out.println("Welcome" + logInView.getLoginNickname() + "!");
        System.out.println("What do you wish to do?");
        System.out.println("1. Create new trip.");
        System.out.println("2. Check the monthly leaderboard");
        System.out.println("3. Check your profile");

        int mainMenuOption = scanner.nextInt();

        if(mainMenuOption == 1){
            clientMenuNewTrip();
        } else if(mainMenuOption == 2){
            clientMenuLeaderboard();
        } else if(mainMenuOption == 3){
            clientMenuProfile();
        } else{
            clientMainMenu();
        }
    }


    //NEW TRIP -----------------------------

    public void clientMenuNewTrip(){



        System.out.println("Please, choose an asset:");

        for (int i = 0; i < assets.size(); i++) {

            System.out.println(i + " " + assets.get(i));

        }

        int newTripAsset = scanner.nextInt();


        System.out.println("Please, choose the zone: ");

        for (int i = 0; i < zones.size(); i++) {

            System.out.println(i + " " + zones.get(i));
        }

        int newTripZone = scanner.nextInt();

        System.out.println("Please, choose terminal to deliver the asset: ");

        for (int i = 0; i < terminals.size(); i++) {

            System.out.println(i + " " + terminals.get(i));
        }

        int newTripTerminal = scanner.nextInt();

        System.out.println("Please, choose minute to return the asset");
        int newTripDateMinute = scanner.nextInt();
        System.out.println("Please, choose hour to return the asset");
        int newTripDateHour = scanner.nextInt();
        System.out.println("Please, choose day to return the asset");

        int newTripDateDay = scanner.nextInt();

        System.out.println("Please, choose month to return the asset");

        int newTripDateMonth = scanner.nextInt();

        System.out.println("Please, choose year to return the asset");

        int newTripDateYear = scanner.nextInt();

        System.out.println("Please, choose if you whish to use a discount");

        for (int i = 0; i < discounts.size(); i++) {
            System.out.println(i + " " + discounts.get(i));
        }

        int newTripDiscount = scanner.nextInt();


        System.out.println("The trip will be in the asset" + assets.get(newTripAsset) + " in the zone " + zones.get(newTripZone) +
                " in the terminal " + terminals.get(newTripTerminal) + " at the time " + newTripDateMinute + " " + newTripDateHour +
                " " + newTripDateDay + " " + newTripDateMonth + " " + newTripDateYear + " with " +
                discounts.get(newTripDiscount) + "% discount");

        System.out.println("is this information correct? insert yes or no");

        String correctInfo = scanner.nextLine();

        if (correctInfo.equals("no")) {

            clientMainMenu();
        } else {

            Hour hour = new Hour(newTripDateMinute, newTripDateHour);
            Date date = new Date(newTripDateDay, newTripDateMonth, newTripDateYear);
            tripService.setHour(hour);
            tripService.setAsset(assets.get(newTripAsset));
            tripService.setZone(zones.get(newTripZone));
            tripService.setTerminalToHandOver(terminals.get(newTripTerminal));
            tripService.setDiscount(discounts.get(newTripDiscount));

        }
    }

    public void clientMenuLeaderboard(){

        System.out.println("This is the the top 3 clients with more score: ");

        scoringService.showLeaders();

        clientMainMenu();
    }

    public void clientMenuProfile(){

        System.out.println("What do you wish to check?");
        System.out.println("1. Points");
        System.out.println("2. Discounts");
        System.out.println("3. Go back to the main menu");

        int profileOptions = scanner.nextInt();
        if(profileOptions == 1){

            for (int i = 0; i < clients.size() ; i++) {
                if(clients(i).getNickname().equals(logInView.getLoginNickname)){ //busca al usuario y le muestra la cantidad de puntos que tiene
                    System.out.println("Your actual score is: " + clients(i).getScore);
                }
            }
        } else if(profileOptions == 2){

            System.out.println("Your Discount are: ");

            for (int i = 0; i < clients.size() ; i++) {

                if (clients(i).getNickname().equals(logInView.getLoginNickname)) {

                    for (int j = 0; j < clients(i).getDiscounts.size(); j++) {

                        System.out.println(j + " " + clients(i).getDiscounts(j));
                    }

                }
            }

        }else{
            clientMainMenu();
        }


    }
}