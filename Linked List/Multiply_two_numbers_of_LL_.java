
class Node {
  int data;
  Node next;

  Node(int data) {
      this.data = data;
      this.next = null;
  }
}

public class Multiply_two_numbers_of_LL_ {

  // Multiply contents of two linked lists
  static long multiplyTwoLists(Node first, Node second) {
      long MOD = 1000000007;
      long num1 = 0, num2 = 0;
    
      // Traverse the first list and 
        // construct the number with modulo
      while (first != null || second != null) {
          if (first != null) {
              num1 = ((num1 * 10) + first.data) % MOD;
              first = first.next;
          }
        
          // Traverse the second list and 
            // construct the number with modulo
          if (second != null) {
              num2 = ((num2 * 10) + second.data) % MOD;
              second = second.next;
          }
      }
    
        // Return the product of the two 
        // numbers with modulo
      return (num1 * num2) % MOD;
  }
  static void printList(Node curr) {
      while (curr != null) {
          System.out.print(curr.data + " ");
          curr = curr.next;
      }
  }

  public static void main(String args[]) {
    
      // create first list 9->4->6
      Node head1 = new Node(9);
      head1.next = new Node(4);
      head1.next.next = new Node(6);

      // create second list 8->4
      Node head2 = new Node(8);
      head2.next = new Node(4);
      System.out.println(multiplyTwoLists(head1, head2));
  }
}
