
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedList_cycle {

    // Function to detect cycle in a linked list
    public static boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            // Move slow by 1 step
            slowPtr = slowPtr.next;
            // Move fast by 2 steps
            fastPtr = fastPtr.next.next;

            // If they meet, cycle exists
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    // Main method to test the function
    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Case 1: No cycle
       System.out.println("Cycle detected:" + hasCycle(head)); 

        // Case 2: Create a cycle (5 -> 2)
        head.next.next.next.next.next = head.next;
        System.out.println("Cycle detected:" + hasCycle(head));
    }
}

