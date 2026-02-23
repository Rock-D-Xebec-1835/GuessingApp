/*
	Handles game lifecycle decisions.
	This class is responsible for
		- Whether the game should restart or exit based on user choice.
*/
import java.util.Scanner;
class GameController{
	// Asks the player if they want to restart the game after completion
	public static boolean restartGame(Scanner scanner){
		System.out.print("Do you want to restart ? (yes/no)");
		return scanner.nextLine().equalsIgnoreCase("yes");
	}
	
}