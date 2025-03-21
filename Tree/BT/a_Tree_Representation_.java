public class a_Tree_Representation_{
  static class Node{
    int data;
    Node left, right;

    Node(int newData){
      this.data = newData;
      this.left = null;
      this.right = null;
    }
  }

  public static void main(String[] args){
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(5);
  }
}