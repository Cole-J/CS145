/*
Cole Johnson
CS 145 Assignment 2
5/5/2023

the overall program is meant to create a phone book. It includes a UI which allows the user to
add, delete, view, search, and edit, the contacts in the phonebook.

This specific class is the main c/ manager class. when run it creates a new phonebook object and
uses the methods in the phonebook class to modify the information in the phonebook.
(everything in this class is used for the user interface and this is the phonebook interface)

the main method controls the UI and then calls the correct methods to interact with the phonebook
object or the nodes
*/ // imports
import java.util.*;

public class phoneBookMain {
   public static void main(String[] args) {

      phoneBook book = new phoneBook(); // creates a new phonebook
      Scanner input = new Scanner(System.in); // creates a scanner
      
      ///* // default entries
      String[] c1  ={"John","Doe","1059 S Somewhere Street","Bellingham","360-000-0001"};
      book.addToEnd(c1);
      String[] c2  ={"Jain","Doe","1059 S Somewhere Street","Bellingham","360-000-0000"};
      book.addToEnd(c1);
      //*/
   
      // user interface
   
      boolean runProg = true;
      while (runProg) { // main loop
   
         options(); // prints the options to the user
         System.out.print("\nEnter a command: ");
         String userInput = input.next(); // gets the users input
   
         switch (userInput.toLowerCase()) {
            case "add":
            case "a":
            case "1": // add contact
               add(book, input);
               break; 
            case "delete":
            case "del":
            case "2": // delete contact
               delete(book, input);
               break;
            case "view":
            case "v":
            case "3": // view phoneBook
               view(book);
               break;
            case "name search":
            case "ns":
            case "4": // search for name
               System.out.print("Are you wanting to search by firstname (f) or lastname (l): ");
               String UIName = input.next(); // gets if first or last name
               char UICharName = UIName.toLowerCase().charAt(0);
               if (UICharName == 'f') { // if firstname
                  System.out.print("Search for the firstname: ");
                  String firstName = input.next();
                  search(book,0,firstName); // searches for firstname
               } else if (UICharName == 'l') { // if lastname
                  System.out.print("Search for the lastName: ");
                  String lastName = input.next();
                  search(book,1,lastName); // searchs for lastname
               } else { // else invalid input
                  System.out.println("ERROR: " + UICharName + " is not a legal input\n");
               } // end of if else firstName or lastName logic
               break;
            case "address search":
            case "city search":
            case "ps":
            case "5": // search for address or city
               System.out.print("Are you wanting to search by address (a) or city (c): ");
               String UIPlace = input.next(); // gets if address or city
               char UICharPlace = UIPlace.toLowerCase().charAt(0);
               if (UICharPlace == 'a') { // if address
                  System.out.print("Search for the address: ");
                  String address = input.next();
                  search(book,2,address); // searches for address
               } else if (UICharPlace == 'c') { // if city
                  System.out.print("Search for the city: ");
                  String city = input.next();
                  search(book,3,city); // searches for city
               } else { // else invalid input
                  System.out.println("ERROR: " + UICharPlace + " is not a legal input\n");
               } // end of if else address or city logic
               break;
            case "phonenumber search":
            case "phone number search":
            case "pns":
            case "6": // search for phonenumber
               System.out.print("Search for the phonenumber: ");
               String phoneNum = input.next();
               search(book, 4,phoneNum);
               break;
            case "edit name":
            case "en":
            case "7": // edit name
               System.out.print("Are you wanting to edit a firstname (f) or lastname (l): ");
               String UIEditName = input.next(); // gets if first or last name
               char UIEditCharName = UIEditName.toLowerCase().charAt(0);
               if (UIEditCharName == 'f') { // if firstname
                  System.out.print("What index's firstname do you need to edit (int): ");
                  int FNIndex = input.nextInt();
                  if (validIndex(book,FNIndex)) { // checks if the node with the given index exists
                     System.out.print("What do you want the new firstname to be: ");
                     String newFirstName = input.next();
                     edit(book,input,FNIndex,0,newFirstName); // edits node
                  } else { // if not then its invalid
                     System.out.println("ERROR: " + FNIndex + " index does not exist\n");
                  } // end of if else                  
               } else if (UIEditCharName == 'l') { // if lastname
                  System.out.print("What index's lastname do you need to edit (int): ");
                  int LNIndex = input.nextInt();
                  if (validIndex(book,LNIndex)) { // checks if the node with the given index exists
                     System.out.print("What do you want the new lastname to be: ");
                     String newLastName = input.next();
                     edit(book,input,LNIndex,1,newLastName); // edits node
                  } else { // if not then its invalid
                     System.out.println("ERROR: " + LNIndex + " index does not exist\n");
                  } // end of if else                   
               } else { // else invalid input
                  System.out.println("ERROR: " + UIEditName + " is not a legal input\n");
               } // end of if else firstName or lastName logic
               break;
            case "edit address":
            case "edit city":
            case "ep":
            case "8": // edit address or city
               System.out.print("Are you wanting to edit a address (a) or city (c): ");
               String UIEditPlace = input.next(); // gets if address or city
               char UIEditCharPlace = UIEditPlace.toLowerCase().charAt(0);
               if (UIEditCharPlace == 'a') { // if address
                  System.out.print("What index's address do you need to edit (int): ");
                  int AIndex = input.nextInt();
                  if (validIndex(book,AIndex)) { // checks if the node with the given index exists
                     System.out.print("What do you want the new address to be: ");
                     String newAddress = input.next();
                     edit(book,input,AIndex,2,newAddress); // edits node
                  } else { // if not then its invalid
                     System.out.println("ERROR: " + AIndex + " index does not exist\n");
                  } // end of if else                  
               } else if (UIEditCharPlace == 'c') { // if city
                  System.out.print("What index's city do you need to edit (int): ");
                  int CIndex = input.nextInt();
                  if (validIndex(book,CIndex)) { // checks if the node with the given index exists
                     System.out.print("What do you want the new city to be: ");
                     String newCity = input.next();
                     edit(book,input,CIndex,3,newCity); // edits node
                  } else { // if not then its invalid
                     System.out.println("ERROR: " + CIndex + " index does not exist\n");
                  } // end of if else                   
               } else { // else invalid input
                  System.out.println("ERROR: " + UIEditPlace + " is not a legal input\n");
               } // end of if else firstName or lastName logic
               break;
            case "edit phonemumber":
            case "edit phone number":
            case "epn":
            case "9": // edit phonenumber
               System.out.print("What index's phonenumber do you need to edit (int): ");
               int PNIndex = input.nextInt();
               if (validIndex(book,PNIndex)) { // checks if the node with the given index exists
                  System.out.print("What do you want the new phonenumber to be: ");
                  String newNumber = input.next();
                  edit(book,input,PNIndex,4,newNumber); // edits node
               } else { // if not then its invalid
                  System.out.println("ERROR: " + PNIndex + " index does not exist\n");
               }
               break;
            case "quit":
            case "q":
            case "0": // quit
               runProg = false; // exits loop
               break;
            default: // error message for invalid input
               System.out.println("ERROR: " + userInput + " is not a legal input\n");
               break;
         } // end of switch case
      } // end of main while loop
   } // end of main
   
   
   public static void add(phoneBook book, Scanner input) {
      System.out.println("Add a new contact to the phonebook.\n");
      String firstName="", lastName="", address="", city="", phoneNumber="", userLoopInput="n";
      while (userLoopInput.toLowerCase().charAt(0) != 'y') { // loops until user confirms
         // loop so the user can check that the contact info is correct
         // gets contact info
         System.out.print("Enter their firstname: ");
         firstName = input.next();
         System.out.print("Enter their lastname: ");
         lastName = input.next();
         System.out.print("Enter the address: ");
         address = input.next();
         System.out.print("Enter the city: ");
         city = input.next();
         System.out.print("Enter the phonenumber: ");
         phoneNumber = input.next();
         // checks with user if info is correct
         System.out.println("\nCompleted contact to be added:");
         System.out.println("Name: " + firstName + " " + lastName + ",");
         System.out.println("Address: " + address + ", City: " + city + ",");
         System.out.println("Phonenumber: " + phoneNumber);
         System.out.print("\nIs the information above correct (y/n): ");
         userLoopInput = input.next();
      } // end of while logic / check with the user that the user inputed the right information
      // packs new contact
      String[] newContact = {firstName, lastName, address, city, phoneNumber};
      boolean runLoop = true;
      while (runLoop) {
         // loop runs until users response is valid
         System.out.println("Where do you want the contact added?");
         System.out.println("It can be at the start (s), the end (e), or at an index (an integer)");
         String userInput = input.next(); // checks where the contact will be added
         // switch case for input logic
         switch (userInput.toLowerCase().charAt(0)) {
            case 's': // adding to the start of the list
               book.addToStart(newContact);
               runLoop = false;
               break;
            case 'e': // adding to the end of the list
               book.addToEnd(newContact);
               runLoop = false;
               break;
            default: // adding to an index or invalid input
               try { // if the string can be parsed to an int it does
                  int index = Integer.parseInt(userInput);
                  book.addToIndex(index, newContact); // then uses that int to addToIndex
                  runLoop = false;
               } catch (NumberFormatException e) { // else the input is invalid
                  System.out.println("ERROR: " + userInput + " is not a legal input");
               }
               break;
         } // end of switch case
      } // end of while loop
      System.out.println("Added " + firstName + " " + lastName + " to the phonebook.\n");
   } // end of add method
   
   
   public static void delete(phoneBook book, Scanner input) {
      int userInputIndex;
      String userInputConf;
      System.out.print("Enter an index to delete (int): ");
      userInputIndex = input.nextInt(); // gets index user wants to delete
      
      if (userInputIndex >= 0 & userInputIndex < book.size()) { 
         // check that index wont cause an error
         
         String[] elements = book.get(userInputIndex); // gets node elements
         
         System.out.println("Index: " + userInputIndex);
         System.out.println("Name: " + elements[0] + " " + elements[1] + ",");
         System.out.println("Address: " + elements[2] + ", City: " + elements[3] + ",");
         System.out.println("Phonenumber: " + elements[4] + "\n");
         System.out.print("Delete the entry above (y/n): ");
         userInputConf = input.next(); // checks deletion with user
         
         if (userInputConf.toLowerCase().charAt(0) == 'y') {
            book.remove(userInputIndex); // deletes entry / node
            System.out.println("Entry removed\n");
         } else {
            System.out.println("Entry NOT removed\n");
         } // end of if else logic / remove or not remove entry
      } else {
         System.out.println("ERROR: invalid index\n");
      } // end of if else logic / is index valid
   } // end of delete method
   
   
   public static void view(phoneBook book) {
      System.out.println("\nPhonebook:");
      book.printBook(); // prints all nodes in the list
      System.out.println("Phonebook end.\n");
   } // end of view method
   
   
   public static void search(phoneBook book, int elementIndex, String str) {
      // searches for a entry equal to str in the list row elementIndex
      // elementIndex key, 0 = fname, 1 = lname, 2 = address, 3 = city, 4 = phonenum
      int i = book.search(str, elementIndex);
      if (i != -1) {
         System.out.print("A match was found in contact (index) " + i);
         String[] elements = book.get(i);
         System.out.println(" under the name '" + elements[0] + " " + elements[1] + "'");
      } else {
         System.out.println("No match found");
      }
      System.out.println();
   } // end of search method
   
   
   public static void edit(phoneBook book, Scanner input, int targetIndex, int elementIndex, 
                           String str) {
      // sets a given entry to str in the list row elementIndex
      // elementIndex key, 0 = fname, 1 = lname, 2 = address, 3 = city, 4 = phonenum
      String[] elements = book.get(targetIndex); // gets the elements of the index from the book
      
      String prevElement = elements[elementIndex]; // sets values
      elements[elementIndex] = str;
      
      book.set(targetIndex, elements); // sets the new elements to override the values in the node
      System.out.println(prevElement + " changed to " + str + " in index " + targetIndex + "\n");
   } // end of edit method
   
   
   public static boolean validIndex(phoneBook book, int index) {
      // checks if a index is withing the books range
      if (index >= 0 & index < book.size()) {
         return true;
      } else {
         return false;
      }
   } // end of validIndex method
   
   
   public static void options() {
      // prints the options for the user
      System.out.println("1 - Add");
      System.out.println("2 - Delete");
      System.out.println("3 - View Contacts");
      System.out.println("4 - Name Search");
      System.out.println("5 - Address / City Search");
      System.out.println("6 - Phone Number Search");
      System.out.println("7 - Edit Name");
      System.out.println("8 - Edit Address / City");
      System.out.println("9 - Edit Phone Number");
      System.out.println("0 - Quit");
   } // end of options method

} // end of class