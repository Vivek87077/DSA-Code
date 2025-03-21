class Node{
  int data;
  Node next;

  Node(int newData){
    this.data = newData;
    this.next = null;
  }
}
public class f_Find_Middle_Node_ {
  // Helping function to calculate length of list
  public static int findLengthOfList(Node head){
    int cnt = 0;
    while(head != null){
      cnt++;
      head = head.next;
    }
    return cnt;
  }

  // find middle node using brute force approach 
  // In actually we are determining the linked list from middle node & this middle node is SECOND middle (for even number)
  public static Node findMiddle(Node head){
    Node temp = head;
    int len = findLengthOfList(head);
    for(int i = 0; i < len/2; i++){
      temp = temp.next;
    }
    return temp;
  }

  // find middle node using optimal approach 
  public static Node findMiddleTortoiseAndHare(Node head){
    Node tortoise = head;
    Node hare = head;
    while(hare.next != null && hare != null){
      hare = hare.next.next;
      tortoise = tortoise.next;
    }
    return tortoise;
  }

  // Remove Middle Node 
  public static Node removeMiddle(Node head){
    if(head == null || head.next == null){
      return null; // List has 0 or 1 node, can't remove middle
    }
    
    Node tortoise = head;
    Node hare = head;
    Node prevTortoise = null;
    while(hare.next != null && hare.next.next != null){
      hare = hare.next.next;
      prevTortoise = tortoise;
      tortoise = tortoise.next;
    }

    if(hare.next == null){
      prevTortoise.next = tortoise.next;
    }else{
      prevTortoise.next = tortoise.next.next;
    }

    return head;
  }

  public static void printList(Node head){
    while(head != null){
      System.out.print(head.data+" ");
      head = head.next;
    }
  }


  public static void main(String[] args) {
    Node head = new Node(10);
    head.next = new Node(20);
    head.next.next = new Node(30);
    head.next.next.next = new Node(40);
    head.next.next.next.next = new Node(50);
    
    // Node ans = findMiddle(head);

    // Node ans = findMiddleTortoiseAndHare(head);

    Node ans = removeMiddle(head);

    printList(ans);

  }
}
