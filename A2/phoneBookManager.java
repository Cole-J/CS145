public class phoneBookManager {

   public static void main(String[] args) {
   
      //listNode list = new listNode();
      
      
      //list.firstName = "t";
      
      //System.out.println(list.firstName);
      
      //list.next = new listNode();
      
      //list.next.firstName = "r";
      
      //System.out.println(list.next.firstName); // prints second

      //list.next.next.firstName = "1";
      
      //list.data = 42;
      
      //list.next = new listNode();
      //list.next.next = new listNode();
      //listNode a = list.next.next.next = new listNode();
      
      //a.data = 1;
      
      //System.out.println(a.data);
      //System.out.println(list.next.next.next.data);
      //listNode current = list;
      //while (current != null) {
         //System.out.println(current.data);
         //current = current.next;  // move to next node
      //}


      
      //phoneBook book = new phoneBook();

      //int i1 = 1;
      //String[] a = {"n1", "a1", "c1", "p1"};
      //int i2 = 2;
      //String[] b = {"n2", "a2", "c2", "p2"};
      
      
      
      
      phoneBook book = new phoneBook();
      
      
      //book.add(110);

      //System.out.println(book.get(1));
      
      //book.add(20);
      
      //System.out.println(book.get(2));
      
      //book.add(2);
      
      //System.out.println(book.get(3));
      
      //book.remove(3);
      //System.out.println(book.get(3));
      
      //book.add(111);
      //System.out.println(book.get(3));
      
      //book.add(500);
      //System.out.println(book.get(4));
      //book.set(4, 600);
      //System.out.println(book.get(4));
      
      String[] a = {"n1", "a1", "c1", "p1"};
      String[] b = {"n2", "a2", "c2", "p2"};
      
      book.append(a);
      
      //System.out.println(book.size());
      
      
      //String[] a1 = book.get(0);
      
      //System.out.println(a1[0]);
      
      book.append(b);
      //book.append(b);
      
      //String[] b1 = book.get(1);
      
      /////System.out.println(b1[1]);
      
      int i = book.search("n2",0);
      
      
      //System.out.println(i);
      
      
      
      
   } // end of main method


} // end of class