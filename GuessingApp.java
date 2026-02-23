import java.util.Scanner;
/**
 * MAIN CLASS
 * Use Case 4: Error Handling & Validation
 * Responsibilities:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate input using ValidationService
   4. Handle game flow without crashing on invalid input
 *
 * @author Developer
 * @version 4.0
 */
public class GuessingApp{

    public static void main(String[] args) throws InvalidInputException{

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
			int guess = ValidationService.validateInput(scanner.nextLine());
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