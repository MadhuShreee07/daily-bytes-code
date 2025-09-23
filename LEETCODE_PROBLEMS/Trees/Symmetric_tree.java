import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node
class TreeNodde {
    int val;
    TreeNodde left;
    TreeNodde right;

    TreeNodde(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Symmetric_tree {

    // Iterative BFS approach
    public boolean isSymmetric(TreeNodde root) {
        if (root == null) return true;

        Queue<TreeNodde> leftTree = new LinkedList<>();
        Queue<TreeNodde> rightTree = new LinkedList<>();

        leftTree.add(root.left);
        rightTree.add(root.right);

        while (!leftTree.isEmpty() && !rightTree.isEmpty()) {
            TreeNodde leftNode = leftTree.poll();
            TreeNodde rightNode = rightTree.poll();

            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;

            // Enqueue children in mirrored order
            leftTree.add(leftNode.left);
            leftTree.add(leftNode.right);

            rightTree.add(rightNode.right);
            rightTree.add(rightNode.left);
        }

        return leftTree.isEmpty() && rightTree.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
        Symmetric_tree st = new Symmetric_tree();

        // Symmetric Tree Example
        TreeNodde root = new TreeNodde(1);
        root.left = new TreeNodde(2);
        root.right = new TreeNodde(2);
        root.left.left = new TreeNodde(3);
        root.left.right = new TreeNodde(4);
        root.right.left = new TreeNodde(4);
        root.right.right = new TreeNodde(3);

        System.out.println(st.isSymmetric(root)); 
    }
}
