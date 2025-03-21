class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Linked_List_CycleII_Start_cycle_node {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head;

        // Step 1: Detect cycle using slow & fast pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move 1 step
            fast = fast.next.next;    // Move 2 steps

            if (slow == fast) { // Cycle detected
                slow = head;  // Step 2: Reset slow to head
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Meeting point = start of the cycle
            }
        }
        return null; // No cycle
    }

    public static void main(String[] args) {
        // Example 1: Cycle exists (Cycle starts at node with value 2)
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next; // Creating a cycle at node 2

        ListNode cycleNode = detectCycle(head);
        System.out.println("Cycle starts at node with value: " + (cycleNode != null ? cycleNode.value : "No Cycle"));

        // Example 2: No cycle
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);

        ListNode cycleNode2 = detectCycle(head2);
        System.out.println("Cycle starts at node with value: " + (cycleNode2 != null ? cycleNode2.value : "No Cycle"));
    }
}
