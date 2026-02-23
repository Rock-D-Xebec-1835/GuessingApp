import java.util.Scanner;
/**
 * MAIN CLASS
 *
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Stop when game ends
 *
 * @author Developer
 * @version 3.0
 */
public class GuessingApp{

    public static void main(String[] args){

        System.out.println("Welcome to the Guessing App");

        GameConfig config = new GameConfig();
        config.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
		int hints = 1;

        /*
         * Game loop runs until the player
         * exhausts the maximum attempts.
         */
        while(attempts<config.getMaxAttempts()){ 
			System.out.print("Guess the number: ");
			int guess =scanner.nextInt();
			attempts++;
			
			String result= GuessValidator.validateGuess(guess,config.getTargetNumber());
			System.out.println(result);
			String hint = HintService.generateHint(config.getTargetNumber(), hints);
			System.out.println(hint);
			hints++;
			
			if("CORRECT!".equals(result)){
				break;
			}
		
		}
    }
}