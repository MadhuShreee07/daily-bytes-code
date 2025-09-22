// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Remove_LL_Elements {

    // Remove all nodes with given value
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Create linked list using ListNode class
        ListNode r1 = new ListNode(1);
        r1.next = new ListNode(2);
        r1.next.next = new ListNode(6);
        r1.next.next.next = new ListNode(3);
        r1.next.next.next.next = new ListNode(4);
        r1.next.next.next.next.next = new ListNode(5);
        r1.next.next.next.next.next.next = new ListNode(6);

        System.out.println("Original List:");
        printList(r1);

        // Remove all nodes with value 6
        r1 = removeElements(r1, 6);

        System.out.println("List after removing 6:");
        printList(r1);
    }
}
