import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Tnode {
    int val;
    Tnode left, right;

    Tnode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Inorder_Traversal {

    // 1. Inorder Traversal (Left -> Root -> Right)
    public List<Integer> inorderTraversal(Tnode root) {
    	 List<Integer> inorder = new ArrayList<>();  //to store the printed values
         Stack<Tnode> st = new Stack<>();
         Tnode cur = root;

         while (true) {
             if (cur != null) {      //If the node is not null
                 st.push(cur);            //push into the stack
                 cur = cur.left;         //Keep moving left        
             } else {
             	if(st.isEmpty()) {         //no nodes to travel
             		break;
             	}
                 cur = st.pop();           //getting the top element
                 inorder.add(cur.val);        //adding it to the list
                 cur = cur.right;       //move right
             }
         }
         return inorder;
     }
    public static void main(String[] args) {
        // Build tree
        Tnode root = new Tnode(1);
        root.left = new Tnode(2);
        root.right = new Tnode(3);
        root.left.left = new Tnode(4);
        root.left.right = new Tnode(5);
        root.right.right = new Tnode(6);

        // Run inorder traversal
        Inorder_Traversal it = new Inorder_Traversal();
        List<Integer> result = it.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
    }
}
