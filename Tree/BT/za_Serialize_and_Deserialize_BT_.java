import java.util.*;

public class za_Serialize_and_Deserialize_BT_ {

    // Definition for a Tree Node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int value) {
            this.val = value;
            this.left = this.right = null;
        }
    }

    // Class that implements serialization and deserialization
    static class Codec {

        // Serialize function: Converts Tree to String
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeHelper(root, sb);
            return sb.toString();
        }

        // Helper function for preorder serialization
        private void serializeHelper(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("#,"); // Use "#" for null nodes
                return;
            }
            sb.append(node.val).append(","); // Store current node value
            serializeHelper(node.left, sb);  // Serialize left subtree
            serializeHelper(node.right, sb); // Serialize right subtree
        }

        // Deserialize function: Converts String back to Tree
        public TreeNode deserialize(String data) {
            Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserializeHelper(nodes);
        }

        // Helper function for preorder deserialization
        private TreeNode deserializeHelper(Queue<String> nodes) {
            if (nodes.isEmpty()) return null;

            String val = nodes.poll(); // Get the next value
            if (val.equals("#")) return null; // If null marker, return null

            TreeNode node = new TreeNode(Integer.parseInt(val)); // Create node
            node.left = deserializeHelper(nodes);  // Reconstruct left subtree
            node.right = deserializeHelper(nodes); // Reconstruct right subtree

            return node;
        }
    }

    // Function to print the inorder traversal of the tree (for verification)
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        // Sample Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();

        // Serialize the tree
        String serializedTree = codec.serialize(root);
        System.out.println("Serialized Tree: " + serializedTree);

        // Deserialize back to tree
        TreeNode deserializedRoot = codec.deserialize(serializedTree);

        // Print inorder traversal of deserialized tree
        System.out.print("Inorder traversal of deserialized tree: ");
        printInorder(deserializedRoot);
    }
}
