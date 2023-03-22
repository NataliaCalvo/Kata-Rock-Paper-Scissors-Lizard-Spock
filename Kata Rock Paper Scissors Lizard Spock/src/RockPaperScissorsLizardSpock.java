import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsLizardSpock {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();

            String[] options = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};

            System.out.println("Let's play Rock, Paper, Scissors, Lizard, Spock!");
            System.out.println("Enter your choose (rock, paper, scissors, lizard or Spock):");

            String playerElection = scanner.nextLine().toLowerCase();

            if (!validElection(playerElection)) {
                System.out.println("Invalid election. Choose again.");
                return;
            }

            String systemElection = options [random.nextInt(options.length)];

            System.out.println("The system has chosen " + systemElection + ".");

            if (playerElection.equals(systemElection)) {
                System.out.println("Draw!");
            } else if (playerElection.equals("Rock") && (systemElection.equals("Scissors") || systemElection.equals("Lizard"))) {
                System.out.println("You Win!");
            } else if (playerElection.equals("Paper") && (systemElection.equals("Rock") || systemElection.equals("Spock"))) {
                System.out.println("You Win!");
            } else if (playerElection.equals("Scissors") && (systemElection.equals("Paper") || systemElection.equals("Lizard"))) {
                System.out.println("You Win!");
            }
            else if (playerElection.equals("Lizard") && (systemElection.equals("Spock") || systemElection.equals("Paper"))) {
                System.out.println("You Win!");
            }
            else if (playerElection.equals("Spock") && (systemElection.equals("Scissors") || systemElection.equals("Rock"))) {
                System.out.println("You Win!");
        
    }
}
    }

    private static boolean validElection(String playerElection) {
        return false;
    }
}