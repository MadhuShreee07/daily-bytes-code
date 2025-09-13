
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class Singly_LL_Insertion {
     Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if(head==null) {
        	head=newNode;         //If LL is empty
        }
        else{
        	newNode.next = head;
        	 head = newNode;
        }
    }
    
    //Insert at any Position
    public void insertAtPosition(int position, int data) {
    	 Node newNode = new Node(data);
        int current = 0;
        Node temp=head;
        while(temp.next!=null) {
        	current++;
        	if(current==position) 
        		break;
             temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }
    

    
    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        newNode.next=null;
        Node temp=head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    

  
    // Display list 
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    
    public static void main(String[] args) {
    	Singly_LL_Insertion list = new Singly_LL_Insertion();

        // Insert at beginning
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        System.out.println("After inserting at beginning:");
        list.display();

        // Insert at end
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        System.out.println("After inserting at end:");
        list.display();

        // Insert at specific position
        list.insertAtPosition(2, 25);      // insert 25 at index 2
        System.out.println("After inserting at position 2:");
        
        
        list.display();
    }
}

