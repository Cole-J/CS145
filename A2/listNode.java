public class listNode {
   int index;
   String name;
   String address;
   String city;
   String phoneNum;
   //int data;
   listNode next;
   
   public listNode() {} // default constructor without given info
   
   //public listNode(int data) {
   //   this.data = data;
   //}
   
   public listNode(int index, String[] elementsArr, listNode next) {
      this.index = index;
      this.name = elementsArr[0];
      this.address = elementsArr[1];
      this.city = elementsArr[2];
      this.phoneNum = elementsArr[3];
   } // constructor with given info
   
   public String[] getElementsArr() {
      String[] arr = {this.name, this.address, this.city, this.phoneNum};
      //String[] arr = {"n","a","c","p"};
      return arr;
   } // end of getElements method
   
   
   public void setElements(String[] elementsArr) {
      this.name = elementsArr[0];
      this.address = elementsArr[1];
      this.city = elementsArr[2];
      this.phoneNum = elementsArr[3];
   }
   
   //public int
   
   
   //public int getData() {
   //   return data;
   //}
   
   //public void setData(int data) {
   //   this.data = data;
   //}

   
   
   
} // end of class