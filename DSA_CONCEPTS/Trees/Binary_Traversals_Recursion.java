import java.util.LinkedList;
import java.util.Queue;

//size=total no of nodes
//height= max no of edges
//height=level-1
class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Binary_Traversals_Recursion {
    TreeNode root;

    // Preorder Traversal (Root -> Left -> Right)
    void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder Traversal (Left -> Root -> Right)
    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder Traversal (Left -> Right -> Root)
    void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Level Order Traversal (BFS)
    void levelOrder(TreeNode root) {
           Queue<TreeNode> queue = new LinkedList<>();
       
            queue.add(root);  //start with the root node

        while (!queue.isEmpty()) {    //Run the loop till queue is not empty 
            TreeNode temp = queue.poll();
            
            System.out.print(temp.data + " ");   //print the value

            if (temp.left != null) 
            	queue.add(temp.left);     //Add left child to queue
            
            if (temp.right != null) 
            	queue.add(temp.right);    //Add right child to queue
        }
    }
    
    // DFS Search
    boolean dfsSearch(TreeNode root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return dfsSearch(root.left, key) || dfsSearch(root.right, key);
    }

    public static void main(String[] args) {
        Binary_Traversals_Recursion tree = new  Binary_Traversals_Recursion();

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        System.out.print("Preorder: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Postorder: ");
        tree.postorder(tree.root);
        System.out.println();

        System.out.print("Level Order: ");
        tree.levelOrder(tree.root);
        System.out.println();
        
        // Testing DFS Search
        int key = 5;
        if (tree.dfsSearch(tree.root, key)) {
            System.out.println(key + " found in tree (DFS)");
        } else {
            System.out.println(key + " not found in tree (DFS)");
        }
    }
}
//RETURN it will go to next line