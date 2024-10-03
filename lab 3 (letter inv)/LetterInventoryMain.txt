/*
Cole Johnson and Jake M
5/8/23
CS 145 lab 3 LetterInventory

This file contains the UI that interacts with the LetterInventory class
to test that the class works. We utilized a swtich case to check the
input and then select what method we would call to get the desired
output.
*/ // imports
import java.util.Scanner;

public class LetterInventoryMain{

   public static void main(String[]args){
      LetterInventory inventory = new LetterInventory("");
      instructions();
      System.out.println("please enter a command");
      Scanner input = new Scanner(System.in);
      String userInput = input.next();
      userInput = userInput.toLowerCase();
      while(!userInput.equals("q") && !userInput.equals("quit"))
      {//start of while loop
         inventory = checkUserInput(userInput, inventory);
         instructions();
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
      System.out.println("Type n to count the numver of letters in the string.");
      System.out.println("Type m to check if the string has letters.");
      System.out.println("Type r to print a string representation of the inventory.");
      System.out.println("Type a to add two strings together.");
      System.out.println("Type b to subtract to strings from each other.");
      System.out.println("Type q to quit");
   }//end of instructions method


   //I just used a set of println statement to just print out the menu options in the instructions

   public static LetterInventory checkUserInput(String str, LetterInventory inventory)
   {//start of checkUserInput
      //LetterInventory inventory = new LetterInventory("");
      LetterInventory temp = new LetterInventory("");
      Scanner input = new Scanner(System.in);
      String userInput;
      switch(str)
      {//start of switch case
         case "s":
            System.out.println("Type out your string.");
            userInput = input.next();
            inventory = new LetterInventory(userInput);
            return inventory;

         case "i":
            System.out.println(inventory.toString());
            //toString
            return inventory;

         case "g":
            System.out.println("What letter would you like to look at?");
            userInput = input.next();
            int amount = inventory.get(userInput.charAt(0));
            System.out.println(userInput.charAt(0)+ " showed up " + amount + " times.");
            return inventory;

         case "e":
            System.out.println("What letter would you like to set?");
            userInput = input.next();
            System.out.println("What do you want to set the value to?");
            int setValue = input.nextInt();
            inventory.set(userInput.charAt(0),setValue);
            //set
            return inventory;

      case "n":
         System.out.println("The total amount of character is " + inventory.size());
         //size
         return inventory;

      case "m":
         if(inventory.isEmpty()){
            System.out.println("This string is empty.");
         }
            else
         {
            System.out.println("The string is not empty.");
         }
         //isEmpty();
         return inventory;

      case "r":
         System.out.println(inventory.toString());
         //print input
         return inventory;

      case "a":
         //add
         System.out.println("What string would you like to add?");
         userInput = input.next();
         temp = new LetterInventory(userInput);
         inventory = inventory.add(temp);
         return inventory;

      case "b":
         //subtract
         System.out.println("What string would you like to subtract?");
         userInput = input.next();
         temp = new LetterInventory(userInput);
         inventory = inventory.subtract(temp);
         return inventory;

      case "0":
      case "quit":
         return inventory;

      default:
         System.out.println("This isn't a valid input! Please type a valid command");
         return inventory;

      } // end of switch case
   } // end of method
} // end of class