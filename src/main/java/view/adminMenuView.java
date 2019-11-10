package view;

import model.*;
import service.AdminService;
import util.AssetType;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class adminMenuView{


        private List<Client> clients = new ArrayList<>();
        private List<Client> blockedClients = new ArrayList<>();
        private List<Trip> trips = new ArrayList<>();
        private List<Terminal> terminals = new ArrayList<>();
        private List<Zone> zones = new ArrayList<>();
        private List<AssetType> assetTypes = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);
        private AdminService adminService = new AdminService();

        //  BLOQUEAR CLIENTE --------------------------------

    public void blockClientMenu() {
            System.out.println("Inserte nombre del usuario a bloquear");

            for (int i = 0; i < clients.size(); i++) {
                System.out.println(i + " " + clients.get(i).getNickname());
            }
            int blockClient = scanner.nextInt();

            adminService.blockClient(clients.get(blockClient));
        }

        // DESBLOQUEAR CLIENTE ----------------------------------

    public void unblockClientMenu(){
        System.out.println("Inserte nombre del usuario a desbloquear");

        for (int i = 0; i < blockedClients.size(); i++) {
            System.out.println(i + " " + clients.get(i).getNickname());
        }

        int unblockClient = scanner.nextInt();

        adminService.blockClient(clients.get(unblockClient));
    }


        //REPORT TRIP ---------------------------------------------

        public void reportTripMenu() {
            System.out.println("Inserte viaje a reportar.");

            for (int i = 0; i < trips.size(); i++) {
                System.out.println(i + " " + trips.get(i).getAsset() + " " + trips.get(i).getZone() +
                        " " + trips.get(i).getTripTime() + " " + trips.get(i).getClient());
            }
            int reportTripNum = scanner.nextInt();

            System.out.println("Inserte terminal.");

            int reportTerminal = scanner.nextInt();

            System.out.println("Inserte la multa que recivira.");

            int reportFine = scanner.nextInt();
            adminService.reportTrip(trips.get(reportTripNum), terminals.get(reportTerminal), reportFine);

        }
            // CREATE TERMINAL -----------------------------------------

    public void createTerminalMenu() {

        System.out.println("Inserte zona de la terminal nueva.");

        for (int i = 0; i < zones.size(); i++) {
            System.out.println(i + " " + zones.get(i).getType());
        }

        int newTerminalZone = scanner.nextInt();

        System.out.println("Inserte nombre de la terminal nueva.");

        String newTerminalName = scanner.nextLine();

        adminService.createTerminal(zones.get(newTerminalZone), newTerminalName);
    }

            // NEW PURCHASE LOT -----------------------------

    public void newParchuseLot(){
        System.out.println("Inserte zona.");
        for(int i = 0; i < zones.size(); i++) {
            System.out.println("Zona  " + i + "  " + zones.get(i).getType());
        }

        int newParchuseLotZone = scanner.nextInt();

        System.out.println("Inserte tipo de activo.");

        for(int i = 0; i < assetTypes.size(); i++) {
            System.out.println("Asset  " + i + "  " + assetTypes.get(i));
        }

        int newParchuseLotAsset = scanner.nextInt();

        System.out.println("Inserte la terminal.");

        for(int i = 0; i < terminals.size(); i++) {
            System.out.println("Terminal  " + i + "  " + terminals.get(i));
        }

        int newParchuseLotTerminal = scanner.nextInt();

        System.out.println("Inserte cantidad a comprar.");

        int newParchuseLotLot = scanner.nextInt();

        adminService.createPurchaseLot(zones.get(newParchuseLotZone),assetTypes.get(newParchuseLotAsset), terminals.get(newParchuseLotTerminal), newParchuseLotLot);
    }
}


