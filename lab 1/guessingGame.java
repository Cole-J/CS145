/*
Cole Johnson
4/5/23
lab 1 guessing game

this program plays a guessing game with the user.
it does this by starting a loop in the main method, which then calls the
runRound method to play 1 round of the game with the user. it then returns
the number of guesses to the main method. the main method then adds 1 to the 
game counted, and adds the number of retuned guesses to the total guesses and
checks if the retuned guesses are lower than the lowest guesses (if it is then 
it saves the round guesses as the lowest guesses).
the game then asks the user if they want to play again, letting the loop continue
if the user responds with a 'y', if not ('n') it breaks the loop.
when the loop is exited it calls the report method with the parameters of the total
number of games, guesses, and the lowest number of guesses.

*/ // imports
import java.util.*; // imports for the scanner and random

class guessingGame { // start of class
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in); // creates scanner object
      int maxValue = 100; // the max guessing value / 0 - max
      int totalGuesses = 0, totalGames = 0, lowestGame = 0, roundGuesses = 0; // defines variables
      boolean runCompleteRound = true; // bool that helps with catching errors
      
      instruction(maxValue); // prints the instructions to the console
      
      while (true) { // start of main game loop
         if (runCompleteRound) { // plays 1 game with user
            roundGuesses = runRound(maxValue); // gets guesses in the round
            totalGuesses += roundGuesses; // adds round guesses to get the total guesses
            totalGames ++; // gets the total games played
         }
         if (totalGames == 1) { // checks for first run of the loop
            lowestGame = totalGuesses;
         } else {
            if (lowestGame > roundGuesses) {
               lowestGame = roundGuesses;
            }
         } // logic to get the lowest round guesses
         System.out.print("Do you want to play again? ");
         String userInput = input.next(); // gets user input / if user wants to play again
         userInput = userInput.toLowerCase();
         runCompleteRound = true;
         if (userInput.charAt(0) == 'y') { // checks user input
            System.out.print("\n");
            continue; // continues to next loop if yes
         } else if (userInput.charAt(0) == 'n') {
            break; // breaks game loop if no
         } else {
            runCompleteRound = false; // if invalid input
            // skips to the next game round without calling the runRound method
            System.out.println("invalid input\n");
         } // end of user input if logic
      } // main game loop
      report(totalGames, totalGuesses, lowestGame);
   } // end of main method
   
   
   public static int runRound(int upperBound) {
      Random rand = new Random(); // creates random object
      Scanner input = new Scanner(System.in); // creates scanner object
      int guesses = 1;
      int randNum = rand.nextInt(upperBound+1); // gets numbers from 0 to upperBound
      System.out.println("I'm thinking of a number between 1 and " + upperBound +"...");
    
      //System.out.println("randNum: " + randNum); // remove
   
      while (true) { // loops until user guesses the correct value
         System.out.print("Your guess? ");
         int userInput = input.nextInt(); // gets user input
         if (userInput > randNum) {
            // if user guesses high
            System.out.println("It's lower.");
         } else if (userInput < randNum) {
            // if user guesses low
            System.out.println("It's higher.");
         } else {
            // if user guesses randNum
            break;
         } // end of high low logic
         guesses ++;
      } // end of round while loop
      
      if (guesses == 1) { // end of round report
         System.out.println("Nice job, you got it right in 1 guess");
      } else {
         System.out.println("You got it right in " + guesses +" guesses");
      }
      return guesses;
   } // end of runRound method
   
   
   public static void report(double totalGames, double totalGuesses, int bestGame) {
      // prints the report at the end of the game
      // takes params as doubles to do math with them, then converts them to ints when printed
      System.out.println("\ntotal games   = " + (int)totalGames);
      System.out.println("total guesses = " + (int)totalGuesses);
      System.out.println("guesses/games = " + totalGuesses/totalGames);
      System.out.println("best game     = " + bestGame);
   } // end of report method
   
   
   public static void instruction(int upperBound) {
      // prints the instructions for the game
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(upperBound + " and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.\n");
   } // end of instruction method
} // end of class