/*
Cole Johnson
CS 145 Assignment 2
5/5/2023

the overall program is meant to create a phone book. It includes a UI which allows the user to
add, delete, view, search, and edit, the contacts in the phonebook.

This specific class creates the phonebook and includes all the methods needed to interact with 
each node of the phonebook

they are
get, gets the nodes elements / value
size, gets the size of the total phonebook
search, searches the nodes in the book for a given string and returns the index of the match
addToStart, adds a node to the start
AddToIndex, adds a node to a index in the list
AddToEnd, adds a node to the end of the list
printBook, prints the nodes in the phonebook (used directly in the ui)
set, sets the values of the node
remove, removes a node at a given index
*/
public class phoneBook {

   node listFront;

   // get
   public String[] get(int index) {
      // gets the elements array which contains each parts on the node
      node current = listFront;
      for (int i = 0; i < index; i++) {
         current = current.next;
      } // goes to index
      return current.getElementsArr();
   } // end of get method
   
   // size
   public int size() {
      // returns the size of the list
      int count = 0;
      node current = listFront;
      while (current != null) {
         current = current.next;
         count ++;
      } // loops through the list while counting how many entries there are
      return count; // returns the size
   } // end of size method
   
   
   // search
   public int search(String str, int arrIndex) {
      // searches the nodes for a value and returns the index of the node that has the value
      node current = listFront;
      int returnVal = -1; // if the value cannot be found the method reutrns -1
      int count = 0;
      while (current != null) { // loops through nodes
         
         String[] elements = current.getElementsArr(); // gets node elements
         
         if (elements[arrIndex].equals(str)) {
            // checks if the specific element equals the parameter string and breaks the look if so
            returnVal = count; // returns the index of the node containing the searched value
            break;
         } // end of if logic
         current = current.next; // to next or ++
         count ++;
      } // end of while loop
      return returnVal;
   } // end of search method


   // add to start
   public void addToStart(String[] arr) {
      node current = listFront; // creates a new node at the start of a empty list
      node tempNode = current;
      node newFront = new node(arr, null);
      listFront = newFront;
      listFront.next = current;
   } // end of addToStart method
   
   
   // add to index
   public int addToIndex(int index, String[] arr) {
      int completed = -1; // returns -1 if add action could not be completed
      if (index == 0) { // test case for first index
         // check for adding to the before the first node
         node current = listFront; // creates a new node and adds points the next to the other nodes
         node tempNode = current;
         node newFront = new node(arr, null);
         listFront = newFront;
         listFront.next = current;
         completed = 0;
      } else { // if not first node / index
         int count = 1;
         node current = listFront;
         while (current != null) { // goes to the area the node will be added
            if (count == index) {
                // adds node by cutting off the end of the list at the given index, adding the new
                // node, then adding back the rest of the list after the new node
               node tempNode = current.next;
               node newFront = new node(arr, null);
               current.next = newFront;
               current = current.next;
               current.next = tempNode;
               completed = count;  
               break;
            }
            current = current.next;
            count ++;
         } // end of while loop
      } // end of if else logic
      return completed;
   } // end of addToIndex
   
   
   // add to end
   public void addToEnd(String[] arr) {
      // adds a new node to the end of the list
      if (listFront == null) {
         listFront = new node(arr, listFront); // changed -1 to 0
      } else {
         node current = listFront;
         int count = 1;
         while (current.next != null) {
            current = current.next;
            count ++;
         } // end of while / goes to last node
         current.next = new node(arr, listFront); // creates a new node with arr values
      } // end of if else
   } // end of addToEnd method
   
   
   // print
   public void printBook() {
      node current = listFront; // gets current node
      int count = 0; // gets index
      while (current != null) {
         String[] elements = current.getElementsArr();
         System.out.println("Index: " + count);
         System.out.println("Name: " + elements[0] + " " + elements[1] + ",");
         System.out.println("Address: " + elements[2] + ", City: " + elements[3] + ",");
         System.out.println("Phonenumber: " + elements[4] + "\n");
         current = current.next;
         count ++;
      } // end of while
   } // end of printBook method
   
   
   // set
   public void set(int index, String[] arr) {
      node current = listFront;
      for (int i = 0; i < index; i++) {
         current = current.next;
      } // goes to list index
      current.setElements(arr); // sets list elements to parameter elements
   } // end of set method
   
   
   // remove
   public int remove(int index) {
      // remvoes the node at a given index
      // also returns 1 or -1 depending on if the remove action could or could not be completed
   
      node current = listFront, prev = null; // gets current and prev nodes
      
      if (index == 0 & current != null) { // if index to be removed is the first index
         listFront = current.next; // removes first index
         return 1; // returns positive int as the position could be removed
      } else {
      
         int count = 0;
         while (current != null) { // loops to find specified index
         
            if (count == index) { // finds index to be removed
               prev.next = current.next; // removes index and stops look
               break;
            } else { // sets values for another run of the loop
               prev = current; // prev to next
               current = current.next; // current to next
               count ++;
            } // end of if else         
         } // end of while
      
         if (current == null) { 
            return -1; // returns a negative int if the position could not be removed / DNE
         } else {
            return 1; // returns positive int if the position could be removed
         } // end of if else return logic
      } // end of 0 index if else logic
   } // end of remove method
   
} // end of phoneBook class