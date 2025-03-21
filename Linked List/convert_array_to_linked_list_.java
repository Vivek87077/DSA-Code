class Node{
  int data;
  Node next;

  Node(int newData){
    this.data = newData;
    this.next = null;
  }
}
public class convert_array_to_linked_list_ {
  public static Node convertArrayToLinkedList(int[] arr){
    if(arr.length == 0){
      return null;
    }

    Node head = new Node(arr[0]);
    Node temp = head;

    for(int i = 1; i < arr.length; i++){
      temp.next = new Node(arr[i]);
      temp = temp.next;
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
    int[] arr = {1, 2, 3, 2, 1};
    Node ans = convertArrayToLinkedList(arr);
    printList(ans);
  }
}
