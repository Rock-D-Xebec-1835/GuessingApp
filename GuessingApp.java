import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * MAIN CLASS
 * Use Case 5: Game Result Storage
 * Responsibilities:
 * 1. Persisting the final game result after the game ends
 * 2. Result are stored in a file so that game history is not lost after ends.
 *
 * @author Developer
 * @version 6.0
 */
public class GuessingApp{

    public static void main(String[] args) throws InvalidInputException{

        System.out.println("Welcome to the Guessing App");
		boolean restart;
		
		do{
			GameConfig config = new GameConfig();
			config.showRules();

			Scanner scanner = new Scanner(System.in);
			int attempts = 0;
			int hints = 1;
			boolean win = false;
			System.out.println("Enter the player name: ");
			String player = scanner.nextLine();

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
					win = true;
					break;
				}
				
			}
			StorageService.saveResult(player, attempts, win);
			restart = GameController.restartGame(scanner);
		}while(restart);

        
    }
}