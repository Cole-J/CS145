// source: 
// https://stackoverflow.com/questions/16333650/how-to-check-whether-2-lines-segments-intersect#:~:text=To%20test%20whether%20two%20line,200)%3B%20boolean%20result%20%3D%20line2.

import java.awt.geom.*;
import java.util.*;

public class vectorIntercept {

   public static void main(String[] args) {
   
      //Line2D line1 = new Line2D.Double(1,1,4,4);
      //Line2D line1 = new Line2D.Double(1,1,4,4);
      //Line line2 = new Line(-1,3);
      
      //System.out.println(line1.intersection(line2)); // result  (1;2)  
      
      int[] v1 = {0,0,0,3};
      int[] v2 = {3,2,2,3};

      // vector x, vector y, slope, magnitude
   
      //System.out.println(VC(v1,v2));
      //Line2D line = new Line2D.Double(1,1,2,2);
      

      

      
      //System.out.println(a[0]);
      //System.out.println(a[1]);



		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
      int[] array2 = { 1, 2, 3, 4, 5, 6, 7 };
		
		Random rand = new Random();
		
		for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length);
			int temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}
		//System.out.println(Arrays.toString(array));
      
      
      //array = shuffleArray(rand, array);
      //array2 = shuffleArray(rand, array2);
      //System.out.println(Arrays.toString(array));
      //System.out.println(Arrays.toString(array2));

   
         int posArr[] = new int[3]; // creates an array with 3 indexes
         for (int i = 0; i < posArr.length; i++) {
            posArr[i] = i;
         };

         //System.out.println("b  " + Arrays.toString(posArr)); // base array which will be shuffled
         
         int[] x = shuffleArray(rand, posArr);
         
         //System.out.println("x1 " + Arrays.toString(x)); // shuffled
         
         int[] y = shuffleArray(rand, posArr);
         
         //System.out.println("y1 " + Arrays.toString(y)); // reshuffled
         
         
         //System.out.println("x2 " + Arrays.toString(x)); // equal to the shuffled y array
         //System.out.println("y2 " + Arrays.toString(y));
         
         
         //Random r = new Random();
   //word temp = new word("abc", r.nextBoolean(), r.nextInt(3));
   /*String[][] arr = {
      {"!!","!!","!!","!!","!!"},
      {"!!","!!","!!","!!","!!"},
      {"!!","!!","!!","!!","!!"},
      {"!!","!!","!!","!!","!!"},
      {"!!","!!","!!","!!","!!"}
   };*/
   
   //temp.x = 1;
   //temp.y = 2;
   
   //arr = addWordToWordSearch(arr, temp);
   
   
   for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
         //System.out.print(arr[i][j] + " ");
      }
      //System.out.println();
   }



      int[] p1 = {1,1};
      int[] p2 = {5,1};
      int[] p3 = {1,0};
      int[] p4 = {1,4};
      int[] inter = intercept(p1,p2,p3,p4);
      //System.out.println(Arrays.toString(inter));
   
      int[] p = {0,1,2};
      p = shuffleArray(rand, p);
      System.out.println(Arrays.toString(p));

   } // end of main


   public static String[][] addWordToWordSearch(String[][] arr, word w) {
      // adds word to word search based off the words x and y
      for (int i = 0; i < w.toString().length(); i++) { // loops for every char in the word
         if (w.slant() == 0) {
            arr[w.x + i][w.y] = "?" + w.toString().charAt(i);
         //wordSearchArr;
         } else if (w.slant() == 1) {
            arr[w.x + i][w.y + i] = "?" + w.toString().charAt(i);
         } else { // w.slant() == 2
            arr[w.x][w.y + i] = "?" + w.toString().charAt(i);
         } // end of if else slant check
      } // end of for loop
      return arr;
   } // end of addWordToWordSearch method





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
   
   public static int[] intercept(double[] p1, double[] p2, double[] p3, double[] p4) {
   
      if ((p2[0])-(p1[0]) == 0) {
         // if line 1 is vertical
         p2[0] += .001;
      } else if ((p2[1])-(p1[1]) == 0) {
         // if line 1 is flat
         p2[1] += .001;
      }

      if ((p4[0])-(p3[0]) == 0) {
         // if line 2 is vertical
         p4[0] += .001;
      } else if ((p4[1])-(p3[1]) == 0) {
         // if line 2 is flat
         p4[1] += .001;
      }
      
      double x = (p1[0]*((p2[1]-p1[1])/(p2[0]-p1[0]))-p3[0]*((p4[1]-p3[1])/(p4[0]-p3[0]))+p3[1]-p1[
                  1])/(((p2[1]-p1[1])/(p2[0]-p1[0]))-((p4[1]-p3[1])/(p4[0]-p3[0])));
                  // y=a1x1+k1-h1a1 and y=a2*x2+k2-h2a2
                  // solved as system of equations for x equals
      
      double y = ((p4[1]-p3[1])/(p4[0]-p3[0]))*(x)+(p3[1])-(p3[0])*((p4[1]-p3[1])/(p4[0]-p3[0]));
                  // uses x from above and puts it into one of the equations to get y equals
      
      
      
      int[] a = {(int)x,(int)y};
      return a;
   }
   
   public static boolean VC(int[] v1, int v2[]) {
   
      int v1x = v1[0];
      int v1y = v1[1];
      
      if (v1[2] == 0) {
         // flat
         v1x = v1[0] + v1[3]; // new x is old x + length, y is the same
      } else if (v1[2] == 1) {
         // slope
         v1x = v1[0] + v1[3]; // new x is old x + length
         v1y = v1[1] + v1[3]; // new y is old y + length
      } else {
         // vertical
         v1y = v1[1] + v1[3]; // new y is old y + length, x is the same
      }
   
      Line2D vector_1 = new Line2D.Double(v1[0],v1[1], v1x, v1y);
         
   
      return false;
   }
   



public static int[] intercept(int[] point1, int[] point2, int[] point3, int[] point4) {
    int x1 = point1[0];
    int y1 = point1[1];
    int x2 = point2[0];
    int y2 = point2[1];
    int x3 = point3[0];
    int y3 = point3[1];
    int x4 = point4[0];
    int y4 = point4[1];

    int[] interceptPoint = new int[2];

    int determinant = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

    if (determinant == 0) {
        // Lines are parallel, no intersection
        return null;
    } else {
        int x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / determinant;
        int y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / determinant;

        interceptPoint[0] = x;
        interceptPoint[1] = y;

        return interceptPoint;
    }
}



}