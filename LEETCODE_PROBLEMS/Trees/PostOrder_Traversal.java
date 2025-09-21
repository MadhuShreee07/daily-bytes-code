import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Treeenode {
    int val;
    Treeenode left, right;

    Treeenode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class PostOrder_Traversal {

    
    public List<Integer> postorderTraversalTwoStacks(Treeenode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) return postorder;

        Stack<Treeenode> st1 = new Stack<>();
        Stack<Treeenode> st2 = new Stack<>();
        st1.push(root);

        while (!st1.isEmpty()) {
            Treeenode node = st1.pop();
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
       

        Treeenode root = new Treeenode(1);
        root.left = new Treeenode(2);
        root.right = new Treeenode(3);
        root.left.left = new Treeenode(4);
        root.left.right = new Treeenode(5);
        root.right.right = new Treeenode(6);

        PostOrder_Traversal pt = new PostOrder_Traversal();
        List<Integer> result = pt.postorderTraversalTwoStacks(root);

        System.out.println("Postorder Traversal: " + result);
    }
}
