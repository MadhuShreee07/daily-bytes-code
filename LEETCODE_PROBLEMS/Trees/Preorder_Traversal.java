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

public class Preorder_Traversal {

    // 1. Preorder Traversal (Root -> Left -> Right)
    public List<Integer> preorderTraversal(Treenode root) {
        List<Integer> preorder = new ArrayList<>();  // to store the printed values
        if (root == null) return preorder;           // Tree is Empty

        Stack<Treenode> st = new Stack<>();          // to iterate
        st.push(root);                               // Initially push the root

        while (!st.isEmpty()) {                      // keep iterating until stack is non empty
            Treenode node = st.pop();                // get the top-most element
            preorder.add(node.val);                  // add it to the list

            // Push right first so left is processed first
            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
        }
        return preorder;
    }

    public static void main(String args[]) {
       
        Treenode root = new Treenode(1);
        root.left = new Treenode(2);
        root.right = new Treenode(3);
        root.left.left = new Treenode(4);
        root.left.right = new Treenode(5);
        root.right.right = new Treenode(6);

        Preorder_Traversal pt = new Preorder_Traversal();
        List<Integer> result = pt.preorderTraversal(root);

        System.out.println("Preorder Traversal: " + result);
    }
}
