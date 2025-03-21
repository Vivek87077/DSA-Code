class Node {
  int value;
  Node prev, next;

  Node(int value) {
      this.value = value;
      this.prev = this.next = null;
  }
}

public class Find_pairs_with_given_sum_in_DLL_ {

  // Function to find pairs with a given sum
  public static void findPairsWithSum(Node head, int sum) {
      if (head == null) return;

      Node left = head;
      Node right = head;

      // Move right pointer to the last node
      while (right.next != null) {
          right = right.next;
      }

      boolean found = false;

      // Two-pointer approach
      while (left != null && right != null && left != right && right.next != left) {
          int pairSum = left.value + right.value;

          if (pairSum == sum) {
              System.out.println("(" + left.value + ", " + right.value + ")");
              found = true;
              left = left.next;
              right = right.prev;
          } else if (pairSum < sum) {
              left = left.next;
          } else {
              right = right.prev;
          }
      }

      if (!found) {
          System.out.println("No pairs found.");
      }
  }

  // Helper function to print DLL
  public static void printList(Node head) {
      Node temp = head;
      while (temp != null) {
          System.out.print(temp.value + " <=> ");
          temp = temp.next;
      }
      System.out.println("null");
  }

  public static void main(String[] args) {
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.prev = head;
      head.next.next = new Node(4);
      head.next.next.prev = head.next;
      head.next.next.next = new Node(5);
      head.next.next.next.prev = head.next.next;
      head.next.next.next.next = new Node(6);
      head.next.next.next.next.prev = head.next.next.next;
      head.next.next.next.next.next = new Node(8);
      head.next.next.next.next.next.prev = head.next.next.next.next;
      head.next.next.next.next.next.next = new Node(9);
      head.next.next.next.next.next.next.prev = head.next.next.next.next.next;

      System.out.println("Original DLL:");
      printList(head);

      int sum = 7;
      System.out.println("Pairs with sum " + sum + ":");
      findPairsWithSum(head, sum);
  }
}
