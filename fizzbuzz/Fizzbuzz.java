/**
 * @author	Raffael Gyr
 * @version	1.0
 * @date	04.08.2017 (dd.mm.yyyy)
 * 
 * contains the game fizzbuzz
 */
package fizzbuzz;

import java.util.Vector;

/**
 * used for the 'isDividable' method
 */
import basics.Dividable;

/**
 * @author	Raffael Gyr
 * @version	1.0
 * @date	04.08.2017 (dd.mm.yyyy)
 * 
 * saves the correct Strings in a String[] 
 */
public class Fizzbuzz {
	
	//Start of the declaration of variables
	
	private Vector<String> answers;
	
	//End of the declaration of variables
	
	//Start of the declaration of methods
	
	/**
	 * Standard constructor
	 * Fills the Vector<String> answers with the correct Strings
	 */
	public Fizzbuzz() {
		answers = new Vector<String>(100);
		
		for (int number = 0; number < 100; number++) {
			String temp = "";
			
			/*
			 * In case the number should be dividable through either 3 OR 5,
			 * the respective if statement gets executed and either 'Fizz' or 'Buzz' gets set as the String.
			 * 
			 * In case the number should be dividable through both 3 AND 5 both will be executed
			 * and both 'Fizz' and 'Buzz' get added to an empty String
			 * 
			 * In case the number should be dividable through neither 3 NOR 5 the last if statement will be
			 * executed and the number gets written into the String
			*/
			
			if (Dividable.isDividable(number + 1, 3)) {
				temp = temp + "Fizz";
			} //End of if statement 'is $number dividable through 3?'
			
			if (Dividable.isDividable(number + 1, 5)) {
				temp = temp + "Buzz";
			} //End of if statement 'is $number dividable through 5?'
			
			if (temp == "") {
				Integer tempNumber = new Integer(number + 1);
				temp = tempNumber.toString();
			} //End of if statement 'is String empty?'
			
			answers.add(number, temp);
		} //End of for loop
		
	} //End of constructor 'Fizzbuzz()'
	
	/**
	 * Returns the Answer needed as a String
	 * 
	 * @param index		int		the position of the string that should be returned
	 * @return			String	returns the String needed
	 */
	public String getAnswer(int index) {
		return answers.get(index);
	} //End of getter-method 'getAnswer(int):String'
	
	/**
	 * Returns the Vector<String>
	 * 
	 * @return			Vector<String>	returns the Vector<String>
	 */
	public Vector<String> getAnswers() {
		return answers;
	} //End of getter-method 'getAnswers()'
	
	//End of the declaration of methods
	
	//testing purposes
	
	public static void main(String[] args) {
		Fizzbuzz testObj = new Fizzbuzz();
		int number = 0;
		
		System.out.println("index" + "\t" + "number" + "\t" + "output");
		System.out.println("-------------------------");
		
		for (int testInt = 0; testInt < testObj.getAnswers().size(); testInt++) {
			number = testInt + 1;
			System.out.println(testInt + "\t" + number + "\t" + testObj.getAnswer(testInt));
		}
	}
	
	//testing purposes
	
} //End of class 'Fizzbuzz'