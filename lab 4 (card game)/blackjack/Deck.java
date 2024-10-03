/*
Cole Johnson
cs 145 lab 4 card game
4/25

creates a deck stack along with the methods

<constructor>Deck creates a deck
shuffle shuffles the deck
getDeckSize gets the size of the deck
dealCard pops a card from the deck
*/
// imports
import java.util.*;
import java.security.SecureRandom; 

public class Deck {
   private static final SecureRandom randomNumbers = new SecureRandom(); 
   private static final int NUMBER_OF_CARDS = 52; 
   private Stack<Card> deck = new Stack<Card>();
   private int currentCard = 0;
   // deck class variables
   
   public Deck() {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "eight", "nine",
                        "ten", "Jack", "Queen", "King"};
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
      int[] values = {11,2,3,4,5,6,7,8,9,10,10,10,10};
      // card attribute arrays  
      
      for (int i = 0; i < NUMBER_OF_CARDS; i++) {
         // adds a specific number of cards to the deck
         deck.push(new Card(faces[i % 13], suits[i / 13], values[i % 13]));
      } // end of for loop
   } // end of deck constructor
   
   public void shuffle() { // turns stack into an array, shuffles array, then back into stack
      // creates the shuffle array
      Card[] shuffleArr = new Card[NUMBER_OF_CARDS];
      for (int i = 0; i < NUMBER_OF_CARDS; i++) {
         shuffleArr[i] = deck.pop();
         // adds all cards in deck to temp array
      } // end of for loop
      // shuffles the temp shuffle array
      currentCard = 0;
      for (int first = 0; first < NUMBER_OF_CARDS; first++) {
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
         Card temp = shuffleArr[first]; 
         shuffleArr[first] = shuffleArr[second];
         shuffleArr[second] = temp;  
         // shuffles all cards in the temp array
      } // end of for loop
      // redefiens deck as the shuffled array
      for (int i = 0; i < NUMBER_OF_CARDS; i++) {
         deck.push(shuffleArr[i]);
      } // end of for loop
   } // end of shuffle method
   
   public int getDeckSize() {
      return deck.size();
   } // end of getDeckSize method
   
   public Card dealCard() {
      if (currentCard < deck.size()) {
         return deck.pop();
         // pops current card from deck
      } else {
         return null;
         // returns null if there is no current card
      } // end of if else logic
   } // end of dealCard method
} // end of deck method