
import java.util.HashSet;
import java.util.Set;


class ListNode {
    int val;
    ListNode next;

    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Intersection_Two_LL {

    
     // Time Complexity: O(m + n), Space Complexity: O(m)
     
	//using Hashset BRUTE FORCE
    public ListNode getIntersectionNodeSet(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Set<ListNode> nodeAddress = new HashSet<>();

      
        while (headA != null) {                 //Store all nodes of list A in a HashSet.
            nodeAddress.add(headA);
            headA = headA.next;
        }

      
        while (headB != null) {                     //Then traverse list B and check if any node is already in the set.
            if (nodeAddress.contains(headB)) {
                // Intersection found
                return headB;
            }
            headB = headB.next;
        }

        // No intersection
        return null;
    }

     //Time Complexity: O(m + n), Space Complexity: O(1)
     
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        // Move headA forward if list A is longer
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        // Move headB forward if list B is longer
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        // Now both heads are equidistant from the end
        // Move both pointers until they meet at intersection or reach end (null)
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // Either intersection node or null if no intersection
        return headA;
    }

    //  calculate length of a linked list
    private int getListLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    // Test example
    public static void main(String[] args) {
    	Intersection_Two_LL solution = new Intersection_Two_LL();

        // Create list A: 1 -> 2 -> 3
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);

        // Create list B: 6 -> 3 (intersecting at node with value 3)
        ListNode headB = new ListNode(6);
        headB.next = headA.next.next; // point to node 3 in list A

        // Test Approach 1
        ListNode intersection1 = solution.getIntersectionNodeSet(headA, headB);
        // Test Approach 2
        ListNode intersection2 = solution.getIntersectionNode(headA, headB);

        System.out.println("Intersection using HashSet: " + (intersection1 != null ? intersection1.val : "No Intersection"));
        System.out.println("Intersection using length method: " + (intersection2 != null ? intersection2.val : "No Intersection"));
    }
}
