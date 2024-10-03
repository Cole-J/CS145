class Node
{
    int data;
    Node left, right;
  
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
  
class BinaryTree
{
    Node root;
  
    /* Function to convert a tree to double tree */
    void doubleTree(Node node)
    {
        Node oldright;
  
        if (node == null) {
            return;
         } else {
        /* do the subtrees */
        doubleTree(node.left);
        doubleTree(node.right);
  
        /* duplicate this node to its left */
        oldright = node.right;
        node.right = new Node(node.data);
        node.right.right = oldright;
    }}
  
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    private void preOrder(Node node) { if (node == null) { return; } System.out.printf("%s ", node.data); preOrder(node.left); preOrder(node.right); }

  
    /* Driver program to test the above functions */
    public static void main(String args[])
    {
        /* Constructed binary tree is
              1
            /   \
           2     3
         /  \
        4    5
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        System.out.println("Original tree is : ");
        //tree.printInorder(tree.root);
        tree.preOrder(tree.root);
        tree.doubleTree(tree.root);
        System.out.println("");
        System.out.println("Inorder traversal of double tree is : ");
        //tree.printInorder(tree.root);
         tree.preOrder(tree.root);
    }
    
       private void doubleTree(IntTreeNode node) {
   
      if (node == null) {
         // base case
      } else {
         
      }
   } // end of doubleTree recursion method
}
 