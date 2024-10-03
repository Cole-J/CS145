/*
Cole Johnson
6/9/23
A3, Anagrams

this class is used to create an Anagrams object, which can take a dictionary (in the form of a set)
and will then provide the user with the print and getWords method.

getWords(String phrase), returns a set of all the words in the classes dictionary whose letter
inventory can be contained within the phrases letter inventory.

print(String phrase), prints all anagrams for that phrase (without a max).

print(String phrase, int max), prints all anagrams with a word count less than or equal to the max.

printHelper, is a helper function that does the actual logic and recurison for the 2 print methods.
(more information above the method)
*/ // imports
import java.util.Set;
import java.util.TreeSet;
import java.util.Stack;


public class Anagrams {
   private Set<String> dictionary; // used to hold all the words in a dict file / set
   
   
   // constructor method for the Anagrams class
   // sets the passed dict set to the class dict set
   public Anagrams(Set<String> dictionary) {
      if (dictionary == null) { // throws error message if there is nothing in the passed set
         throw new IllegalArgumentException("Error: passed dictionary set is null");
      } else {
         this.dictionary = dictionary;
      } // end of if else error throw
   } // end of constructor

   
   // creates a set of the words in the dictionary set whose inventory can be contained
   // by the passed strings inventory / a set of words contained in the phrase variable.
   public Set<String> getWords(String phrase) {
   
      Set<String> set = new TreeSet<String>(); // creates return variable
      
      if (phrase == null) { // throws error message if there is nothing in the passed string
         throw new IllegalArgumentException("Error: passed string is null");
      } else {
      
         LetterInventory phraseInv = new LetterInventory(phrase);
         for (String w: dictionary) { // loops through every element in the current dictionary
            LetterInventory wordInv = new LetterInventory(w);
            if (phraseInv.contains(wordInv)) {
               set.add(w); // if the phrase contains the current word its added to the set
            } // checks if the dict word is contained withing the str and adds it to the set if so
         } // end of for each word in dict loop
         
      } // end of if else error throw
      return set;
   } // end of getWords method
   
   
   // prints the anagrams without a max
   public void print(String phrase) {
      if (phrase == null) { 
      // throws error message if there is nothing in the passed string
         throw new IllegalArgumentException("Error: passed string is null");
      } else {
         // creates a inv based off the phrase
         LetterInventory currentInv = new LetterInventory(phrase);
         // creates a dict based off the phrase
         Set<String> phraseDict = getWords(phrase);
         // starts recursion
         // note if max = 0 then there is no restrictions on number of anagrams printed
         printHelper(currentInv, phraseDict, new Stack<String>(), 0);
      } // end of if else error throw
   } // end of print string method


   // prints the anagrams with a max
   public void print(String phrase, int max) {
      if (phrase == null || max < 0) { 
         // throws error message if there is nothing in the passed string
         throw new IllegalArgumentException("Error: passed string is null or max is less than 0");
      } else {
         // creates a inv based off the phrase
         LetterInventory currentInv = new LetterInventory(phrase);
         // creates a dict based off the phrase
         Set<String> phraseDict = getWords(phrase);
         // starts recursion
         printHelper(currentInv, phraseDict, new Stack<String>(), max);
      } // end of if else error throw
   } // end of print with max method
   
   
   // the prior print methods call this helper method to do the actual logic and recursion.
   // this method first checks if the current inventory is empty (if so it prints the anagram),
   // if not it loops through every word in the current dictionary and attempts to subtract its
   // inventory from the current inventory to create a new inventory.
   // the above continues until all the paths in which the inventory can be emptied can be found.
   private void printHelper(LetterInventory currentInv, Set<String> currentDict, Stack<String> 
                                                                           chosenWords, int max) {
      // helper method used to make recursion simpler
      if (currentInv.isEmpty()) { // if the currentInv is empty then its a good run
         System.out.println(chosenWords);
      } else if (chosenWords.size() < max || max == 0) { // if we are not at the end of the run
      
         for (String w: currentDict) { // loops through the words in the current dict
            chosenWords.push(w); // pushes the current word to the stack
            LetterInventory wordInv = new LetterInventory(w); // creates the words inventory
            if (currentInv.contains(wordInv)) { // checks if word is in the current inventory
               // creates new inv based off of the current inv
               LetterInventory tempInv = new LetterInventory(currentInv);
               // subtracts the words inv from the temp inv
               tempInv.subtract(wordInv);
               // creates a new current dict
               Set<String> tempDict = getWords(tempInv.toString());
               printHelper(tempInv, tempDict, chosenWords, max);
            } // end of if in inv
            chosenWords.pop(); // removes current word from the stack
            // so that the current word does not appear out of order in the NEXT words stack
         } // end of for each word in current dict
         
      } // end of if else if
   } // end of printHelper method


} // end of class