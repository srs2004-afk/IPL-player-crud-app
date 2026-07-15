package com.tka.controller;

import java.util.List;
import java.util.Scanner;

import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLMenu {
	
	public static void main(String[] args) {
		List<Player> allPlayer ;
        Scanner sc = new Scanner(System.in);
        IPLService iplservice = new IPLService();

        while (true) {
            System.out.println("\n=== IPL Player Management Menu ===");
            System.out.println("1. View All Players");
            System.out.println("2. View Players by Team");
            System.out.println("3. Add Player");
            System.out.println("4. Delete Player");
            System.out.println("5. Update Player Team");
            System.out.println("6. Update Runs");
            System.out.println("7. Update Wickets");
            System.out.println("8. Show Orange Cap Holder");
            System.out.println("9. Show Purple Cap Holder");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    List<Player> allPlayers = iplservice.getAllPlayer();
                    allPlayers.forEach(p -> System.out.println(
                        p.getP_name() + " --> " + p.getTeam()));
                    break;

                case 2:
                    System.out.println("Enter Team Name:");
                    String team = sc.nextLine();
                    List<Player> playersByTeam = iplservice.getPlayerByTeam(team);
                    playersByTeam.forEach(p -> System.out.println(
                        p.getP_name() + " --> " + p.getRuns() + " --> " + p.getTeam()));
                    break;

                case 3:
                    System.out.println("Enter Player Id:");
                    int id = sc.nextInt();
                    System.out.println("Enter Jersey Number:");
                    int jn = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Player Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Runs:");
                    int runs = sc.nextInt();
                    System.out.println("Enter Wickets:");
                    int wickets = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Team:");
                    String newTeam = sc.nextLine();

                    Player newPlayer = new Player(id, jn, name, runs, wickets, newTeam);
                    System.out.println(iplservice.addPlayer(newPlayer));
                    break;

                case 4:
                    Player delPlayer = new Player();
                    System.out.println("Enter Player Id to Delete:");
                    delPlayer.setP_id(sc.nextInt());
                    System.out.println(iplservice.deletePlayer(delPlayer));
                    break;

                case 5:
                    Player updPlayer = new Player();
                    System.out.println("Enter Player Id:");
                    updPlayer.setP_id(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter New Team:");
                    updPlayer.setTeam(sc.nextLine());
                    System.out.println(iplservice.updatePlayer(updPlayer));
                    break;

                case 6:
                    Player runPlayer = new Player();
                    System.out.println("Enter Player Id:");
                    runPlayer.setP_id(sc.nextInt());
                    System.out.println("Enter Runs:");
                    runPlayer.setRuns(sc.nextInt());
                    System.out.println(iplservice.updateRuns(runPlayer));
                    break;

                case 7:
                    Player wicketPlayer = new Player();
                    System.out.println("Enter Player Id:");
                    wicketPlayer.setP_id(sc.nextInt());
                    System.out.println("Enter Wickets:");
                    wicketPlayer.setWicket(sc.nextInt());
                    System.out.println(iplservice.updateWickets(wicketPlayer));
                    break;

                case 8:
                    Player orangeCap = iplservice.mostRuns();
                    System.out.println("Orange Cap Holder --> " +
                        orangeCap.getP_name() + " -> " + orangeCap.getRuns());
                    break;

                case 9:
                	allPlayers = iplservice.getAllPlayer();
                    Player purpleCap = iplservice.mostWickets();
                    System.out.println("Purple Cap Holder --> " +
                        purpleCap.getP_name() + " -> " + purpleCap.getWicket());
                    break;

                case 0:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
	}
}
