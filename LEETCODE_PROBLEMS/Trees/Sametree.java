
import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node
class TreeNoode {
    int val;
    TreeNoode left;
    TreeNoode right;

    TreeNoode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Sametree {

    // Iterative BFS approach
    public boolean isSameTree(TreeNoode root1, TreeNoode root2) {
        Queue<TreeNoode> q = new LinkedList<>();
        q.add(root1);
        q.add(root2);

        while (!q.isEmpty()) {
            TreeNoode first = q.poll();
            TreeNoode second = q.poll();

            if (first == null && second == null) {
                continue; // both are null, skip
            }
            if (first == null || second == null || first.val != second.val) {
                return false; // mismatch found
            }

            // add children in the same order
            q.add(first.left);
            q.add(second.left);
            q.add(first.right);
            q.add(second.right);
        }
        return true;
    }

    // Example usage
    public static void main(String[] args) {
    	Sametree st = new Sametree();

        // Tree 1
        TreeNoode root1 = new TreeNoode(1);
        root1.left = new TreeNoode(2);
        root1.right = new TreeNoode(3);

        // Tree 2
        TreeNoode root2 = new TreeNoode(1);
        root2.left = new TreeNoode(2);
        root2.right = new TreeNoode(3);

        System.out.println(st.isSameTree(root1, root2)); // true
    }
}

