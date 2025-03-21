import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class Pair {
    TreeNode node;
    int col, row;

    public Pair(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

public class l_Vertical_order_traversal_of_BT_ {

    public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            int col = p.col, row = p.row;

            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new ArrayList<>());
            map.get(col).get(row).add(node.val);

            if (node.left != null) queue.offer(new Pair(node.left, col - 1, row + 1));
            if (node.right != null) queue.offer(new Pair(node.right, col + 1, row + 1));
        }

        for (TreeMap<Integer, List<Integer>> levelMap : map.values()) {
            List<Integer> colValues = new ArrayList<>();
            for (List<Integer> nodes : levelMap.values()) {
                Collections.sort(nodes);  // Sort nodes if they have the same column and level
                colValues.addAll(nodes);
            }
            result.add(colValues);
        }

        return result;
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.right = new TreeNode(11);

        System.out.println("Vertical Order Traversal: " + verticalOrderTraversal(root));
    }
}
