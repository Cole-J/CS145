/*
Cole Johnson
cs 145 lab 4 card game
4/25

creates card objects along with the methods

<constructor>Card to create a card with a given suit face and value
getSuit to get a cards suit
getValue to get a cards value
setValue to set a cards value
*/

public class Card {
   private final String suit; // creates card attributes
   private final String face;
   private int value;
   
   public Card(String suit, String face, int value) {
      this.suit = suit;
      this.face = face;
      this.value = value;
   } // end of card constructor
   
   public String toString() {
      return "[" + face + " of " + suit + "]";
   } // end of toString method 
   
   public String getSuit() {
      return suit;
   } // end of getSuit method

   public int getValue() {
      return value;
   } // end of getValue method
   
   public void setValue(int newValue) {
      this.value = newValue;
   } // end of setValue method
} // end of card class