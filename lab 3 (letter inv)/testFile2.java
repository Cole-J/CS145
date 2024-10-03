/*
Cole Johnson and Jake
5/8/23
CS 145 lab 3 LetterInventory




*/
import java.util.Scanner; 

public class testFile2{

   public static void main(String[]args){
      instructions();
      System.out.println("please enter a command"); 
      Scanner input = new Scanner(System.in);
      String userInput = input.next(); 
      userInput = userInput.toLowerCase(); 
      while(!userInput.equals("quit") && !userInput.equals("0"))
      {//start of while loop
         checkUserInput(userInput);
         System.out.println("please enter a command"); 
         userInput = input.next();
      }//end of while loop 
      }//end of main method 

public static void instructions()
   {//start of instructions method 
      System.out.println("Type s to create a string. ");
      System.out.println("Type i to update and print an inventory of letters in the string.");
      System.out.println("Type g to check how many times a specific letter shows up.");
      System.out.println("Type e to set the value of a specific letter.");
      System.out.println("Type n to count teh numver of letters in the string.");
      System.out.println("Type m to check if the string has letters.");
      System.out.println("Type r to print a string representation of the inventory.");
      System.out.println("Type a to add two strings together.");
      System.out.println("Type b to subtract to strings from each other.");
      System.out.println(" 0 - Quit");
   }//end of instructions method
   
   
 //I just used a set of println statement to just print oout the menu options in the instructions
      
   public static boolean checkUserInput(String userInput)
   {//start of checkUserInput 
      switch(userInput)
      {//start of switch case 
         case "s":
            System.out.println("t");
         
            return true; 
         case "i":
             
            return true;   
         
         case "g":
             
            return true;
            
         case "e":
         
         
            return true;
            
         case "n":
         
            return true;
            
         case "m":
         
         
            return true;
            
         case "r":
         
            return true;
            
         case "a":
          
            return true;
            
         case "b":
             
            return true;
         
         case "0":
         case "quit":
            
            return true; 
         default: 
            System.out.println("This isn't a valid input! Please type a valid command");
            return false; 
} // end of switch case
} // end of checkUserInput method
} // end of class