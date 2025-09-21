
class AVLNode {
    int key, height;      
    AVLNode left, right;  

    AVLNode(int d) {
        key = d;
        height = 1;       // new node is initially a leaf, so height = 1
    }
}

public class AVL_Trees {
    AVLNode root; // root of the AVL tree

    // -------------------- Utility Functions ----------------

    // Get height of a node
    int height(AVLNode N) {
        if (N == null) return 0; // null node has height 0
        return N.height;
    }

    // Get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Get balance factor of a node: left subtree height - right subtree height
    int getBalance(AVLNode N) {
        if (N == null) return 0;
        return height(N.left) - height(N.right);
    }

    // -------------------- Rotations --------------------

    // Right rotation for LL imbalance
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;   // x will become new root
        AVLNode T2 = x.right; // temporarily store subtree

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotation for RR imbalance
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;  // y becomes new root
        AVLNode T2 = y.left;  // temporarily store subtree

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // -------------------- Insert Operation --------------------

    // Insert a key into the AVL tree and return new root
    AVLNode insert(AVLNode node, int key) {
        // 1. Perform normal BST insertion
        if (node == null) return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // duplicates not allowed

        // 2. Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // 3. Get balance factor to check if node became unbalanced
        int balance = getBalance(node);

        // 4. If unbalanced, apply rotations

        // Case 1: Left Left (LL)
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Case 2: Right Right (RR)
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Case 3: Left Right (LR)
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Case 4: Right Left (RL)
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return unchanged node
        return node;
    }

    // -------------------- Delete Operation --------------------

    // Find node with minimum key value in subtree
    AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    // Delete a key from the AVL tree and return new root
    AVLNode deleteNode(AVLNode root, int key) {
        // 1. Perform standard BST delete
        if (root == null) return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            // Node found: handle cases

            // Node with only one child or no child
            if (root.left == null || root.right == null) {
                AVLNode temp = (root.left != null) ? root.left : root.right;
                root = temp; // could be null if no child
            } else {
                // Node with two children: get inorder successor
                AVLNode temp = minValueNode(root.right);
                root.key = temp.key; // copy successor's value
                root.right = deleteNode(root.right, temp.key); // delete successor
            }
        }

        // If tree had only one node
        if (root == null) return root;

        // 2. Update height
        root.height = max(height(root.left), height(root.right)) + 1;

        // 3. Get balance factor
        int balance = getBalance(root);

        // 4. Apply rotations if unbalanced
        if (balance > 1 && getBalance(root.left) >= 0) return rightRotate(root); // LL
        if (balance > 1 && getBalance(root.left) < 0) { // LR
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0) return leftRotate(root); // RR
        if (balance < -1 && getBalance(root.right) > 0) { // RL
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // -------------------- Traversals --------------------

    // Preorder traversal: Root, Left, Right
    void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

  
    public static void main(String[] args) {
        AVL_Trees tree = new AVL_Trees();

        // Insert nodes
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Preorder traversal of AVL tree:");
        tree.preOrder(tree.root);

        // Delete a node
        tree.root = tree.deleteNode(tree.root, 40);
        System.out.println("\nPreorder traversal after deleting 40:");
        tree.preOrder(tree.root);
    }
}
