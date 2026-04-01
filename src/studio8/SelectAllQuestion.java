package studio8;

import org.junit.platform.suite.api.Select;

import support.cse131.NotYetImplementedException;

public class SelectAllQuestion extends MultipleChoiceQuestion {

	/**
	 * Constructor
	 * 
	 * @param prompt
	 * @param answer
	 * @param choices
	 */
	public SelectAllQuestion(String prompt, String answer, String[] choices) {
		// Hint: 1 point per choice
		super(prompt, answer, choices.length, choices);
	}
	
	/**
	 * Returns the amount of points scored by a provided givenAnswer
	 * @param String givenAnswer to check for points
	 */
	public int checkAnswer(String givenAnswer) {
		return (this.getChoices().length - this.findMissingCorrectAnswers(givenAnswer) - this.findIncorrectGivenAnswers(givenAnswer));
	}

	/**
	 * Count the amount of correct answers that are not in the provided givenAnswer
	 * @param givenAnswer
	 * @return int amount of missed correct answers
	 */
	private int findMissingCorrectAnswers(String givenAnswer) {
		String answer = this.getAnswer();
		//how many letters are in the correct answer but not the given answer?
		int incorrectValues = findMissingCharacters(givenAnswer, answer);
		return incorrectValues;
	}
	
	/**
	 * Count the amount of present answers that are not correct
	 * @param givenAnswer
	 * @return int amount of incorrect answers
	 */
	private int findIncorrectGivenAnswers(String givenAnswer) {
		String answer = this.getAnswer();
		//how many letters are in the given answer but not the correct answer?
		int incorrectValues = findMissingCharacters(answer, givenAnswer);
		return incorrectValues;
	}

	/**
	 * Returns the number of characters in toCheck that are missing from the
	 * baseString. For example findMissingValues("hi", "hoi") would return 1,
	 * 'o' is not in the baseString.
	 * 
	 * This method is marked static as it does not depend upon any instance variables
	 */
	private static int findMissingCharacters(String baseString, String toCheck) {
		int missingValues = 0;
		for(int i = 0; i < toCheck.length(); i++) {
			char characterToLocate = toCheck.charAt(i);
			if(baseString.indexOf(characterToLocate) == -1) { //not in baseString
				missingValues++;
			}
		}
		return missingValues;
	}	
	
	public static void main(String[] args) {	
		String[] options = {"Number of sides in a triangle", "1 + 2", "The integral of 3/2 from 0 to 2", "The number of prongs in an outlet"};
		SelectAllQuestion q3 = new SelectAllQuestion("Which of the following values is equal to 3?", "1234", args);
	}
}
