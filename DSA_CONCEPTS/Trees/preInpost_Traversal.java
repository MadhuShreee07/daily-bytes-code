
import java.util.*;


class Treeenode {
    int val;
    Treeenode left, right;
    Treeenode(int val) {
        this.val = val;
        left = right = null;
    }
}

// Helper Pair class to store node and its traversal state
class Pair {
    Treeenode node;
    int num;
    Pair(Treeenode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class preInpost_Traversal {
	
    public void preInPostTraversal(Treeenode root) {
        if (root == null) return;

        Stack<Pair> st = new Stack<>();   //stores(node,num)
        st.push(new Pair(root, 1));

        List<Integer> pre = new ArrayList<>();     //creating 3 list for each one of them
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // Preorder: num = 1        
            //increment 1 to 2
            //push it left side of the tree
            if (it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it); // push back with updated state
                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }
            // Inorder: num = 2
            //increment 2 to 3
            //push the right   side of the tree
            else if (it.num == 2) {
                in.add(it.node.val);
                it.num++;
                st.push(it); // push back with updated state
                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            // Postorder: num = 3
            //dont push it back again
            else {
                post.add(it.node.val);
            }
        }

        // Print results
        System.out.println("Preorder:  " + pre);
        System.out.println("Inorder:   " + in);
        System.out.println("Postorder: " + post);
    }

    public static void main(String[] args) {
      
        Treeenode root = new Treeenode(1);
        root.left = new Treeenode(2);
        root.right = new Treeenode(3);
        root.left.left = new Treeenode(4);
        root.left.right = new Treeenode(5);
        root.right.right = new Treeenode(6);

        preInpost_Traversal sol = new preInpost_Traversal();
        sol.preInPostTraversal(root);
    }
}
