
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Stack_using_LL {

    ListNode head;

    public Stack_using_LL() {    //CONSTRUCTOR
        head = null;            //At starting head is pointing to null
    }

    void push(int x) {
   
        ListNode node = new ListNode(x);    //Creating a new node
        node.next = head;                    //   adds before not after
        
        head = node;                  //Move the head to new node    
    }

    int pop() {
        int number = head.val;

        
        head = head.next;      //move the head to next node

        return number;
    }

    
    int peek() {
        return head.val;
    }

    
    boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
    	Stack_using_LL myStack = new Stack_using_LL();

        myStack.push(4);
        myStack.push(8);

        System.out.println(myStack.peek());

        myStack.push(15);

        myStack.pop();
        myStack.pop();

        System.out.println(myStack.pop());
    }
}
