/*
Cole Johnson
cs 145 lab 4 card game
4/25

creates a hand for the player along with the methods

<constructor>playerHand creates a hand array for the player
addCard adds a card to the players hand
getHandValue gets the total value of the players hand
getReport creates a report of the players current hand, including the cards and their values
hitReady checks if the player wants / is ready for a hit
setReady sets the 'ready' / when the player wants the hit (for the bust condition)
*/
// imports
import java.util.*;

public class playerHand {

   private Scanner input = new Scanner(System.in);
   private ArrayList<Card> playerCards;
   private int totalHandValue = 0;
   private boolean ready = true;

   public playerHand() {
      playerCards = new ArrayList<Card>();
   } // end of dealerHand constructor
   
   public void addCard(Card card) {
      boolean aceCheck = false;
      if (card.getSuit() == "Ace") {
         // checks if the drawn card is an ace
         aceCheck = true;
      } // end of if
      while (aceCheck) {
         // checks if the user wants to change the ace 11 to a 1
         System.out.print("do you want your ace to equal 1 instead of 11? ");
         String userInput = input.next();
         userInput = userInput.toLowerCase();
         // gets user input
         
         if (userInput.charAt(0) == 'y') {
            card.setValue(1);
            aceCheck = false;
         } else if (userInput.charAt(0) == 'n') {
            aceCheck = false;
         } else {
            System.out.println("invalid input");
         } // end of if else logic
         // checks the user input and if 'y' it sets the aces value to 1 instead of 11
      } // end of while loop
      playerCards.add(card);
      totalHandValue += card.getValue();
   } // end of addCard method
   
   public int getHandValue() {
      return totalHandValue;
   } // end of getHandValue method
   
   public String getReport() {
      String s = ""; // creates a temp string that is returned
      // strings the cards in the deck and turns them into a string
      for (int i = 0; i < playerCards.size(); i++) {
         s = s + playerCards.get(i).toString();
         if (i+1 != playerCards.size()) {
            s = s + " + ";
         } // end of if
      } // end of for loop
      s = s + " = " + Integer.toString(totalHandValue);
      // adds the total value to the string
      return s;
   } // end of getReport method
   
   public boolean hitReady() {
   return ready;
   } // end of hitReady method
   
   public void setReady(boolean newReady) {
      this.ready = newReady;
   } // end of setReady method
} // end of dealerHand class