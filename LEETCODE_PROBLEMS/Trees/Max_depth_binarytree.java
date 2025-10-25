import java.util.LinkedList;
import java.util.Queue;

// Definition of TreeNode
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Max_depth_binarytree {

   
	int height(TreeNode root) {
	    if (root == null) return 0;

	    Queue<TreeNode> q = new LinkedList<>();    //creating a queue
	    q.add(root);                 //adding the root to queue
	    int noOfLevels = -1;             //At starting the no of levels is -1
 
	    while (!q.isEmpty()) {
	        int nodeCountAtLevel = q.size();  // Maintain count of nodes at each level

	        while (nodeCountAtLevel > 0) {
	            TreeNode element = q.poll();        

	            if (element.left != null) {
	                q.add(element.left);
	            }
	            if (element.right != null) {
	                q.add(element.right);
	            }
	            nodeCountAtLevel--;
	        }
	        noOfLevels++;
	    }

	    return noOfLevels; //  final return after BFS completes
	}



    // Driver code for testing
    public static void main(String[] args) {
    	Max_depth_binarytree tree = new Max_depth_binarytree();

        // Creating a sample tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Height of tree is: " + tree.height(root));
    }
}
