/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: (Give a brief description for each Class)
 * Due: 2/28/2021
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Bradley Hughes
*/

import java.util.Scanner; //needed for scanner

public class RandomNumberGenerator {

	public static void main(String[] args) {
		
		int lowGuess = 0; //Sets value for lowGuess
		int highGuess = 100; //Sets value for highGuess
		
		RNG myRNG = new RNG();  //Creates a new class

		//Create a Scanner object for keyboard input.
		Scanner userInput = new Scanner(System.in);

		int randNum = RNG.rand(); //gets random number and assigns it to randNum
		
		System.out.println("Enter your first guess"); //Tells user to enter first number
		
		RNG.resetCount(); //Sets count to 0
		
		int x = userInput.nextInt(); //Sets x to value of user input
		int nextGuess = x; //Sets nextGuess as x's value
		 //calls inputValidation to see if the number is bigger than the highGuess or smaller than the lowGuess and increments the guess count
		RNG.inputValidation(nextGuess, lowGuess, highGuess);
		
		while (x != randNum){ //while the number does not equal the random number generated
			if(x < highGuess && x > randNum ){ //If number is inbetween the randNum and highGuess
				System.out.println("Number of guesses is " + RNG.getCount()); //Prints the number of guesses
				System.out.println("Your guess is too high"); //Informs user that the number is too high
				highGuess = x; //sets the input as the new highGuess
				System.out.println("Enter your next guess between " +lowGuess+ " and " +highGuess); //Shows the new value for highGuess
				x=userInput.nextInt(); //sets new user input to x
				nextGuess = x; //sets nextGuess to the new user input
				RNG.inputValidation (nextGuess, lowGuess, highGuess); //puts new guess into inputValidation
			}
			else if(x > lowGuess && x < randNum){ //If number is inbetween the randNum and lowGuess
				System.out.println("Number of guesses is " + RNG.getCount()); //Prints the number of guesses
				System.out.println("Your guess is too low"); //Informs user that the number is too low
				lowGuess = x; //sets the input as the new lowGuess
				System.out.println("Enter your next guess between " +lowGuess+ " and " +highGuess); //Shows the new value for lowGuess
				x=userInput.nextInt(); //sets new user input to x
				nextGuess = x; //sets nextGuess to the new user input
				RNG.inputValidation (nextGuess, lowGuess, highGuess); //puts new guess into inputValidation
			}
			else{ //If guess is not inbetween lowGuess and highGuess, the count is not incremented
				x=userInput.nextInt(); //sets new user input to x
				nextGuess = x; //sets nextGuess to the new user input
			}
		}
				
		if(x == randNum){ //if random number is guessed correctly
			System.out.println("Number of guesses is " + RNG.getCount());
			System.out.println("Congratulations, You guessed correctly"); //Displays congratulations message
			System.out.println("Try again? (yes or no)"); //Asks user if they want to try again
		}
		
		userInput.nextLine(); //Get user input
		String tryAgain = userInput.nextLine(); //Set user input to tryAgain

		while (tryAgain.equals("yes")){	//Repeats almost every previous step while tryAgain is "yes"	
			
			RNG.resetCount(); //resets count to 0
			
			lowGuess = 0; //resets lowGuess to 0
			highGuess = 100; //resets highGuess to 100

			randNum = RNG.rand(); //gets a new random number and assigns it to randNum
				
			System.out.println("Enter your first guess");
				
			x = userInput.nextInt();
			nextGuess = x;
			RNG.inputValidation(nextGuess, lowGuess, highGuess);
			
			while (x != randNum){
				if(x < highGuess && x > randNum){
					System.out.println("Number of guesses is " + RNG.getCount()); //Prints the number of guesses
					System.out.println("Your guess is too high");
					highGuess = x;
					System.out.println("Enter your next guess between " +lowGuess+ " and " +highGuess);
					x=userInput.nextInt(); //sets new user input to x
					nextGuess = x; //sets nextGuess to the new user input
					RNG.inputValidation (nextGuess, lowGuess, highGuess); //puts new guess into inputValidation
				}
				else if(x > lowGuess && x < randNum){
					System.out.println("Number of guesses is " + RNG.getCount()); //Prints the number of guesses
					System.out.println("Your guess is too low");
					lowGuess = x;
					System.out.println("Enter your next guess between " +lowGuess+ " and " +highGuess);					
					x=userInput.nextInt(); //sets new user input to x
					nextGuess = x; //sets nextGuess to the new user input
					RNG.inputValidation (nextGuess, lowGuess, highGuess); //puts new guess into inputValidation
				}
				else{
					x=userInput.nextInt(); //sets new user input to x
					nextGuess = x; //sets nextGuess to the new user input
				}		
			}
			if(x == randNum){
				System.out.println("Number of guesses is " + RNG.getCount());
				System.out.println("Congratulations, You guessed correctly");
				System.out.println("Try again? (yes or no)");
			}
			userInput.nextLine();
			tryAgain = userInput.nextLine();
		}
		System.out.println("Thanks for playing..."); //Display end message
		System.out.println("Programmer name: Bradley Hughes"); //Prints programmers name
		userInput.close(); //Closes user input
	}
}