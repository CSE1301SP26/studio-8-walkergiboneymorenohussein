package studio8;

import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class Quiz {
	private Question[] questions;
	/**
	 * Constructor
	 * @param questions
	 */
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	/**
	 * Prompts the user to answer, then returns a String containing their answer.
	 * @param in
	 * @return String answer
	 */
	private String getUserAnswer(Scanner in) {
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	/**
	 * Gets the number of points possible in the quiz.
	 * @return int number of total points
	 */
	public int getTotalPoints() {
		int totalPoints = 0;
		for (int i = 0; i < questions.length; i++) {
			totalPoints += questions[i].getPoints();
		}
		return totalPoints;
	}
	
	/**
	 * Asks the user all question in the quiz, then prints out 
	 * the amount of points the user earned. This print statement
	 * should include "You earned ____ points"
	 * 
	 * @param in Scanner object to feed into getUserAnswer
	 */
	public void takeQuiz(Scanner in) {
		int currentScore = 0;
		for (int i = 0; i < questions.length; i++) {
			questions[i].displayPrompt();
			currentScore += questions[i].checkAnswer(getUserAnswer(in));
		}
		System.out.println("You earned " + currentScore + " points.");
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Question q1 = new Question("Is the sky blue", "Yes", 1);

		String [] answers = {"The number of stars in out solar system", "The number of hydrogen atoms in a water molecule", "3", "Your GPA"};
		MultipleChoiceQuestion q2 = new MultipleChoiceQuestion("Which number is the largest?", "3", 1, answers);

		String[] options = {"Number of sides in a triangle", "1 + 2", "The integral of 3/2 from 0 to 2", "The number of prongs in an outlet"};
		SelectAllQuestion q3 = new SelectAllQuestion("Which of the following values is equal to 3?", "1234", options);

		Question[] quiz1 = {q1, q2, q3};
		Quiz quiz = new Quiz(quiz1);
		quiz.takeQuiz(in);
	}
}
