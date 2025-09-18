import java.util.*;


class Treenode {
    int val;
    Treenode left, right;
    Treenode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Traversals_Iterative {

    // 1. Preorder Traversal (Root -> Left -> Right)
    public List<Integer> preorderTraversal(Treenode root) {
        List<Integer> preorder = new ArrayList<>();  //to store the printed values
        if (root == null) return preorder;     //Tree is Empty

        Stack<Treenode> st = new Stack<>();  //to iterate it
        st.push(root);         //Initially push the root

        while (!st.isEmpty()) {         //keep on iterating until stack is non empty
            Treenode node = st.pop();      //got the top most element from stack
            preorder.add(node.val);         //Adding it to the list

            if (node.right != null) st.push(node.right);
            if (node.left != null) st.push(node.left);
        }
        return preorder;
    }

    // 2. Inorder Traversal (Left -> Root -> Right)
    public List<Integer> inorderTraversal(Treenode root) {
        List<Integer> inorder = new ArrayList<>();  //to store the printed values
        Stack<Treenode> st = new Stack<>();
        Treenode cur = root;

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

    // 3. Postorder Traversal using Two Stacks (Left -> Right -> Root)
    public List<Integer> postorderTraversalTwoStacks(Treenode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) return postorder;

        Stack<Treenode> st1 = new Stack<>();
        Stack<Treenode> st2 = new Stack<>();
        st1.push(root);

        while (!st1.isEmpty()) {
            Treenode node = st1.pop();     //taken the top most element
            st2.push(node);       //pushed it in stack 2

            if (node.left != null) st1.push(node.left);
            if (node.right != null) st1.push(node.right);
        }

        while (!st2.isEmpty()) {         //pop out every element from stack 2 nd put it in stack 1
            postorder.add(st2.pop().val);
        }
        return postorder;
    }

    // 4. Postorder Traversal using One Stack (Left -> Right -> Root)
    public List<Integer> postorderTraversalOneStack(Treenode root) {
        List<Integer> postorder = new ArrayList<>();
        Stack<Treenode> st = new Stack<>();
        Treenode cur = root, lastVisited = null;

        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                Treenode peekNode = st.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    cur = peekNode.right;
                } else {
                    postorder.add(peekNode.val);
                    lastVisited = st.pop();
                }
            }
        }
        return postorder;
    }

   
    public static void main(String[] args) {
       
        Treenode root = new Treenode(1);
        root.left = new Treenode(2);
        root.right = new Treenode(3);
        root.left.left = new Treenode(4);
        root.left.right = new Treenode(5);
        root.right.right = new Treenode(6);

        Traversals_Iterative t = new Traversals_Iterative();

        System.out.println("Preorder:  " + t.preorderTraversal(root));        // [1, 2, 4, 5, 3, 6]
        System.out.println("Inorder:   " + t.inorderTraversal(root));         // [4, 2, 5, 1, 3, 6]
        System.out.println("Postorder (2 stacks): " + t.postorderTraversalTwoStacks(root)); // [4, 5, 2, 6, 3, 1]
        System.out.println("Postorder (1 stack):  " + t.postorderTraversalOneStack(root));  // [4, 5, 2, 6, 3, 1]
    }
}
