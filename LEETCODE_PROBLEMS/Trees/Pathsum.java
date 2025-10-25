
import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode(int val) {
        this.val = val;
        left=right=null;
    }
}

public class Pathsum {

	
	//TC-O(n) SC-O(n)
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;      //no path hence it is false 

        Stack<TreeNode> path = new Stack<>();    //to maintain order of all nodes
        Stack<Integer> sumpath = new Stack<>();   //to maintain sum at each node

        path.push(root);
        sumpath.push(root.val);

        while (!path.isEmpty()) {
            TreeNode temp = path.pop();
            int tempval = sumpath.pop();
 
            if (temp.left == null && temp.right == null && tempval == targetSum)
                return true;                    // If it's a leaf node and sum matches

            if (temp.right != null) {
                path.push(temp.right);
                sumpath.push(tempval + temp.right.val);
            }

            if (temp.left != null) {
                path.push(temp.left);
                sumpath.push(tempval + temp.left.val);
            }
        }

        return false;
    }

    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

       
        int targetSum = 22;

        boolean result = hasPathSum(root, targetSum);
        System.out.println("Has path sum = " + targetSum + " ? " + result);
    }
}
