/*
Cole Johnson
4/18/23

determine the look and behavior of the 'bear' critter

bear(bool polar) is a constructor and gets if the bear is a polar bear or not

getColor() gets the color of the bear based on the bool variable polar

toString() gets the string representing the bear (an alternating slash)

getMove() gets the action the bear will take in a given frame
*/
// imports
import java.awt.*;

public class Bear extends Critter {

   private boolean polar, slash; // defines private variables

   public Bear(boolean polar) { // start of class
      // construct method Bear with polar parameter
      this.polar = polar;
      this.slash = true;
   } // end of Bear constructor method

   public Color getColor() {
      // gets the color of the bear based off the bool polar
      if (polar) { // if bear is polar bear
         return Color.WHITE;
      } else {
         return Color.BLACK;
      } // end of if else color logic
   } // end of getColor method

   public String toString() {
      if (slash) {
         return "/";
      } else {
         return "\\";
      } // end of if else slash logic
   } // end of toString method

   public Action getMove(CritterInfo info) {
   
      slash = !slash;
      // sets slash to opposite bool
      
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
         // if critter in front then infect
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
         // if front is empty then hop
      } else {
         return Action.LEFT;
         // else turn left
      } // end of if else action logic   
   } // end of getMove method
} // end of Bear class