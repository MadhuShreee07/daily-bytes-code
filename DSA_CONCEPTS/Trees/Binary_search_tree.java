

//IN BINARY SEARCH TREE INORDER TRAVERSAL - SORTED ELEMENTS
class BSTNode {
    int key;
    BSTNode left, right;

    public BSTNode(int item) {
        key = item;
        left = right = null;
    }
}

public class Binary_search_tree {

    // Insert a key into BST
    static BSTNode insertKey(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
        if (key < root.key)
            root.left = insertKey(root.left, key);
        else if (key > root.key)
            root.right = insertKey(root.right, key);

        return root;
    }

    // Delete a key from BST
    static BSTNode deleteKey(BSTNode root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteKey(root.left, key);
        else if (key > root.key)
            root.right = deleteKey(root.right, key);
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);
            root.right = deleteKey(root.right, root.key);
        }
        return root;
    }

    // min value in subtree
    static int minValue(BSTNode root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Find the maximum value in BST
    static int max(BSTNode root) {
        while (root.right != null)
            root = root.right;
        return root.key;
    }

    // Search for a single key in BST
    static BSTNode search(BSTNode root, int key) {
        if (root == null)    //empty 
            return null;
        else if (key == root.key)   
            return root;
        else if (key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // Search and return subtree (code is same as search for a single key but the diff is how we show the result)
    static BSTNode searchSubtree(BSTNode root, int key) {
        if (root == null) return null;
        if (key == root.key) return root;
        else if (key < root.key) return searchSubtree(root.left, key);
        else return searchSubtree(root.right, key);
    }

    // Inorder Traversal (for testing)
    static void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BSTNode root = null;

        // Insert nodes
        root = insertKey(root, 50);
        root = insertKey(root, 30);
        root = insertKey(root, 70);
        root = insertKey(root, 20);
        root = insertKey(root, 40);
        root = insertKey(root, 60);
        root = insertKey(root, 80);

        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();

        // ----- Search for single element -----
        int key = 40;
        BSTNode found = search(root, key);
        if (found != null)
            System.out.println(key + " found in BST (single node search)");
        else
            System.out.println(key + " not found in BST");

        // ----- Search and return subtree -----
        int subtreeRootKey = 30;
        BSTNode subtree = searchSubtree(root, subtreeRootKey);
        System.out.print("Inorder traversal of subtree rooted at " + subtreeRootKey + ": ");
        inorder(subtree);
        System.out.println();

        // Find max
        System.out.println("Maximum value in BST: " + max(root));

        // Delete
        root = deleteKey(root, 20);
        System.out.print("After deleting 20: ");
        inorder(root);
        System.out.println();

        root = deleteKey(root, 30);
        System.out.print("After deleting 30: ");
        inorder(root);
        System.out.println();

        root = deleteKey(root, 50);
        System.out.print("After deleting 50: ");
        inorder(root);
        System.out.println();
    }
}
