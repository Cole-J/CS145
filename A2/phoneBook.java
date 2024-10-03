public class phoneBook {

   listNode listF;
   


/*// add 
public void add(int value) {
    if (listF == null) {
        // adding to an empty list
        listF = new listNode(value);
    } else {
        // adding to the end of an existing list
        listNode current = listF;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new listNode(value);
    }
}*/

   public void append(String[] value) {
      // adds a new node to the end of the list
      // each node has an index int
      // each node contains a string array with contains the name, address, city, phone number
      if (listF == null) { // adding to an empty list
         listF = new listNode(-1, value, listF);
      } else { // adding to the end of an existing list
         listNode current = listF;
         int i = 1;
         while (current.next != null) {
            //System.out.print("i");
            //System.out.println(i);
            current = current.next;
            i ++;
         } // goes to the end of the list
         //System.out.print("f");
         //System.out.println(i)
         current.next = new listNode(i, value, listF);
      } // end of if else 
   
   } // end of add method

// get
/*
public int get(int index) {
    listNode current = listF;
    for (int i = 0; i < index; i++) {
        current = current.next;
    }
    if (current == null) {
      return 00;
    } else {
      return current.data;
    }
}*/

   /*public int getIndex(int index) { // MAYBE NOT NEEDED
      // gets the index
      listNode current = listF;
      for (int i = 0; i < index; i++) {
         current = current.next;
      } // goes to index
      try {
         return current.index; // returns the index
      } catch (Exception e) {
         System.out.println("\n<error: getIndex method, cannot return index when index = null>\n");
      } // trys to return value and gives error message if not
   } // end of getIndex method*/
   
   public String[] get(int index) {
      // gets the elements array which contains each parts on the node
      listNode current = listF;
      for (int i = 0; i < index + 1; i++) {
         current = current.next;
      } // goes to index
      //try {
         //System.out.println(current.getElementsArr());
         //System.out.print("i");
         //System.out.println(index);
         return current.getElementsArr();
      //} catch (Exception e) {
        // System.out.println("\n<error: getIndex method, cannot return index when index = null>\n");
      //}
   
   } // end of get method


// set
/*
public void set(int index, int value) {
   listNode current = listF;
   for (int i = 0; i < index; i++) {
      current = current.next;
   }
   current.setData(value);
}*/

   public void set(int index, String[] arr) {
      listNode current = listF;
      for (int i = 0; i < index; i++) {
         current = current.next;
      } // goes to list index
      current.setElements(arr); // sets list elements to parameter elements
   } // end of set method
   
// remove
/*
public void remove(int index) {
    if (index == 0) {
        // special case: removing first element
        listF = listF.next;
    } else {
        // removing from elsewhere in the list
        listNode current = listF;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }
}*/

   public void remove(int index) {
      // removes an index from the list by 'skipping' the index
      if (index == 0) { // case to remove first element
         listF = listF.next;
      } else { // remove from anywhere else in the lsit
         listNode current = listF;
         for (int i = 0; i < index; i++) {
            current = current.next;
         } // gose to index
         current.next = current.next.next; // skips index
      } // end of if else
   } // end of remove method

// size
   public int size() {
      // returns the size of the list
      int count = 0;
      listNode current = listF;
      while (current != null) {
         current = current.next;
         count ++;
      } // loops through the list while counting how many entries there are
      return count-1; // returns the size
   } // end of size method

// search
   public int search(String str, int arrIndex) {
   
      System.out.println("search");
   
      listNode current = listF;
      //boolean run = true;
      int returnVal = -1;
      //int c = 0;
      while (current != null /*& run*/) {
         // loops through nodes
         //System.out.println(current.index);
         String[] arr = current.getElementsArr();
         
         for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
         }
         System.out.println();
         
         //c++;
         
         current = current.next;
      } // 
      //System.out.println(c);
      return returnVal;
   } // end of earch method
   
/*
   public String[] get(int index) {
      // gets the elements array which contains each parts on the node
      listNode current = listF;
      for (int i = 0; i < index + 1; i++) {
         current = current.next;
      } // goes to index
      //try {
         //System.out.println(current.getElementsArr());
         //System.out.print("i");
         //System.out.println(index);
         return current.getElementsArr();
      //} catch (Exception e) {
        // System.out.println("\n<error: getIndex method, cannot return index when index = null>\n");
      //}
   
   } // end of get method
*/
   
   

} // end of class