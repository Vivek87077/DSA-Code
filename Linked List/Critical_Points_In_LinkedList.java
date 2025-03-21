class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Critical_Points_In_LinkedList {
    
    public static int[] findMinMaxDistance(Node head) {
        if (head == null || head.next == null || head.next.next == null) return new int[]{-1, -1};

        int firstCritical = -1, lastCritical = -1, prevCritical = -1;
        int minDist = Integer.MAX_VALUE, maxDist = -1;
        int index = 1; // Start from second node
        Node prev = head;
        Node curr = head.next;

        while (curr.next != null) {
            // Check if it's a critical point
            if ((curr.value > prev.value && curr.value > curr.next.value) || 
                (curr.value < prev.value && curr.value < curr.next.value)) {

                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    minDist = Math.min(minDist, index - prevCritical);
                    maxDist = index - firstCritical;
                }

                prevCritical = index;
                lastCritical = index;
            }
            
            prev = curr;
            curr = curr.next;
            index++;
        }

        return (firstCritical == lastCritical) ? new int[]{-1, -1} : new int[]{minDist, maxDist};
    }

    // Helper function to print result array
    public static void printResult(int[] result) {
        System.out.println("Min Distance: " + result[0] + ", Max Distance: " + result[1]);
    }

    public static void main(String[] args) {
        // Creating linked list: 1 → 3 → 2 → 4 → 1 → 5 → 6 → 2
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(2);

        int[] result = findMinMaxDistance(head);
        printResult(result);
    }
}
