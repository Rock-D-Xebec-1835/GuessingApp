import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class StorageService{
	/*
		saves the final outcome of the game.
	*/
	
	public static void saveResult(String player, int attempts, boolean win){
		/*
			Try-with-resource ensures that the writer is closed automatically after the operation completes.
		*/
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("game_results.txt", true))){
			writer.write("Player: " + player + ", Attempts: " + attempts + ", Result: " + (win ? "WIN" : "LOSE"));
			writer.newLine();
		} catch(IOException e){
			System.out.println("Unable to save game result.");
		}
	}
	
}
