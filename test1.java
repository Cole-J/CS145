import java.util.*;
public class test1 {

public static void main(String[]args) {

System.out.println("2" + 7 / 3 + (9 % 5) + "6 * 4");

}




public static Map flipMap(Map<String, Integer> map) {
   Map<Integer,List<String>> newMap = new HashMap<Integer,List<String>>(); // creates a new map
   // map will later be returned
   // for each loop to loop through the different elements of passed map
   for (Map.Entry<String, Integer> mi : map.entrySet()) {
      if(newMap.containsKey(mi.getValue())) {
         // checks if newMap already has a given key
         newMap.get(mi.getValue()).add(mi.getKey()); // adds key to the list of values
      } else { // if its a new key
          // creates list for the key entries and adds the current key and value
         List<String> temp = new ArrayList<String>();
         temp.add(mi.getKey());
         newMap.put(mi.getValue(), temp);
      }
   } // end of for each loop
   return newMap;
} // end of flipMap method




public static void rotateEveryN(ArrayList<Integer> list, int n) {
   int size = list.size(); // gets size of list
   int idx = size % n;
   
   if (idx != 0) { // checks that the list was divisible
      size -= size/n;
   }
   for (int i = 0; i < size-1; i += n) { // loops through list in orders of n
      int currentVal = list.get(i+n-1);
      list.remove(i+n-1);
      list.add(i,currentVal);  
   } // end of for loop
} // end of rotateEveryN method








} // end of test class