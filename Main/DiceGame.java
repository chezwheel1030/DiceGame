import java.util.Scanner;

public class DiceGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Die die = new Die();
        Hitpoints userHitpoints = new Hitpoints();
        aiHp aiHitpoints = new aiHp();
        AI ai = new AI(100, aiHitpoints);

        String userInput;

        do {
            System.out.print("Type 'start' to begin: ");
            userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("start")) {
                initializeGame(userHitpoints, aiHitpoints, die);

                while (!isGameOver(userHitpoints, aiHitpoints)) {
                    playUserTurn(die, userHitpoints, ai);
                    if (isGameOver(userHitpoints, aiHitpoints)) break; // Check if user won after their turn

                    playAITurn(die, ai, userHitpoints);
                }

                System.out.println("Game Over!");
            } else {
                System.out.println("Incorrect input. Try again.");
            }

        } while (userInput.equalsIgnoreCase("start"));

        scanner.close();
    }

    private static void initializeGame(Hitpoints userHitpoints, aiHp aiHitpoints, Die die) {
        userHitpoints.userStartHp(100);
        aiHitpoints.aiStartHp(100);
        die.resetDie();
    }

    private static void playUserTurn(Die die, Hitpoints userHitpoints, AI ai) {
        int userDiceRoll = die.userRollDice(0);
        System.out.println(die.userDieToString());
    
        int aiDiceRoll = die.aiRollDice(0);
        System.out.println(die.aiDieToString());
    
        System.out.println("---------------------------------");
    
        if (userDiceRoll > aiDiceRoll) {
            handleUserTurn(userDiceRoll, aiDiceRoll, die, userHitpoints, ai);
            playAITurn(die, ai, userHitpoints); // Call playAITurn after handling user turn
        } else if (userDiceRoll < aiDiceRoll) {
            aiChooseAction(ai);
        } else {
            System.out.println("Starting over because of a tie");
        }
    }
    
    
    private static void playAITurn(Die die, AI ai, Hitpoints userHitpoints) {
        System.out.println("| AI's turn |");
        System.out.println("---------------------------------");
        ai.aiChooseAction();
        handleAITurn(ai, die, userHitpoints);
    } 
    

    private static void handleUserTurn(int userDiceRoll, int aiDiceRoll, Die die, Hitpoints userHitpoints, AI ai) {
        String userAction;
        do {
            System.out.println("| You get to go |");
            System.out.println("---------------------------------");
            System.out.println("If you would like to gain hp type 'heal'");
            System.out.println("If you would like to do damage type 'hurt'");
            System.out.println("Or type 'aihp' or 'userhp' to see hp");
            userAction = new Scanner(System.in).nextLine();
            System.out.println("---------------------------------");
    
            processUserChoice(userAction, die, userHitpoints, ai);
    
        } while (!userAction.equalsIgnoreCase("userhp") && !userAction.equalsIgnoreCase("aihp") && !userAction.equalsIgnoreCase("done"));
    }
    

    private static void processUserChoice(String userAction, Die die, Hitpoints userHitpoints, AI ai) {
        switch (userAction.toLowerCase()) {
            case "heal":
                int userHeal = die.userRollDice(0);
                System.out.println(die.userDieToString());
                System.out.println("---------------------------------");
                userHitpoints.userGainHp(userHeal * 2);
                System.out.println(userHitpoints.userHp());
                break;

            case "hurt":
                int userDmg = die.userRollDice(0);
                System.out.println(die.userDieToString());
                System.out.println("---------------------------------");
                ai.aiLoseHp(userDmg * 3);
                System.out.println(ai.aiCurHp());
                break;

            case "userhp":
                System.out.println(userHitpoints.userHp());
                System.out.println("---------------------------------");
                break;

            case "aihp":
                System.out.println(ai.aiCurHp());
                System.out.println("---------------------------------");
                break;

            default:
                System.out.println("Not a valid option, try again!");
        }

        System.out.println("When done reading, type 'done'");
        String done = new Scanner(System.in).nextLine();
        while (!done.equalsIgnoreCase("done")) {
            // Allow the user to finish reading before proceeding
        }
    }

    private static void handleAITurn(AI ai, Die die, Hitpoints userHitpoints) {
        // Implement AI turn logic here
        // For simplicity, let's assume AI always attacks for now
        int aiDamage = die.aiRollDice(0) * 3;
        userHitpoints.userLoseHp(aiDamage);

        System.out.println("AI attacks for " + aiDamage + " damage.");
        System.out.println("User HP: " + userHitpoints.userHp());
        System.out.println("---------------------------------");
    }

    private static boolean isGameOver(Hitpoints userHitpoints, aiHp aiHitpoints) {
        return userHitpoints.isDead() || aiHitpoints.isDead();
    }

    private static void aiChooseAction(AI ai) {
        ai.aiChooseAction();
    }
}
