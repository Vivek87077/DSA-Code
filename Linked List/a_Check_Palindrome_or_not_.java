class Node{
  int data;
  Node next;

  Node(int newData){
    this.data = newData;
    this.next = null;
  }
}

/*  Approach to Check Palindrome -> 
    1. Find the Middle of the Linked List.
    2. Reverse the Second Half of the List.
    3. Compare the First Half and the Reversed Second Half.
    4. Restore the List (Optional).
    5. Return true if both halves are identical, else return false.

*/

public class a_Check_Palindrome_or_not_ {
  // Helping Function to reverse of list
  public static Node reverse(Node head){
    Node temp = head;
    Node prev = null;
    while(temp != null){
      Node front = temp.next;
      temp.next = prev;
      prev = temp;
      temp = front;
    }
    return prev;
  }

  public static boolean checkPalindrome(Node head){
    // Middle of list
    Node slow = head;
    Node fast = head;
    while(fast.next != null && fast != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    // Reverse the Second Half of list
    Node secondHalf = reverse(slow);
    // Compare the First Half and the Reversed Second Half.
    Node firstHalf = head;
    Node tempSecondHalf = secondHalf;

    while (secondHalf != null) {
      if (firstHalf.data != secondHalf.data) {
          return false; // Mismatch found
      }
      firstHalf = firstHalf.next;
      secondHalf = secondHalf.next;
    }
    // Restore the List (Optional)
    reverse(tempSecondHalf);

    return true;
  }
  

  public static void printList(Node head){
    while(head != null){
      System.out.print(head.data+" ");
      head = head.next;
    }
  }
  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(4);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(1);

    System.out.println(checkPalindrome(head));
  }
}
