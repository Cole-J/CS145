import java.util.*;
//import java.lang.*;
//import java.io.*;
//import java.util.Scanner;
//import java.util.Random;

public class wordSearch {

   public static void main(String[] args) {
      // main method is used to get user input and enact on it
      
      Scanner input = new Scanner(System.in); // creates scanner object
      Random r = new Random();
      
      ArrayList<String> words = new ArrayList<String>(); // ceates a word arr
      words.add("abcdefghij");
      //words.add("aa");
      //words.add("ad");
      words.add("abcdef");

      
      
      //word w = new word("abcd",true,false);
      //System.out.println(w.toString());
      
      String[][] arr = {
      {"!a","!b"},
      {"?c","!d"}};
      
      //printSolution(arr);
      
      //System.out.println(words.get(0).length());
      //System.out.println(determineSize(words,10,2));
      
      String[][] a = generate(input, r, words, determineSize(words, 10, 1));
      print(a);
      
      
      
      char userChar = 'q';
      while ((userChar != 'q') & (userChar != 'd')) {
         // main while loop loops until user ends it
         // the loop gets the users input and calls the corresponding method
         instructions();
         
         userChar = getUserChar(input); // gets new current user input
         
         switch (userChar) { // start of switch case
            // switch case is used to call the correct method after getting the user input
            case 'g':
               break;
            case 'p':
               break;
            case 's':
               break;
         } // end of switch case
      } // end of main while loop
   } // end of main class
   
   public static ArrayList<String> getWords(Scanner input) {
      // creates an array list with the words the user wanted to include
      ArrayList<String> words = new ArrayList<String>(); // ceates a word arr
      System.out.println("Enter the words 1 by 1 and enter (q) when done.");
      String userInput = "";
      while (userInput != "q") {
         userInput = input.next();
         if (userInput != "q") {
            words.add(userInput);
         }
      } // end of while loop
      return words;
   } // end of getWords method
   
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
   
   public static void printSolution(String[][] arr) {
      // prints out the word search 2d array
      // it ONLY prints out the solutions (identifier ?) otherwise its a X
      int size = arr.length;
      for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
            if (arr[i][j].charAt(0) == '?') { // checks for the solution identifier
               System.out.print(arr[i][j].charAt(1) + " ");
            } else {
               System.out.print("X ");
            } // end of if else logic
         } // end of nested for loop
         System.out.println();
      } // end of for loop
   } // end of printSolution method
   
   public static int determineSize(ArrayList<String> words, int defaultSize, double multi) {
      // determines the nessesary size of the 2d word search array
      // makes an empty array with the size (multiplier) * Longest word
      int maxLength = 0; // size by default
      // gets the longest word length in the word list
      for (String w: words) {
         if (w.length() > maxLength) {
            maxLength = w.length();
         } // gets the length of the longest word in the array list
      } // end of for each loop
      // checks if the maxLength * multi is bigger than the default size
      if ((int)(maxLength * multi) > defaultSize) {
         return (int)(maxLength * multi); // returns maxLength * multi if yes
      } else {
         return defaultSize; // else returns default size
      } // end of if else
   } // end of determineSize method
   
   public static String[][] generate(Scanner input, Random r, ArrayList<String> words, int size) {
      
      // creates the 2d array with empty elements
      String wordSearchArr[][] = new String[size][size];
      
      // creates slant array
      int[] slantArr = {0, 1, 2};
      
      // creates word nodes in an array list
      ArrayList<word> wordList = new ArrayList<word>();
      for (String w: words) {
         word temp = new word(w, r.nextBoolean(), 0); // sets slant to 0 for now
         wordList.add(temp);         
      } // end of for loop used to create the nodes based off the passed words array
      
      int wordsAdded = 0; // counts the number of words added to the word search
      for (word w: wordList) { // loops through every word being added to the word search
         slantArr = shuffleArray(r, slantArr);
         w.setSlant(slantArr[0]);
         int currentSlantIndex = 0;
      
         // the words are added and calculated by turning the words into lines.
         // they have a start and end point, and a length of the length of the string
         
         // creates a list of the possible points that the word line / path can be added to
         ArrayList<int[]> pointList = new ArrayList<int[]>();
         for (int i = 0; i < w.squareLength(size); i++) {
            for (int j = 0; j < w.squareLength(size); j++) {
               int[] tempPoint = {i,j};
               pointList.add(tempPoint);
            } // end of nested for loop
         } // end of for loop
         // shuffle list
         Collections.shuffle(pointList);
         
         /*for (int i = 0; i < pointList.size(); i++) { // prints the list for testing remove later ////////////
            System.out.print(Arrays.toString(pointList.get(i)) + " ");
         }*/
         
         // now we have a list of the possible points the word could start at in the 2d word search
         System.out.println("pos arr size " + pointList.size() + " for " + w.pureString());
         for (int i = 0; i < pointList.size(); i++) { // loops through every possible point
         
            w.x = pointList.get(i)[0]; // gets the current rng point
            w.y = pointList.get(i)[1];
         
            if (wordsAdded == 0) {
               // checks for the first word being added as no other checks are nessecary
               // the word will be added to the first point in the shuffle possible point list
               wordSearchArr = addWordToWordSearch(wordSearchArr, w);   
               wordsAdded ++;
               //System.out.println("pri x y " + w.x + " " + w.y + " str " + w.pureString());
               //System.out.println("L " + w.toString().length() +  " s " + w.slant());
               //System.out.println("end " + w.getEndX() + " " + w.getEndY());
               break;
            } else {
               // it is not the first word it will check for collisions
               // get current line data
               int[] lineData = w.getLineData(); // gets line data in format x1, y1, x2, y2
               boolean collides = false; // by defualt lines do not collide
               // determines the line / path of the word in the 2d array
               // for loop to check if that line collides with any other previous lines
               for (int j = 0; j < wordsAdded; j++) { // loops through previous words
                  // gets the previous words line data
                  int[] prevLineData = wordList.get(j).getLineData();
                  // checks for intercept
                  int[] intercept = intercept(lineData, prevLineData);
                  if (intercept != null) { // if the lines collide (returns null if they do not)
                     // gets the char at the collision
                     //System.out.println("gen1");
                     //System.out.println(w.pureString());
                     //System.out.println("pri x y " + w.x + " " + w.y + " str " + w.pureString());
                     //System.out.println("L " + w.toString().length() +  " s " + w.slant());
                     //System.out.println("end " + w.getEndX() + " " + w.getEndY());
                     //System.out.println("int x y " + intercept[0] + " " + intercept[1]);
                     //System.out.println(w.slant());
                     //System.out.println("curr");
                     char currentLineChar = w.charAtPoint(intercept);
                     //System.out.println("past");
                     char prevLineChar = wordList.get(j).charAtPoint(intercept);
                     if (currentLineChar != prevLineChar) {
                        collides = true; // if the chars are not equal at the collision
                        // the word is NOT added and the next rng point is pulled
                     } // end of nested if char check
                  } // end of if intercept check
               } // end of collision check nested for loop
               
            
               if (collides == false) {
                  // word line does not collide with any prev lines, or if it does its at the same char
                  // word is added
                  wordSearchArr = addWordToWordSearch(wordSearchArr, w);   
                  //System.out.println("pri x y " + w.x + " " + w.y + " str " + w.pureString());
                  //System.out.println("L " + w.toString().length() +  " s " + w.slant());
                  //System.out.println("end " + w.getEndX() + " " + w.getEndY());
                  wordsAdded ++;
                  System.out.println("attempts (i)" + i);
                  break;
               } // end of if word collides check
            } // end of if else word can be added check
            
            if (i == pointList.size() - 1) {
               if (w.slant() != slantArr[2]) {
                  currentSlantIndex ++;
                  w.setSlant(slantArr[currentSlantIndex]);
                  System.out.println("called");
               } else {
                  System.out.println(w.pureString() + " could not be added");
               }
            }
         
         
         } // end of point list for loop
         

         
         
         
      } // end of for each word loop
      return wordSearchArr;
   } // end of generate method
   

   
   public static void p(int[][][] posArr) {
            for (int i = 0; i < posArr.length; i++) {
            for (int j = 0; j < posArr.length; j++) {
               System.out.print(Arrays.toString(posArr[i][j]) + " ");
            }
            System.out.println();
         }
   }
   
   
   
   public static int[] intercept(int[] lineData1, int[] lineData2) {
      int x1 = lineData1[0]; int y1 = lineData1[1];
      int x2 = lineData1[2]; int y2 = lineData1[3];
      int x3 = lineData2[0]; int y3 = lineData2[1];
      int x4 = lineData2[2]; int y4 = lineData2[3];

      int[] interceptPoint = new int[2];
      int determinant = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

      if (determinant == 0) {
         // Lines are parallel, no intersection
         return null;
      } else {
         int x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / determinant;
         int y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / determinant;

         interceptPoint[0] = x;
         interceptPoint[1] = y;
         return interceptPoint;
      }
   }
   
   
   
   
   
   public static String[][] addWordToWordSearch(String[][] arr, word w) {
      // adds word to word search based off the words x and y
      for (int i = 0; i < w.toString().length(); i++) { // loops for every char in the word
         if (w.slant() == 0) {
         System.out.println(w.toString().charAt(i));
            arr[w.x + i][w.y] = "?" + w.toString().charAt(i);
         //wordSearchArr;
         } else if (w.slant() == 1) {
         //System.out.println(w.toString().charAt(i));
            arr[w.x + i][w.y + i] = "?" + w.toString().charAt(i);
         } else { // w.slant() == 2
            //System.out.println(w.toString().charAt(i));
            arr[w.x][w.y + i] = "?" + w.toString().charAt(i);
         } // end of if else slant check
      } // end of for loop
      System.out.println(w.pureString() + " added");
      return arr;
   } // end of addWordToWordSearch method
   
   public static int[][][] shuffle(Random r, int[][][] arr) {
      // shuffles a 2d array with the value being another array / shuffles the location of the
      // points in the array without changing the value of the point
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr.length; j++) { // remember its a square array so lengths are equal
         int newi = r.nextInt(arr.length);
         int newj = r.nextInt(arr.length);
         int[] temp = arr[i][j]; // stores old point
         arr[i][j] = arr[newi][newj];
         arr[newi][newj] = temp;
         } // end of nested for loop
      } // end of for loop
      return arr;
   }
   
   public static int[] shuffleArray(Random r, int[] arr) {
      for (int i = 0; i < arr.length; i++) {
	      int randomIndexToSwap = r.nextInt(arr.length);
         
			int temp = arr[randomIndexToSwap];
			arr[randomIndexToSwap] = arr[i];
			arr[i] = temp;
		} // end of for loop
      return arr;
   }

   public static ArrayList<int[]> shuffleList(Random r, ArrayList<int[]> list) {
      for (int i = 0; i < list.size(); i++) {
         int newi = r.nextInt(list.size());
         
         int[] temp = list.get(i);
         list.set(newi, list.get(i));
         list.set(i, temp);
      }
      return list;
   }
   
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
               System.out.println("ERROR: illegal char"); /////////////////////////////////////////////////////////////////////////////////
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

} // end of wordSearch class