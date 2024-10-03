/*
Cole Johnson
cs 145 lab 4 card game
4/25


*/
// imports
import java.util.*;

public  class blackJack {
   public static void main(String[] args) {
      // while userInput = true the program will continue to play games with the player
      // until user input starts with 'n'

      boolean userInput = true;
      
      // start prompts and instructions
      System.out.println("welcome to black jack / 21 in java\n");
      
      System.out.print("do you need instructions (y/n)? ");
      if (getUserBool()) {
         instructions();
      } // end of if
      
      // main while loop that runs the program
      while (userInput) {
      
            Deck gameDeck = new Deck(); // creates a deck for the game
            playGame(gameDeck); // plays 1 round of blackjack / 21 with the player
            
            System.out.print("another game (y/n)? ");
            userInput = getUserBool();
      } // end of main while loop
      System.out.println("thanks for playing");
   } // end of main
   
   public static void playGame(Deck gameDeck) {
      // plays 1 game of blackjack / 21 with the user / player
   
      gameDeck.shuffle(); // shuffles the deck
      
      dealerHand dealer = new dealerHand(); // creates hands for the dealer and the player
      playerHand player = new playerHand();
      
      int c = 0; // count variable for the rounds, used as a first round check
      
      while((dealer.hitReady() == true) || (player.hitReady() == true)) {
         // main game loop runs while the dealer and player are 'ready' or a hit
         // 'ready' will equal false if they bust or stand / opt out of a hit
         if (c == 0) {
            // on the first round deal 4 cards
            dealer.addCard(gameDeck.dealCard());
            dealer.addCard(gameDeck.dealCard());
            player.addCard(gameDeck.dealCard());
            player.addCard(gameDeck.dealCard());
         } // end of if
         
         // prints current dealer hand
         System.out.println();
         System.out.println("dealer hand:");
         System.out.println(dealer.getHiddenReport());
         
         // prints current player hand
         System.out.println();
         System.out.println("your hand:");
         System.out.println(player.getReport());
         
         // checks players 'ready' with user input and handValue
         if (player.hitReady() != false && player.getHandValue() < 22) {
            System.out.print("hit (y/n)? ");
            player.setReady(getUserBool());
            // hit logic (if player is 'ready' for a hit)
            if (player.hitReady() == true) {
               player.addCard(gameDeck.dealCard());
               // if player hit / was ready it adds 1 more card to their deck
            } else {
               player.setReady(false);
               // else the player will no longer be able to draw
            } // end of nested if
            // if the player hasnt busted they can hit or stand / opt out
         } else {
            player.setReady(false);
            // if the player has busted they cannot draw
         } // end of if else player ready / hit logic
         
         // checks dealer 'ready' and adds 1 card to their hand if so
         if (dealer.hitReady() == true && dealer.getHandValue() < 22) {
            dealer.addCard(gameDeck.dealCard());
         } else {
            dealer.setReady(false);
         } // end of if else dealer ready / hit logic
         
         c ++;
      } // end of while loop

      // bust check
      boolean dealerBust = (dealer.getHandValue() > 21) ? true : false;
      boolean playerBust = (player.getHandValue() > 21) ? true : false;

      // prints the final round report when either its a win, loss, or tie
      System.out.print("\n\n");
      System.out.println("FINAL REPORT");
      System.out.println();
      System.out.println("dealer hand:");
      System.out.println(dealer.getReport());
      if (dealerBust) {
         System.out.println("dealer busted");
      }
      System.out.println();
      System.out.println("your hand:");
      System.out.println(player.getReport());
      if (playerBust) {
         System.out.println("you busted");
      }
      System.out.println();
      
      // win conditions
      if ((dealerBust && playerBust == false) || 
          (player.getHandValue() > dealer.getHandValue() && playerBust == false)) {
         // player wins if dealer bust and player doesnt or
         // if player doesnt bust but has higher value hand
         System.out.println("you win!");
      } else if ((dealerBust == false && playerBust) || 
                 (dealer.getHandValue() > player.getHandValue() && dealerBust == false)) {
                // dealer wins if player busts and dealer doesnt or
                // if dealer doesnt bust but has higher value hand
         System.out.println("you loose");
      } else {
         // otherwise its a tie
         System.out.println("its a tie");
      } // end of if else win condition logic
   } // end of playGame method
   
   public static boolean getUserBool() {
      // gets user (y/n) input and returns it as a bool
      Scanner input = new Scanner(System.in); // creates input scanner
      char userInput = 'a'; // element that not y or n
      while (userInput != 'y' && userInput != 'n') { // while loop for invalid inputs
         userInput = input.next().toLowerCase().charAt(0); // gets user input
         if (userInput != 'y' && userInput != 'n') {
            System.out.println("invalid input"); // invalid input error
         } // end of if
      } // end of while loop
      // after loop check userInput is a 'y' or 'n'
      if (userInput == 'y') {
         // yes = 'y' = true
         return true;
      } else {
         // no = 'n' = false
         return false;
      } // end of if else return logic
   } // end of getuserBool method

   public static void instructions() {
      // prints insturctions when called
      System.out.println("the dealer and the player will be delt 2 cards.");
      System.out.println("one of the dealers cards will be face down while the other is visible.");
      System.out.println("face cards count as 10 points, aces are 1 or 11 points, all other");
      System.out.println("count at face value. you can ask the dealer for a hit to get another");
      System.out.println("card and you can draw as many as you wish. you can also choose to");
      System.out.println("stand / not draw another card. the goal is to get as close to 21");
      System.out.println("points as possible without going over.");
   } // end of instructions method
} // end of blackjack class