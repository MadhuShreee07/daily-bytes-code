import java.util.*;

// Definition for singly linked list
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Palindrome_LL {

    //USING STACK BRUTE FORCE 
    // Time: O(n), Space: O(n)
    public static boolean isPalindromeUsingStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        //  Push all elements of the list into the stack
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        // Traverse the list again and compare with stack
        temp = head;
        while (temp != null) {
            int top = stack.pop();
            if (temp.val != top) {
                return false; // Not a palindrome
            }
            temp = temp.next;
        }

        return true; // All matched
    }

    // OPTIMISED SOLUTION
    // Time: O(n), Space: O(1)
    public static boolean isPalindromeOptimized(ListNode head) {
        if (head == null || head.next == null) return true;

        //  Find the middle of the linked list
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //  If the list has odd number of nodes, move slow one step further
        if (fast != null) { // odd number of nodes
            slow = slow.next;
        }

        //  Reverse the second half as slow ptr is in the middle of LL
        slow = reverseList(slow);
        fast = head; // Reset fast to head for comparison

        // Compare first half and reversed second half
        while (slow != null) {
            if (fast.val != slow.val) return false;
            
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    //  reverse a linked list
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next; // store next node
            head.next = prev;          // reverse the link
            prev = head;               // move prev forward
            head = next;               // move head forward
        }
        return prev; // new head of reversed list
    }

    //  print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        // Example: 1 -> 2 -> 3 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        printList(head);

        // Check using stack
        if (isPalindromeUsingStack(head)) {
            System.out.println("Stack Method: The linked list is a palindrome!");
        } else {
            System.out.println("Stack Method: The linked list is NOT a palindrome!");
        }

        // Check using optimized soln
         if (isPalindromeOptimized(head)) {
            System.out.println("Optimized Method: The linked list is a palindrome!");
        } else {
            System.out.println("Optimized Method: The linked list is NOT a palindrome!");
        }
    }
}
