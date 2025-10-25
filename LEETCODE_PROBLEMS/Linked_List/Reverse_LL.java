import java.util.*;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Reverse_LL {
       
	//Time complexity - O(n) Space complexity - O(n)
	//Also we are not using any properties of LL this is not an efficient one
	ListNode reverseusingStack(ListNode head) {
		 Stack<Integer> valuestack = new Stack<>(); //creating a stack 
		 while(head!=null) {
			 valuestack.push(head.val);    //push each value into the stack
			 head=head.next;              //move the head
		 }
		 
		 ListNode reversedList = new ListNode(Integer.MIN_VALUE); //Creating a new list to store the reversed value
		 ListNode ptr=reversedList;
		 
		 while(!valuestack.isEmpty()) {
			 ptr.next=new ListNode(valuestack.pop()); //creating a new node to the next to the ptr and assign the value which we pop from stack
		     ptr=ptr.next;
		 }
		 return reversedList.next;   
		 
	}
	//Time complexity=O(n) Space complexity=O(1) 
	ListNode reverse(ListNode head) {
		if(head==null) return null;   //Empty
		
		if(head.next==null) {
			return head;              //only one node  no revevrsing can be done 
		}
		
		ListNode preNode=null;
		ListNode currNode = head;
		
		while(currNode!=null) {           //iterate till the end
			ListNode nextNode=currNode.next;   //next of currNode  
			currNode.next=preNode;      //now currNode is pointing  to preNode(initially null)
			preNode = currNode;
			currNode=nextNode;
			
		}
		head=preNode;
		
		return head;
	}
	
	// print the linked list
	void printList(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Reverse_LL obj=new Reverse_LL();
		
		
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		
		System.out.println("Original List:");
		obj.printList(head);
		
		System.out.println("Reversed using Stack:");
		ListNode reversedStack=obj.reverseusingStack(head);
		obj.printList(reversedStack);
		
		//recreate list because original head is consumed in stack method
		head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		
		System.out.println("Reversed using Iteration:");
		ListNode reversed=obj.reverse(head);
		obj.printList(reversed);
	}
}
