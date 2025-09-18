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

public class PostOrder_Traversal {

    // Postorder Traversal using Two Stacks (Left -> Right -> Root)
    public List<Integer> postorderTraversalTwoStacks(Treenode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) return postorder;

        Stack<Treenode> st1 = new Stack<>();
        Stack<Treenode> st2 = new Stack<>();
        st1.push(root);

        while (!st1.isEmpty()) {
            Treenode node = st1.pop();
            st2.push(node);

            if (node.left != null) st1.push(node.left);
            if (node.right != null) st1.push(node.right);
        }

        while (!st2.isEmpty()) {
            postorder.add(st2.pop().val);
        }
        return postorder;
    }

    public static void main(String args[]) {
       

        Treenode root = new Treenode(1);
        root.left = new Treenode(2);
        root.right = new Treenode(3);
        root.left.left = new Treenode(4);
        root.left.right = new Treenode(5);
        root.right.right = new Treenode(6);

        PostOrder_Traversal pt = new PostOrder_Traversal();
        List<Integer> result = pt.postorderTraversalTwoStacks(root);

        System.out.println("Postorder Traversal: " + result);
    }
}
