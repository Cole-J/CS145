/*
Cole Johnson
cs 145 lab 4 card game
4/25

creates a hand for the dealer along with the methods

<constructor>dealerHand creates a hand array for the dealer
addCard adds a card to the dealers hand
getHandValue get the total value of the dealers hand
getHiddenReport creates a report with all but 1 cards hidden
getReport creates a report of the cards the dealer has, and the value of the cards
hitReady checks if the dealer wants a hit
setReady sets the 'ready' / when the dealer wants the hit (for the bust condition)
*/
// imports
import java.util.*;
import java.security.SecureRandom;

public class dealerHand {

   private static final SecureRandom randomNumbers = new SecureRandom(); 
   private ArrayList<Card> dealerCards;
   private int totalHandValue = 0;
   boolean ready = true;

   public dealerHand() {
      dealerCards = new ArrayList<Card>();
   } // end of dealerHand constructor
   
   public void addCard(Card card) {
      if (card.getSuit() == "Ace") {
         if (!(totalHandValue < 12)) {
            card.setValue(1);
         }
         // adds a card to the dealerHand array
      } // end of if if logic
      dealerCards.add(card);
      totalHandValue += card.getValue();
   } // end of addCard method
   
   public int getHandValue() {
      return totalHandValue;
   } // end of getHandValue method
   
   public String getHiddenReport() {
      // creates a string of the hidden and revealed cards in the dealer hand
      String s = "[**********] + " + dealerCards.get(1).toString();
      for (int i = 2; i < dealerCards.size(); i++) {
         s = s + " + [**********]";
      } // end of for loop
      return s;
      // returns the hidden array
   } // end of getHiddenReport method
   
   public String getReport() {
      // creates a string of the cards and value in / of the dealer hand
      String s = "";
      for (int i = 0; i < dealerCards.size(); i++) {
         s = s + dealerCards.get(i).toString();
         if (i+1 != dealerCards.size()) {
            s = s + " + ";
         } // end of if logic
      } // end of for loop
      s = s + " = " + Integer.toString(totalHandValue);
      return s;
      // returns the dealer hand array and the total value
   } // end of getReport method
   
   public boolean hitReady() {
      // logic to check if the dealer wants a hit or not
      if (ready != false) {
         int r = randomNumbers.nextInt(3);
         switch (r) {
            // switch case for the 3 types of 'reactions' the dealer can have
            case 0:
               if (totalHandValue > 14) {
                  ready = false;
               }
               break;
            case 1:
               if (totalHandValue > 16) {
                  ready = false;
               }
               break;
            case 2:
               if (totalHandValue > 18) {
                  ready = false;
               }
               break;
            default:
               ready = true;
               break;
         } // end of switch case
         return ready; 
      } else {
         return false;
      } // end of if else logic
   } // end of hit method
   
   public void setReady(boolean newReady) {
      this.ready = newReady;
   } // end of setReady method
} // end of dealerHand class