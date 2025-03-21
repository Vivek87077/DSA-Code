class ListNode {
  int value;
  ListNode next;

  ListNode(int value) {
      this.value = value;
      this.next = null;
  }
}

public class Linked_List_Cycle_detection_ {

  public static boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) return false; // No cycle if 0 or 1 node

      ListNode slow = head;
      ListNode fast = head;

      while (fast != null && fast.next != null) {
          slow = slow.next; // Move 1 step
          fast = fast.next.next; // Move 2 steps

          if (slow == fast) return true; // Cycle detected
      }

      return false; // No cycle
  }

  public static void main(String[] args) {
      // Example 1: List with a cycle (1 -> 2 -> 3 -> 4 -> back to 2)
      ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(3);
      head.next.next.next = new ListNode(4);
      head.next.next.next.next = head.next; // Creating a cycle

      System.out.println("Has Cycle? " + hasCycle(head)); // Output: true

      // Example 2: List without a cycle (1 -> 2 -> 3 -> 4 -> null)
      ListNode head2 = new ListNode(1);
      head2.next = new ListNode(2);
      head2.next.next = new ListNode(3);
      head2.next.next.next = new ListNode(4);

      System.out.println("Has Cycle? " + hasCycle(head2)); // Output: false
  }
}
