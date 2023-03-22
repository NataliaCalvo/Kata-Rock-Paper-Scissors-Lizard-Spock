import java.util.Random;
import java.util.Scanner;

interface Move {
    String getName();
    boolean winsAgainst(Move move);
}

class Rock implements Move {
    @Override
    public String getName() {
        return "Rock";
    }
    
    @Override
    public boolean winsAgainst(Move move) {
        return move.getName().equals("Scissors") || move.getName().equals("Lizard");
    }
}

class Paper implements Move {
    @Override
    public String getName() {
        return "Paper";
    }
    
    @Override
    public boolean winsAgainst(Move move) {
        return move.getName().equals("Rock") || move.getName().equals("Spock");
    }
}

class Scissors implements Move {
    @Override
    public String getName() {
        return "Scissors";
    }
    
    @Override
    public boolean winsAgainst(Move move) {
        return move.getName().equals("Paper") || move.getName().equals("Lizard");
    }
}

class Lizard implements Move {
    @Override
    public String getName() {
        return "Lizard";
    }
    
    @Override
    public boolean winsAgainst(Move move) {
        return move.getName().equals("Paper") || move.getName().equals("Spock");
    }
}

class Spock implements Move {
    @Override
    public String getName() {
        return "Spock";
    }
    
    @Override
    public boolean winsAgainst(Move move) {
        return move.getName().equals("Rock") || move.getName().equals("Scissors");
    }
}

class MoveFactory {
    public static Move getMove(String playerMoveName) {
        switch (playerMoveName) {
            case "Rock":
                return new Rock();
            case "Paper":
                return new Paper();
            case "Scissors":
                return new Scissors();
            case "Lizard":
                return new Lizard();
            case "Spock":
                return new Spock();
            default:
                return null;
        }
    }

    public static Move getMove(int computerMoveIndex) {
        return null;
    }
}

public class RPSLS {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            while (true) {
                System.out.print("Choose one (Rock, Paper, Scissors, Lizard, or Spock): ");
                String playerMoveName = scanner.nextLine();
                
                Move playerMove = MoveFactory.getMove(playerMoveName);
                if (playerMove == null) {
                    System.out.println("Invalid move. Please try again.");
                    continue;
                }
                
                int computerMoveIndex = random.nextInt(5);
                Move computerMove = MoveFactory.getMove(computerMoveIndex);
                
                System.out.println("System played " + computerMove.getName());
                
                if (playerMove.winsAgainst(computerMove)) {
                    System.out.println("You win!");
                } else if (computerMove.winsAgainst(playerMove)) {
                    System.out.println("System wins!");
                } else {
                    System.out.println("It's a tie!");
                }
                
                System.out.print("Do you want to play again? (y/n): ");
                String playAgain = scanner.nextLine();
                
                if (playAgain.equalsIgnoreCase("n")) {
                    break;
                }
            }
        }
    }
}