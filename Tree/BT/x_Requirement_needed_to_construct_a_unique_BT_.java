// Java program to explain the necessary requirements to construct a unique Binary Tree
public class x_Requirement_needed_to_construct_a_unique_BT_ {

  // Requirements for constructing a Unique Binary Tree:
  
  /*
   * 1. **Preorder + Inorder Traversal** OR **Postorder + Inorder Traversal** 
   *    - A Binary Tree can be uniquely constructed using:
   *      - Preorder + Inorder Traversal
   *      - Postorder + Inorder Traversal
   *    - Example:
   *      Inorder:    [D, B, E, A, F, C, G]
   *      Preorder:   [A, B, D, E, C, F, G]
   *      The unique binary tree can be reconstructed using these two orders.
   *
   * 2. **Preorder + Postorder Traversal (NOT Unique)**
   *    - Preorder + Postorder is NOT sufficient to uniquely determine a binary tree,
   *      unless additional constraints are provided (such as full binary tree condition).
   *
   * 3. **Level Order Traversal (NOT Sufficient)**
   *    - Level order traversal alone is NOT sufficient to construct a unique tree.
   *    
   * 4. **Only Inorder Traversal (NOT Unique)**
   *    - Inorder alone is not enough to construct a unique binary tree because multiple trees
   *      can have the same inorder traversal.
   *
   * 5. **A Full Binary Tree Can Be Constructed Uniquely from Preorder or Postorder + Inorder**
   *    - A full binary tree is a binary tree where every node has either 0 or 2 children.
   *    - Given that a tree is full, **Preorder + Postorder** can uniquely define the tree.
   *
   * 6. **A BST (Binary Search Tree) Can Be Constructed Uniquely Using Only Preorder OR Inorder OR Postorder**
   *    - If the tree is a BST, any single traversal (Preorder/Inorder/Postorder) is enough
   *      to reconstruct the tree uniquely.
   */
  
  public static void main(String[] args) {
      System.out.println("Understanding the requirements to construct a unique Binary Tree:");
      System.out.println("✅ Preorder + Inorder OR Postorder + Inorder can construct a unique BT.");
      System.out.println("❌ Preorder + Postorder alone is NOT sufficient.");
      System.out.println("❌ Inorder alone is NOT sufficient.");
      System.out.println("✅ A Full Binary Tree can be uniquely determined with Preorder + Postorder.");
      System.out.println("✅ A BST can be uniquely reconstructed with any one of (Preorder, Inorder, or Postorder).");
  }
}
