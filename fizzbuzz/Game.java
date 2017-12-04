/**
 * @author	Raffael Gyr
 * @version	1.0
 * @date	04.08.2017 (dd.mm.yyyy)
 * 
 * contains the game fizzbuzz
 */
package fizzbuzz;

/**
 * used to let the player input something
 */
import java.util.Scanner;

/**
 * used for the 'isDividable' method
 */
import basics.Dividable;

/**
 * @author	Raffael Gyr
 * @version	1.0
 * @date	09.08.2017 (dd.mm.yyyy)
 * 
 * let's the player play the game
 */
public class Game {
	
	//Start of declaration of variables
	
	//Scanner
	private static Scanner in = new Scanner(System.in);
	
	//Fizzbuzz
	private static Fizzbuzz FB;
	
	//End of declaration of variables
	
	//Start of declaration of methods
	
	/**
	 * main-method
	 * @param args
	 */
	public static void main(String[] args) {
		//variables
		FB = new Fizzbuzz();
		
		//new variables
		boolean again = true;
		int turn = 0;
		int player = 0;
		String input = "";
		String answer = "";
		
		//actions
		
		/*
		 * 1. determine which player is playing
		 * 2. let the player input it's answer
		 * 3. check if the answer is correct
		 * 3,1. if it is		go to step 1
		 * 3,2. if it isn't		end the loop
		 * 4. output the loser
		 */
		
		while (again) {
			
			//1. determine which player is playing
			turn = turn + 1;
			if (Dividable.isDividable(turn, 2)) {
				player = 2;
			} else {
				player = 1;
			} //End of if 'Dividable.isDividable(turn, 2)'
			
			//2. let the player input it's answer
			input = in.nextLine();
			
			//3. check if the answer is correct
			//3,1. if it is		go to step 1
			//3,2. if it isn't		end the loop
			answer = FB.getAnswer(turn-1);
			if (input.equals(answer)) {
				again = true;
			} else {
				again = false;
			} //End of if 'input.equals(answer)'
			
			//Stop before there are no answers left
			if (turn >= 100) {
				again = false;
			} //End of if 'turn >= 100'
			
		} //End of while 'again'
		
		if (turn < 100) {
			//4. output the loser
			System.out.println("Spieler " + player + " hat einen Fehler gemacht.");
			System.out.println("Er hat \"" + input + "\" eingegeben aber die richtige Antwort wäre \"" + answer + "\" gewesen");
		} else {
			System.out.println("Keiner hat einen Fehler gemacht.");
		} //End of if 'turn < 100'
		
	} //End of main-method
	
	//End of declaration of variables
	
} //End of class 'Game'