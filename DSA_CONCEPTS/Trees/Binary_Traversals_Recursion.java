import java.util.LinkedList;
import java.util.Queue;

class TTreeNode {
    int data;
    TTreeNode left, right;

    public TTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Binary_Traversals_Recursion {
    TTreeNode root;

    // Preorder Traversal (Root -> Left -> Right)
    void preorder(TTreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder Traversal (Left -> Root -> Right)
    void inorder(TTreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder Traversal (Left -> Right -> Root)
    void postorder(TTreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Level Order Traversal (BFS)
    void levelOrder(TTreeNode root) {
        Queue<TTreeNode> queue = new LinkedList<>();

        queue.add(root); //start with the root node

        while (!queue.isEmpty()) { //Run the loop till queue is not empty 
            TTreeNode temp = queue.poll(); //removes and stores the element in temp

            System.out.print(temp.data + " "); //print the value

            if (temp.left != null)
                queue.add(temp.left); //Add left child to queue

            if (temp.right != null)
                queue.add(temp.right); //Add right child to queue
        }
    }

    // Level Order Insertion 
    void insertLevelOrder(TTreeNode temp, int key) {
        if (temp == null) {
            root = new TTreeNode(key);
            return;
        }

        Queue<TTreeNode> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find an empty place
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new TTreeNode(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new TTreeNode(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    // search an element
    public static TTreeNode search(TTreeNode root, int element) {
        if (root != null) {
            if (root.data == element) {
                System.out.println("Element " + element + " found!");
            } else {
                search(root.left, element);
                search(root.right, element);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Binary_Traversals_Recursion tree = new Binary_Traversals_Recursion();

        tree.root = new TTreeNode(1);
        tree.root.left = new TTreeNode(2);
        tree.root.right = new TTreeNode(3);
        tree.root.left.left = new TTreeNode(4);
        tree.root.left.right = new TTreeNode(5);
        tree.root.right.left = new TTreeNode(6);
        tree.root.right.right = new TTreeNode(7);

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

        int key = 5;
        System.out.println("\nSearching for " + key + "...");
        search(tree.root, key);

        System.out.println("\nInserting 8 using Level Order Insertion...");
        tree.insertLevelOrder(tree.root, 8);

        System.out.print("Level Order after insertion: ");
        tree.levelOrder(tree.root);
    }
}
