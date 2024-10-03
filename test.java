import java.util.*;
public class test {
   public static void main(String args[]) {
   

   
   } // end of main
   
   /*
   static Stack<Integer> reverseBottomHalf(Stack<Integer> stack){
      // starting and half index of stack
      int start=0;
      int half=stack.size()/2;
      // LOOP for half of the hlaf values of stack
      for(int i=0;i<half/2;i++){
         // getting value at index i
         int newFirst=stack.get(i);
         // getting value at index from last of half
         int newLast=stack.get(half-i-1);
         // setting new values to stack
         stack.set(i,newLast);
         stack.set(half-i-1,newFirst);
      }
      // retuning updated stack
      return stack;
}*/

   public static Stack<Integer> reverseBottomHalf(Stack<Integer> stack) {
      int mid = stack.size() / 2, f, l; // gets mid of stack
      
      for (int i = 0; i < mid; i++) {
         f = stack.get(i); // gets the new / updated front and last in the stack
         l = stack.get(mid-i-1); // domain goes until midpoint
         stack.set(i, l); // front to last
         stack.set(mid-i-1, f); // sets last to front
      } // end of for loop
      return stack;
   } // end of reverseBottomHalf method

 
   public void doubleTree() {
      doubleTree(overallRoot);  
   } // end of doubleTree method
   
   private void doubleTree(IntTreeNode node) {
      // recursive method
      if (node == null) {
         // base / leaf case
      } else {
         doubleTree(node.left); // call left first
         
         // copy the current and right nodes
         IntTreeNode currentNodeData = new IntTreeNode(node.data);
         IntTreeNode rightNodeCopy = node.right;
         
         // set right and right right nodes
         node.right = currentNodeData;
         node.right.right = rightNodeCopy;
      } // end of if else
   } // end of doubleTree recursion method
   
   public void doubleTree() {
      doubleTree(overallRoot);  
   } // end of doubleTree method
   
   private void doubleTree(IntTreeNode node) {
      // recursive method
      if (node != null) { // base case is node == null
         doubleTree(node.left); // calls left first
         
         // copy the current and right nodes
         IntTreeNode currentNodeData = new IntTreeNode(node.data);
         IntTreeNode rightNodeCopy = node.right;
         
         // set right and right right nodes
         node.right = currentNodeData;
         node.right.right = rightNodeCopy;
         
         doubleTree(rightNodeCopy); // calls right after
      } // end of if
   } // end of doubleTree recursion method
   
}