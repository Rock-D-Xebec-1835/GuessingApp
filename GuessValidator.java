/*
	Use Case 2: User Guess Submission
	This class is responsible for : 
	Comparing the user guess with Target number
	It doesnt handle input or output
*/

class GuessValidator{
	//Compares guess with target and returns comparision result.
	public static String validateGuess(int guess, int target){
		if(guess == target){
			return "CORRECT!";
		}
		else if(guess < target){
			return "LOW";
		}
		else{
			return "HIGH";
		}
	}
}
