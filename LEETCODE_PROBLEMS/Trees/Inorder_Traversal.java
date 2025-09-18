
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Treenode {
    int val;
    Treenode left, right;

    Treenode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Inorder_Traversal {

    // 1. Inorder Traversal (Left -> Root -> Right)
    public List<Integer> inorderTraversal(Treenode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<Treenode> st = new Stack<>();
        Treenode cur = root;

        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;  // go to left subtree
            } else {
                cur = st.pop();   // process node
                inorder.add(cur.val);
                cur = cur.right;  // go to right subtree
            }
        }
        return inorder;
    }

    public static void main(String args[]) {
        // Constructing a sample tree:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        Treenode root = new Treenode(1);
        root.left = new Treenode(2);
        root.right = new Treenode(3);
        root.left.left = new Treenode(4);
        root.left.right = new Treenode(5);
        root.right.right = new Treenode(6);

        Inorder_Traversal it = new Inorder_Traversal();
        List<Integer> result = it.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
    }
}
