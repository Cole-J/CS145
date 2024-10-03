/**/
// imports
import java.util.*;
//import java.io.*;

public class cardGame {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in); // 
   
      /*System.out.print("do you need insructions on how to play 21? : ");
      String userInput = input.next();
      userInput = userInput.toLowerCase();
      
      boolean runInstructions = true;
      
      switch(userInput.charAt(0)) {
      
         case 'y':
            System.out.println("y");
            break;
         case 'n':
            System.out.println("n");
            break;
         default:
            System.out.println("d");
            break;
      }*/ 
      // gets instructions and prints them
      
      
      DeckOfCards myDeckOfCards = new DeckOfCards(); 
      Queue<String> gameDeck = new LinkedList<String>();
      
      //System.out.println(myDeckOfCards.get(1));
      
      //System.out.printf("%-19s", myDeckOfCards.dealCard()); 
   
   
   } // end of main method
   
   
   
   public static void instructions() {
      System.out.println("instructions");
   } // end of instructions method
   
   
} // end of class