public class b_Tree_Traversal_ {

  static class Node{
    int data;
    Node left, right;

    Node(int newData){
      this.data = newData;
      this.left = null;
      this.right = null;
    }
  }

  public static void preOrder(Node root){
    if(root == null) return;
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  public static void inOrder(Node root){
    if(root == null) return;
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public static void postOrder(Node root){
    if(root == null) return;
    preOrder(root.left);
    preOrder(root.right);
    System.out.print(root.data + " ");
  }


  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(5);

    preOrder(root);
    System.out.println();
    inOrder(root);
    System.out.println();
    postOrder(root);
  }
}
