// required header for map and list
import java.util.*;

// Main class
public class Main
{
    // method flipMap flips the given map and returns it
    public static Map flipMap(Map<String, Integer> map)
    {
        // create new Map to store the result
        Map<Integer,List<String>> newMap = new HashMap<Integer,List<String>>();
        
        // iterate the map
        for (Map.Entry<String, Integer> m : map.entrySet()) 
        {
            // if the value of map already exists as a key in new map
            // then add the key as a value to the new map
            if(newMap.containsKey(m.getValue()))
            {
                newMap.get(m.getValue()).add(m.getKey());
            } 
            
            // if key doesnt exists in the new map
            // then create a new entry
            else 
            {
                // declare an array list
                List<String> tempList = new ArrayList<String>();
                // add the current key of map to the list 
                tempList.add(m.getKey());
                // insert new key and value to the new map
                newMap.put(m.getValue(), tempList);
            }
        }
        
        // return the new map
        return newMap;
    }
    
    // main method
	public static void main(String[] args) 
	{
	    // create a map
	    Map<String, Integer> map = new HashMap<String, Integer>();
        
        // add values to map	    
	    map.put("hi", 5);
	    map.put("aloha", 7);
	    map.put("howdy", 4);
	    map.put("hello", 9);
	    map.put("hola", 5);
	    
	    // call function and display resultant map
		System.out.println(flipMap(map));
	}
}