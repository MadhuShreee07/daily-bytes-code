

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
        this.next = null;
    }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}
//Use hare and tortoise Algorithm 
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        
        while (fast != null && fast.next != null) {
            slow = slow.next;      //slow ptr moves one step at a time
            fast = fast.next.next;   //fast ptr moves two step at a time
        }
        return slow;
    }
}

public class Middle_of_LL {
    public static void main(String[] args) {
       
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution sol = new Solution();
        ListNode middle = sol.middleNode(head);

        System.out.println("Middle node value: " + middle.val);
    }
}
