/*
Cole Johnson
CS 145 Assignment 1
5/26/23

this is the main class for assignment 1

it creates the wordSearch object, and gets the words the user wants to add to the word search.
it also prints the solutions by checking the identifier for each input in the 2d array.
(if the string starts with a '?' then its part of a solution and as such gets printed
but if the string starts with '#' the string does not get printed)

the size of the 2d word search is also variable, as every word added and the length of the longest
word are both treated as a multiplier. the default size is 10;
*/

import java.util.*;

public class wordSearchMain {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in); // creates scanner object
      Random r = new Random();
      
      boolean prevRun = false;
         
      wordSearchNode wordSearch = new wordSearchNode();
         
      ArrayList<String> words = new ArrayList<String>();
      
      // size multipliers
      int defaultSize = 10;
      int defualtMaxWordNum = 5; 
      double multi_1 = 1.5;
      double multi_2 = 1.1;
   
      // main while loop
      char userChar = 'a';
      while ((userChar != 'q') & (userChar != 'd')) {
         // main while loop loops until user ends it
         // the loop gets the users input and calls the corresponding method
         instructions();
         
         userChar = getUserChar(input); // gets new current user input
         
         switch (userChar) { // start of switch case
            // switch case is used to call the correct method after getting the user input
            case 'g':
               prevRun = true;
               // generate word search
               System.out.println("generating word search\n"); // prints more instructions
               System.out.println("enter the words you want to add tot he word search.");
               System.out.println("press space after writing each word, and enter (d) when done");
               // gets user input in a loop to get words to add to the word search
               words.clear();
               String userWord = "a";
               while (userWord.toLowerCase().equals("d") != true || words.size() == 0) {
                  userWord = input.next();
                  if (userWord.toLowerCase().equals("d") != true) {
                     words.add(userWord);
                  }
               } // end of while loop
               // prints the words to be added to the user
               System.out.println("the below will be added to the word search");
               for (String str: words) {
                  System.out.print(str + " ");
               } // end of for loop
               System.out.println("\ngenerating");
               wordSearch = new wordSearchNode(words, determineSize(words, defaultSize, 
                                                defualtMaxWordNum, multi_1, multi_2));
               System.out.println("word search generated\n");     
               break;
            case 'p':
               if (prevRun) {
                  // print the word search
                  System.out.println("printing word search\n");
                  print(wordSearch.getWordSearch());
               } else {
                  // word search has not been generated
                  System.out.println("please generate a word search first (g)\n");
               } // end of if else
               break;
            case 's':
               if (prevRun) {
                  System.out.println("showing solutions\n");
                  printSolution(wordSearch.getWordSearch());
               } else {
                  System.out.println("please generate a word search first (g)\n");
               } // end of if else
               break;
         } // end of switch case
      } // end of main while loop
      System.out.println("user ended program");
   } // end of main method


   public static void printSolution(String[][] arr) {
      // prints out the word search 2d array
      // it ONLY prints out the solutions (identifier ?) otherwise its a X
      int size = arr.length;
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            if (arr[i][j].charAt(0) == '?') { // checks for the solution identifier
               System.out.print(arr[i][j].charAt(1) + "  ");
            } else {
               System.out.print("_  ");
            } // end of if else logic
         } // end of nested for loop
         System.out.println();
      } // end of for loop
   } // end of printSolution method
   
   
   public static void print(String[][] arr) {
      // prints out the word search 2d array
      // remember that # and ? are identifiers and will NOT be printed
      int size = arr.length;
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            if (arr[i][j] == null) { // == null 
               System.out.print("X ");
            } else {
               System.out.print(arr[i][j].charAt(1) + " ");
            }
         } // end of nested for loop
         System.out.println();
      } // end of for loop
   } // end of print method
   

   public static int determineSize(ArrayList<String> words, int defaultSize, int defualtWordCount, 
                                    double multi_1, double multi_2) {
      // determines the nessesary size of the 2d word search array
      // makes an empty array with the size (multiplier) * Longest word
      int maxLength = 0; // size by default
      int wordNum = 0; // amount of words in the word search
      // gets the longest word length in the word list
      for (String w: words) {
         wordNum ++;
         if (w.length() > maxLength) {
            maxLength = w.length();
         } // gets the length of the longest word in the array list
      } // end of for each loop
      // checks if the maxLength * multi is bigger than the default size
      if ((int)(maxLength * multi_1) > defaultSize || wordNum > defualtWordCount) {
         return (int)((maxLength * multi_1) + (wordNum * multi_2)); // returns maxLength * multi if yes
      } else {
         return defaultSize; // else returns default size
      } // end of if else
   } // end of determineSize method
   
   
   public static char getUserChar(Scanner input) {
      // gets the user char input
      // that char is then used to decide what action the program will take
      char temp = 'a';
      boolean run = true;
      while (run) {
         temp = input.next().charAt(0);
         temp = Character.toLowerCase(temp);
         switch (temp) { // run the loop until user enters a valid char
            case 'g':
            case 'p':
            case 's':
            case 'q':
            case 'd': // d and q are both used to break the loop
               run = false; // if a correct char is found it breaks the loop
               break;
            default:
               System.out.println("ERROR: illegal char");
               break;
         } // end of switch case
      } // end of while loop
      return temp;
   } // end of getUserChar method
   
   
   public static void instructions() {
      // prints instructions
      System.out.println("Welcome to the word search generator.");
      System.out.println("This program allows you to generate your own word search puzzle.");
      System.out.println("Please select an option:");
      System.out.println("Generate a new word search (g)");
      System.out.println("Print out your word search (p)");
      System.out.println("Show the solutions to the word search (s)");
      System.out.println("Quit the program (q)");
   } // end of instructions method
} // end of class