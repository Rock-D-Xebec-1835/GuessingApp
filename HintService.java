/*
	Use Case 2: Hint Generation
	This class is responsible for : 
	Generating controlled hints based on the number of incorrect attempts made by the player.
*/

class HintService{
	// Generates hints based on how many hints have alrready been used.
	public static String generateHint(int target, int hintCount){
		if(hintCount == 1){
			return (target % 2 == 0) ? "Hint: It is an even number!" : "Hint: It is an odd number!";
		} else if(hintCount == 2){
			return(target > 50) ? "Hint: It is > 50" : "Hint: It is < 50";
		}
		return "No more hints!!";
	}
}