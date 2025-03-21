class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Merge_2_Sorted_LL_in_Reverse_order_ {

    public static ListNode mergeReverse(ListNode first, ListNode second) {
        ListNode result = null; // Head of the reversed merged list

        while (first != null && second != null) {
            if (first.value < second.value) {
                ListNode temp = first.next;
                first.next = result;
                result = first;
                first = temp;
            } else {
                ListNode temp = second.next;
                second.next = result;
                result = second;
                second = temp;
            }
        }

        // If any list remains, insert it into the result
        while (first != null) {
            ListNode temp = first.next;
            first.next = result;
            result = first;
            first = temp;
        }

        while (second != null) {
            ListNode temp = second.next;
            second.next = result;
            result = second;
            second = temp;
        }

        return result;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // First sorted list: 1 -> 3 -> 5
        ListNode first = new ListNode(1);
        first.next = new ListNode(3);
        first.next.next = new ListNode(5);

        // Second sorted list: 2 -> 4 -> 6
        ListNode second = new ListNode(2);
        second.next = new ListNode(4);
        second.next.next = new ListNode(6);

        ListNode merged = mergeReverse(first, second);
        System.out.print("Merged Reverse Sorted List: ");
        printList(merged);
    }
}
