import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            String[] options = {"Rock", "Paper", "Scissors"};
            
            while (true) {
                System.out.print("Choose between (Rock, Paper, or Scissors): ");
                String playerMove = scanner.nextLine();
                playerMove = playerMove.toLowerCase();
                
                if (!isValidMove(playerMove)) {
                    System.out.println("Invalid move. Please, try again.");
                    continue;
                }
                
                int computerMoveIndex = random.nextInt(options.length);
                String computerMove = options[computerMoveIndex];
                
                System.out.println("System played " + computerMove);
                
                int result = getResult(playerMove, computerMove);
                
                if (result == 0) {
                    System.out.println("It's a tie!");
                } else if (result == 1) {
                    System.out.println("You win!");
                } else {
                    System.out.println("System wins!");
                }
                
                System.out.print("Do you want to play again? (y/n): ");
                String playAgain = scanner.nextLine();
                
                if (playAgain.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
    }
    
    public static boolean isValidMove(String move) {
        return move.equals("Rock") || move.equals("Paper") || move.equals("Scissors");
    }
    
    public static int getResult(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return 0; // tie
        } else if (playerMove.equals("Rock")) {
            return computerMove.equals("Scissors") ? 1 : -1; 
        } else if (playerMove.equals("Paper")) {
            return computerMove.equals("Rock") ? 1 : -1; 
        } else {
            return computerMove.equals("Paper") ? 1 : -1; 
        }
    }
}