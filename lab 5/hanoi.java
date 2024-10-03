/*
Cole Johnson
5/19/23
CS 145 lab 5 towers of hanoi

i used g4g and DO for referances when I got stuck
https://www.geeksforgeeks.org/java-program-for-tower-of-hanoi/
https://www.digitalocean.com/community/tutorials/tower-of-hanoi

This program prints the steps to solve the towers of Hanoi problem with a given amount of 
disks on 3 separate towers. 
The program follows the rules such that the disks are moving from the left to right tower. 
The towers left , middle, and right towers have the names, Start, Middle, End.

I was originally going to implement a visual that showed disks being transfered between towers
but I was having trouble with that code so I settled on instructions.
*/
public class hanoi {


   public static void main(String[] args) { // main method to execute the program
      // int i is the number of disks on the starting tower
      // S, M, E are the names of the three towers, the names passed to not matter
      towerOfHanoi(4, "Start ", "Middle", "End   ");
   } // end of main method
   
   
   public static void towerOfHanoi(int i, String startRod, String midRod, String endRod) {
      // start of recursive methd
      if (i == 1) { // base case
         // base case for when there is only 1 disk left
         System.out.println("Move disk " + i + " from rod " +  startRod + " to rod " + endRod);
         return;
      } // end of if base case check
      // recursive case
      // moves next left tower disk to mid tower
      towerOfHanoi(i-1, startRod, endRod, midRod);
      // prints movement
      System.out.println("Move disk " + i + " from rod " +  startRod + " to rod " + endRod);
      // moves next mid tower disk to right tower
      towerOfHanoi(i-1, midRod, startRod, endRod);
   } // end of towerOfHanoi method


} // end of hanoi class