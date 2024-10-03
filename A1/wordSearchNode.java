/*
Cole Johnson
CS 145 Assignment 1
5/26/23

this is the word search class for assignment 1

the main things in this class are the constructors which create a new word search, a method to fill
the word search with 'junk' letters, one to determine a valid point to add a word to the word
search, another to add the word, and a few other to do things like finding an intercept between
lines or to shuffle needed arrays / lists.
*/

import java.util.*;

public class wordSearchNode {

   Random r = new Random();

   private int size;
   private ArrayList<String> wordList;
   
   private String[][] wordSearchArr;
   
   public wordSearchNode() {} // no param constructor

   public wordSearchNode(ArrayList<String> wordList, int size) {
      this.wordList = wordList;
      this.size = size;
      this.wordSearchArr = new String[size][size];
      this.wordSearchArr = fillWordSearch(wordSearchArr);
      this.wordSearchArr = addSolutions(wordSearchArr, wordList);
   } // end of constructor
   
   
   public String[][] fillWordSearch(String[][] arr) {
      // fills the array with random chars
      // some of those chars will later be removed to add the solutions
      for (int i = 0; i < arr.length; i ++) {
         for (int j = 0; j < arr.length; j++) {
            arr[i][j] = "#" + (char)(r.nextInt(26) + 'a');
         } // end of nested for loop
      } //end of for loop
      return arr;
   } // end of fillWordSearch method
   
   public String[][] addSolutions(String[][] wordSearchArr, ArrayList<String> words) {
      // adds the solutions to the word search array
      // creates slant array
      int[] slantArr = {0, 1, 2}; // this will later be shuffled
      // creates word nodes in an array list
      ArrayList<word> wordList = new ArrayList<word>();
      for (String w: words) {
         word temp = new word(w, r.nextBoolean(), 0); // sets slant to 0 for now
         wordList.add(temp);         
      } // end of for loop used to create the nodes based off the passed words array
      
      int wordsAdded = 0; // counts the number of words added to the word search
      
      // ====== FOR EACH WORD ======
      
      for (word w: wordList) { // loops through every word being added to the word search
         System.out.println("adding " + w.pureString());
         // creates a slant array for the word
         
         slantArr = shuffleArray(r, slantArr); // shuffles the slant array to get random slants
         
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
         
         // ====== FOR EVERY POSSIBLE POINT ======
         
         for (int p = 0; p < pointList.size(); p++) {
            w.y = pointList.get(p)[1]; // sets x and y to rng point
            w.x = pointList.get(p)[0];
            
            // ====== FOR EACH SLANT ======
            
            for (int s = 0; s < slantArr.length; s ++) { 
               // attempts to add the word with each slant
               w.setSlant(slantArr[s]);

               // this for loop runs through all possible slants for each word
               // and has a shuffled list of the possible points the words line can be added to
               // while still being within the 2d word search array

               if (wordsAdded == 0) { // checks for the first word as no other checks are needed
                  wordSearchArr = addWordToWordSearch(wordSearchArr, w);

                  wordsAdded++;
                  p = pointList.size(); // breaks both for loops to get back to for each word loop
                  break;
               } // end of if first word added check
               // code gets to this point if its not the first word added
               
               // need to check if the new rng word line will collide with any of the previous ones
               int[] lineData = w.getLineData();
               boolean collides = false; // by defualt lines do not collide
               // determines the line / path of the word in the 2d array
               // for loop to check if that line collides with any other previous lines

               for (int j = 0; j < wordsAdded; j++) { // loops through previous words
                  // gets the previous lines data
                  int[] prevLineData = wordList.get(j).getLineData();
                  // checks for intercept
                  int[] intercept = intercept(lineData, prevLineData);
                  if (intercept != null) {
                     // if intercept is null they the lines do not collide
                        collides = true;
                  } // end of if collide
               } // end of for loop for each previous word added
               
               if (collides != true) {
                  // new word line does not collide with any others unless its at the same char
                  wordSearchArr = addWordToWordSearch(wordSearchArr, w);

                  wordsAdded++;
                  p = pointList.size(); // breaks both for loops to get back to for each word loop
                  break;
               } // else try a new slant, then try a new point
            } // end of for each slant for loop
         } // end of for every point in pointList
      } // end of for each word for loop
      return wordSearchArr;
   } // end of addSolutions method
   
   
   public static String[][] addWordToWordSearch(String[][] arr, word w) {

      for (int i = 0; i < w.toString().length(); i++) { // loops for every char in the word
         
         if (w.slant() == 0) {
            arr[w.x + i][w.y] = "?" + w.toString().charAt(i);
            
         } else if (w.slant() == 1) {
            arr[w.x + i][w.y + i] = "?" + w.toString().charAt(i);
            
         } else { // w.slant() == 2
            arr[w.x][w.y + i] = "?" + w.toString().charAt(i);
            
         } // end of if else slant check
      } // end of for loop
      //System.out.println(w.pureString() + " added"); // remove comment for ui update
      return arr;
   } // end of addWordToWordSearch method
   
   public static int[] intercept(int[] lineData1, int[] lineData2) {
      // checks if two lines intercept
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
      } // end of if else
   } // end of intercept method
   
   
   public static int[] shuffleArray(Random r, int[] arr) {
      // basic shuffling algorithm
      for (int i = 0; i < arr.length; i++) {
	      int randomIndexToSwap = r.nextInt(arr.length);
			int temp = arr[randomIndexToSwap];
			arr[randomIndexToSwap] = arr[i];
			arr[i] = temp;
		} // end of for loop
      return arr;
   } // end of shuffleArray method
   
   
   public String[][] getWordSearch() {
      return wordSearchArr;
   }
} // end of class