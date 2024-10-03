import java.util.*;

public class cheggsArrayQuestion {
   public static void main(String[] args) {
   
      Random rand = new Random();
      
      int posArr[] = new int[3]; // creates an array with 3 indexes
      for (int i = 0; i < posArr.length; i++) {
         posArr[i] = i;
      };

      System.out.println("b  " + Arrays.toString(posArr)); // base array which will be shuffled
         
      int[] x = shuffleArray(rand, posArr);
         
      System.out.println("x1 " + Arrays.toString(x)); // shuffled
         
      int[] y = shuffleArray(rand, posArr);
         
      System.out.println("y1 " + Arrays.toString(y)); // reshuffled
         
         
      System.out.println("x2 " + Arrays.toString(x)); // equal to the shuffled y array
      System.out.println("y2 " + Arrays.toString(y));
   }
   
   public static int[] shuffleArray(Random r, int[] array) {
      // shuffles the array
      for (int i = 0; i < array.length; i++) {
	      int randomIndexToSwap = r.nextInt(array.length);
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		} // end of for loop
      return array;
   }
}