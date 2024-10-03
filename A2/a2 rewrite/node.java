/*
Cole Johnson
CS 145 Assignment 2
5/5/2023

the overall program is meant to create a phone book. It includes a UI which allows the user to
add, delete, view, search, and edit, the contacts in the phonebook.

this class creates the nodes / entries used by the phonebook.

the nodes contain a value and point to the next node.
the value of the node is an array which contains all the information about the entry in the 
phonebook.

the methods in the class are
node, a constructor
getElementsArr, gets the elements or values of the node
setElementsArr, sets the elemets or values of the node to a passed array
*/
public class node {
   String firstName;
   String lastName;
   String address;
   String city;
   String phoneNum;
   
   node next;

   public node(String[] elementsArr, node next) {
      this.firstName = elementsArr[0];
      this.lastName = elementsArr[1];
      this.address = elementsArr[2];
      this.city = elementsArr[3];
      this.phoneNum = elementsArr[4];
   } // constructor

   public String[] getElementsArr() {
      // returns an array with the given elements in the node
      String[] arr = {this.firstName, this.lastName, this.address, this.city, this.phoneNum};
      return arr;
   } // end of getElements method
   
   public void setElements(String[] elementsArr) {
      // sets the elements in the node to the passed array
      this.firstName = elementsArr[0];
      this.lastName = elementsArr[1];
      this.address = elementsArr[2];
      this.city = elementsArr[3];
      this.phoneNum = elementsArr[4];
   } // end of getElements method

} // end of node class