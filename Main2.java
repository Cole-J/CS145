import java.util.ArrayList;           //import ArrayList package
import java.util.Scanner;             //import scanner class
public class Main2
{
	static void rotate(ArrayList <Integer> li,int n){    //function method static
	    int size=li.size();
	    int a=size%n;
	    if(a!=0){
	        size=size-size/n;               // this block is used to prevent array to go into out of bounds 
	                                    //if array size is not divisible by n then not rotate the remaining  elements so 
	                                    //we stop at the "size" value inndex to avoid array out of bonds
	        
	        
	    }
	    
	    for(int i=0;i<size-1;i+=n){   //iterating through array list for each "n" value increment
	        int v=li.get(i+n-1);       //at each index i we are storing the "i+n-1" element that every n element
	        li.remove(i+n-1);         //thhen remmoving the  n index element  to store it in the front
	        li.add(i,v);             //adding the stored element in the front
	        
	    }
	     for(Integer ele:li){
	         System.out.println("The rotated list is :\n");
	        System.out.print(ele+" ");   //printing the elements
	    }
	}

public static void main(String[] args) {
		System.out.println("Enter the size of list");
		
		Scanner sc= new Scanner(System.in);
			int input=sc.nextInt();
		ArrayList<Integer> li=new ArrayList<Integer>(input);
	   System.out.println("Enter the list elements");
		for(int i=0;i<input;i++){
		    int ele=sc.nextInt();
		    li.add(ele);
		}
	    int value=sc.nextInt();
		rotate(li,value);
}
}