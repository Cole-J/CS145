/*
Cole Johnson
CS 145 Assignment 1
5/26/23

this is the word class for assignment 1

the main things in this class are the methods to construct a new word object, along with the others
which can get the numerous attributes to the word.

each word object has a string value but also 2 x y points. those 2 x y points create the 'line'
(or path) on the 2d word search which the string then sits on.
*/
public class word {
   private String str; // the word string
   private boolean reverse; // if the word will be reverse
   private int slant; // the slant of the word
   int x; // start and end x and y of the word line
   int y; // x and y are not private so that they are accessible by the word search class
  
   public word(String str, boolean reverse, int slant) {
      this.str = str;
      this.reverse = reverse;
      this.slant = slant;
   } // end of word constructor
   
   public char charAtPoint(int[] point) {
      // gets the char at a given point on the words line
      int px = point[0]; // seperate x and y of the passed point
      int py = point[1];
      // return the char at a point on the word line
      String tempString = toString(); // is str with or without reverse
      if (slant == 0 || slant == 1) {
         // when slant is horizontal or slight you can use x to calculate
         int index = px-x;
         return tempString.charAt(index);
      } else { // slant == 2 / when line is vertical
         // use y to calculate
         int index = py-y;
         return tempString.charAt(index);
      } // end of if else slant check
   } // end of charAtPoint method
   
   public int[] getLineData() {
      // gets the 2 points needed to make the line and returns them
      int[] temp = {x,y,getEndX(),getEndY()};
      return temp;
   }
   
   public int getEndX() {
      // gets the end x value of the line
      if (slant == 0) {
         int t = x + str.length() - 1;
         return t;
      } else if (slant == 1) {
         int t = x + str.length() - 1;
         return t;
      } else {
         int t = x;
         return t;
      } // end of if else
   } // end of getEndX method
   
   public int getEndY() {
      // gets the end y value of the line
      if (slant == 2) {
         int t = y + str.length() - 1;
         return t;
      } else if (slant == 1) {
         int t = y + str.length() - 1;
         return t;
      } else {
         int t = y;
         return t;
      } // end of if else
   } // end of getEndY method
   
   public int squareLength(int mainSquareSize) {
      // returns the length of the square that a line with the length of the word could fit into
      // used to find where the word line can fit into the 2d array
      int temp = mainSquareSize - str.length() + 1;
      if (temp < 0) {
         temp = 0;
      }
      return temp;
   } // end of squareLength method
   
   public String toString() {
      // returns a normal or reverse version of the str based off the reverse bool
      if (reverse) {
         String tempStr = "";
         for (int i = str.length()-1; i >= 0; i--) {
            tempStr += str.charAt(i);
         } // end of for loop
         return tempStr;
      } else {
         return str;
      } // end of if else
   } // end of toString method
   
   
   public String pureString() {
      return str;
   }
   public int slant() {
      return slant;
   }
   public void setSlant(int slant) {
      this.slant = slant;
   }


} // end of word class