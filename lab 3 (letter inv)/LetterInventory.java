/*
Cole Johnson and Jake M
5/8/23
CS 145 lab 3 LetterInventory

we split the workload by each doing some of the methods. 
I (Cole) then went back to add comments and to make the methods more uniform

this program creates a LetterInventory which can store the number of each letter present in
a given string. It also allows the user to get the size / number of letter in the string, 
set the amount of an individual letter in the string, and add or subtract strings from
the main string.

the class constants are,

int[] countArr, an array which holds the amount of each letter present in a string.
int size, is the sum of countArr.

the methods included are,

LetterInventory, a constructor which creates the countArr based off a passed string param.
get, returns the amount of times a specific char appears in the string by getting its count.
set, sets the amount of times a specific char appears in the string by setting its count.
size, returns the size class constant.
isEmpty, checks if the sum of countArr is 0, returns true if so and false if not.
recheckSize, rechecks the size / sum of countArr so that size can be a 'fast' method.
toString, returns a string comprised of the number of letters in countArr in order from a to z.
add, adds the value of one inventory to another and returns the new inventory.
subtract, subtracts the value of one inventory from another and returns the new inventory.
getCountArr, gets the countArr of a given inventory
*/
public class LetterInventory {


   // class const
   private int[] countArr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
   // indexes represent specific letters a to z
   private int size = 0;
   // is the size / sum of the array


   public LetterInventory(String data) {
      // constructor for LetterInventory
      // creates the array countArr which stores the amount of a specific letter in the string
      data = data.toLowerCase();
      for(int i = 0; i < data.length(); i++) { // loops through all the chars in the string
         char currentChar = data.charAt(i); // gets the current char in the string
         if ((currentChar - 'a') <= 25 & (currentChar - 'a') >= 0) {
            // if checks that the index is within range which excludes non letter chars
            countArr[currentChar - 'a'] ++;
         }
         // gets the distance the currentChar is away from 'a' which is proportional to its index
         // it then adds 1 to its index
      } // end of for loop
      recheckSize(); // rechecks the size of countArr
   } // constructor
   
   
   public int get(char letter) {
      // gets the amount of a letter in the string by getting the index from countArr
      letter = Character.toLowerCase(letter);
      int index = (int)(letter - 'a'); // gets what index the char would be in the countArr
      if (index <= 25 & index >= 0) { 
         // if checks that its within range which excludes non-alphabetic char
         return countArr[index]; // returns the amount stored in countArr if its a letter
      } else { // if index 
         throw new IllegalArgumentException("non-alphabetic character passed");
      } // end of if else index check
   } // end of get method
   

   public void set(char letter, int value) {
      // sets the amount of a letter in countArr
      letter = Character.toLowerCase(letter);
      int index = (int)(letter - 'a');
      if (index <= 25 & index >= 0) {
         // if checks that its within range which excludes non-alphabetic char
         countArr[index] = value;
      } else {
         throw new IllegalArgumentException("non-alphabetic character passed");
      } // end of if else index check
      recheckSize(); // rechecks the size of countArr
   } // end of set method
   
   
   public int size() {
      //return the sum of countArr
      return size;
   } // end of size method


   public boolean isEmpty() {
      // returns true if size is 0 and false if not
      // if the size is 0 then every count must be 0
      if (size == 0) {
         return true;
      } else {
         return false;
      } // end of if else
   } // end of isEmpty method


   public void recheckSize(){
      this.size = 0; // resets the size
      for(int i = 0; i<26; i++){
         this.size += countArr[i]; // gets the sum of countArr
      }//end of for loop 
   }//end of recheckSize method
   
   
   public String toString() {
      // returns a string of the 
      String str = "["; // defines a string that will later be returned
      for (int i = 0; i < 26; i ++) {
         // loops through each letter
         for (int j = 0; j < countArr[i]; j ++) {
            // loops for the number of the specific char in countArr
            str += (char)('a' + i); // gets the current char and adds it to the string
         } // prints letters
      } // end of letter for loop
      str += "]";
      return str;
   } // end of toString method
   
   
   public LetterInventory add(LetterInventory other) {
      // adds 2 inventorys and returns the new inventory
      int[] newCountArr = other.getCountArr(); // gets the countArr of the other inventory
      int sum;
      char currentChar;
      // defines the new inventory with an empty count
      LetterInventory returnInv = new LetterInventory("");
      for (int i = 0; i < 26; i ++) { // loops through each letter
         sum = countArr[i] + newCountArr[i]; // gets the sum (always positive)
         currentChar = (char)('a' + i); // gets the current char 'i' should be on
         // uses the set method to set the count of the new inventory
         returnInv.set(currentChar, sum); 
      } // end of for loop
      recheckSize(); // rechecks the size of countArr
      return returnInv; // returns the new inventory created
   } // end of add method
   
   
   public LetterInventory subtract (LetterInventory other) {
      // subtracts 2 inventorys and returns the new inventory
      int[] newCountArr = other.getCountArr();
      int sum;
      char currentChar;
      // defines the new inventory with an empty count
      LetterInventory returnInv = new LetterInventory("");
      for (int i = 0; i < 26; i ++) {
         sum = countArr[i] - newCountArr[i]; // gets the sum
         if (sum < 0) { // if the sum is negative
            // domain of sum needs to be 0<=sum<=inf so if sum becomes negative its reset to 0
            sum = 0;
         }
         currentChar = (char)('a' + i); // gets the current char 'i' should be on
         // uses the set method to set the count of the new inventory
         returnInv.set(currentChar, sum);
      } // end of for loop
      recheckSize(); // rechecks the size of countArr
      return returnInv;
   } // end of subtract method
   
   
   public int[] getCountArr() {
      // gets the countArr of a inventory
      // used in the add and subtract methods in this class
      return countArr;
   } // end of getCountArr method
} // end of class