package football_menager_aplication;
import java.util.Scanner;

public class SimulateSystem {
    public static void main(String[] args) {
    TransferBoard transferBoard = new TransferBoard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1- List all Players in the system.");
            System.out.println("2- List all Teams in the system.");
            System.out.println("3- List all teamless players.");
            System.out.println("4- Establish a contract between a player and a team.");
            System.out.println("5- Exit.");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("All Players in the system:");
                    transferBoard.getTeamPlayers();
                    break;
                case 2:
                    System.out.println("All Teams in the system:");
                    transferBoard.getTeams();
                    break;
                case 3:
                    System.out.println("Teamless players:");
                    for (Player player : transferBoard.teamPlayers) {
                    if (player.getCurrentTeam() == null) {
                    System.out.println(player.getName());
        }
    }
                    break;
                case 4:
                    System.out.println("Enter player name, team name, contract type, and contract value:");
                    String[] contractInfo = scanner.nextLine().split(" ");
                    String playerName = contractInfo[0];
                    String teamName = contractInfo[1];
                    String contractType = contractInfo[2];
                    double contractValue = Double.parseDouble(contractInfo[3]);
                    String contractResult = transferBoard.makeContract(playerName, teamName, contractType, contractValue);
                    System.out.println(contractResult);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
