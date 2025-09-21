// Define the BSTNode class
class BSTNode {
    int key;
    BSTNode left, right;

    BSTNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class Search_BST {

    // ----- Recursive method to search for a subtree -----
    static BSTNode searchSubtree(BSTNode root, int key) {
        if (root == null) return null;
        if (key == root.key) return root;
        else if (key < root.key) return searchSubtree(root.left, key);
        else return searchSubtree(root.right, key);
    }

    // ----- Iterative method to search for a subtree -----
    static BSTNode searchSubtreeIterative(BSTNode root, int key) {
        while (root != null) {
            if (key == root.key) {
                return root;
            } else if (key < root.key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null; // Key not found
    }

    // ----- Inorder traversal -----
    static void inorder(BSTNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    // ----- Main method -----
    public static void main(String[] args) {
        // Construct the BST
        BSTNode root = new BSTNode(50);
        root.left = new BSTNode(30);
        root.right = new BSTNode(70);
        root.left.left = new BSTNode(20);
        root.left.right = new BSTNode(40);
        root.right.left = new BSTNode(60);
        root.right.right = new BSTNode(80);

        int subtreeRootKey = 30;

        // Recursive search
        BSTNode subtreeRec = searchSubtree(root, subtreeRootKey);
        System.out.print("Recursive Inorder traversal of subtree rooted at " + subtreeRootKey + ": ");
        inorder(subtreeRec);
        System.out.println();

        // Iterative search
        BSTNode subtreeIter = searchSubtreeIterative(root, subtreeRootKey);
        System.out.print("Iterative Inorder traversal of subtree rooted at " + subtreeRootKey + ": ");
        inorder(subtreeIter);
        System.out.println();
    }
}
