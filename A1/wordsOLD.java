public class wordsOLD {
   private String str;
   private boolean reverse;
   private int slant;
   int x; // start and end x and y of the word vector
   int y;
   
   public word(String str, boolean reverse, int slant) {
      this.str = str;
      this.reverse = reverse;
      this.slant = slant;
   } // end of word constructor
   
   public int[] getLineData() {
      int[] temp = {x,y,getEndX(),getEndY()};
      return temp;
   }
   
   public int getEndX() {
      if (slant == 0) {
         return x += str.length() - 1;
      } else if (slant == 1) {
         return x += str.length() - 1;
      } else {
         return x;
      } // end of if else
   } // end of getEndX method
   
   public int getEndY() {
      if (slant == 2) {
         return y += str.length() - 1;
      } else if (slant == 1) {
         return y += str.length() - 1;
      } else {
         return y;
      } // end of if else
   } // end of getEndY method
   
   public char charAtPoint(int[] point) {
      int px = point[0]; // seperate x and y of the passed point
      int py = point[1];
      // return the char at a point on the word line
      String tempString = toString(); // is str with or without reverse
      if (slant == 0 || slant == 1) {
         // when slant is horizontal or slight you can use x to calculate
         int index = x + (px - x);
         return tempString.charAt(index);
      } else { // slant == 2 / when line is vertical
         // use y to calculate
         int index = y + (py - y);
         return tempString.charAt(index);
      } // end of if else slant check
   } // end of charAtPoint method

   public String toString() {
      if (reverse) {
         String tempStr = "";
         for (int i = str.length()-1; i >= 0; i--) {
            tempStr += str.charAt(i);
            //System.out.println(i-1);
            //System.out.println(str.charAt(i));
         } // end of for loop
         return tempStr;
      } else {
         return str;
      }
   } // end of toString method
   
   public String pureString() {
      // returns the str value without any reverse
      return str;
   } // end of pureString method

   public int slant() {
      return slant;
   }
   
   public void setSlant(int slant) {
      this.slant = slant;
   }
   
   public int squareLength(int mainSquareSize) {
      int temp = mainSquareSize - str.length() + 1;
      
      if (temp < 0) {
         temp = 0;
      }
      return temp;
   }


}