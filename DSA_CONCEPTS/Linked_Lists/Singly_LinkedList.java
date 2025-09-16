
class Node {
      int data;
      Node next;

       Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

class LinkedList{
     Node head;

         //ADD AT BEGGINING
    public void addAtBeginning(int data) {
        Node newNode = new Node(data);
        if(head==null) {           //if LL is empty
        	head=newNode;
        	return;
        }
        newNode.next = head;         //Link newnode to already existing 1st node
        head = newNode;              //first node is always denoted by head
    }

        //ADD AT POSTION
    public void addAtPosition(int pos, int data) {
    	 Node newNode = new Node(data);
    	 int current=0;
    	 Node temp=head;
    	 while(temp.next!=null) {
    		 current++;
    		 if(current==pos) 
    			 break;
    		 temp=temp.next;
    	 }
    	 newNode.next=temp.next;   //Link
    	 temp.next=newNode;         //we change temp so it points out to new node
    }  
    	
    	
    	//ADD AT END
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;     //the moment temp comes out of the loop we link newnode to the temp
    }

   

    // DELETE BY POSITION
    public void deleteByPosition(int pos) {
        if (head == null) return;            //list is empty
 
        if (pos == 0) {                    //deleting the head node
            head = head.next;
            return;
        }
         Node temp = head;
        int count = 0;

        // Traverse until the node before the target
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }
        
        if (temp == null || temp.next == null) {
            System.out.println("Invalid position!");       //position is invalid
            return;
        }
        temp.next = temp.next.next;        //skip the node
    }



    //DELETE BY VALUE (all occurance)
    public void deleteByValue(int value) {
        if (head == null) {
        	System.out.println("List is empty");
        }
        
        if (head.data == value) {       //1st element is the element we need to delete
            head = head.next;
            return;
        }
        
        Node temp = head;
        while (temp != null && temp.next != null) {
              if (temp.next == null) {
                   System.out.println("Value not found!");
                  return;
         }
              else {
            	  temp=temp.next;
              }
        }
   }
    
    
       //REVERSE THE LL
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    
   //FINDING THE LENGTH
    public int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

   //SEARCH A VALUE
    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) return true;
            temp = temp.next;
        }
        return false;
    }

     //GETTING THE VALUE AT A POS
    public int getValueAt(int pos) {
        if (head == null) {
            System.out.println("List is empty!");
            return -1;  
        }

        Node temp = head;
        int count = 0;

        while (temp != null) {
            if (count == pos) {
                return temp.data;      // Found the node at index
            }
            temp = temp.next;
            count++;
        }

        System.out.println("Invalid index: " + pos);    //index out of range
        return -1;  
    }
    
    //INSERT AFTER A GIVEN VALUE
    public void insertAfterValue(int target, int newData) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        while (temp != null && temp.data != target) {
            temp = temp.next;
        }
        if (temp == null) {            //If target not found
            System.out.println("Value " + target + " not found in the list!");
            return;
        }

        Node newNode = new Node(newData);     //create a new node

        newNode.next = temp.next;        //insert after the target node
        temp.next = newNode;
    }

     
       //DISPLAY THE LL
    public void Display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

class Singly_LinkedList {
        public static void main(String[] args) {
           LinkedList list = new LinkedList();

            // Add elements
            list.addAtBeginning(10);
            list.addAtBeginning(5);
            list.addAtEnd(20);
            list.addAtPosition(2, 15);   
            System.out.println("After adding elements:");
            list.Display();

            // Delete by position
            list.deleteByPosition(2);  
            System.out.println("After deleting position 2:");
            list.Display();

            // Delete by value
            list.deleteByValue(5);  
            System.out.println("After deleting value 5:");
            list.Display();

            // Insert after a value
            list.insertAfterValue(10, 12);
            System.out.println("After inserting 12 after 10:");
            list.Display();

            // Get value at position
            System.out.println("Value at position 1: " + list.getValueAt(1));

            // Search a value
            System.out.println("Is 20 present? " + list.search(20));
            System.out.println("Is 100 present? " + list.search(100));

            // Length
            System.out.println("Length of the list: " + list.length());

            // Reverse
            list.reverse();
            System.out.println("After reversing the list:");
            list.Display();
        }
    }

