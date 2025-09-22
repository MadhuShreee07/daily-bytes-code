class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Doubly_LinkedList {

    DLLNode head, tail;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        DLLNode newNode = new DLLNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at end
    public void insertAtEnd(int data) {
        DLLNode newNode = new DLLNode(data);
        newNode.next=null;
        if (head == null) { // handle empty list
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert at middle 
    public void insertAtMiddle(int pos, int data) {
        DLLNode newNode = new DLLNode(data);
        DLLNode temp = head;
        int current = 0;
        while (temp.next != null) {
            current++;
            if (current == pos)
                break;
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete from beginning
    public void deleteBegin() {
        if (head == null) return;
                
        head = head.next;
        head.prev = null;
        
    }

    // Delete from middle by position
    public void deleteMiddle(int position) {
        if (head == null) return;
        int current = 0;
        DLLNode temp = head;
        while (temp.next != null) {
            current++;
            if (current == position) break;
            temp = temp.next;
        }
       // if (temp == null || temp.next == null) return;
        temp.next.next.prev = temp;
        temp.next = temp.next.next;
    }

    // Delete from end
    public void deleteEnd() {
        if (tail == null) return;
        tail = tail.prev;
         tail.next = null;
      
    }

    // Search for a value
    public boolean search(int key) {
        DLLNode temp = head;
        while (temp != null) {
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    // Traverse forward
    public void traverseForward() {
        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Traverse backward
    public void traverseBackward() {
        if (tail == null) return;
        DLLNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    // Reverse the DLL
    public void reverse() {
        DLLNode temp = null;
        DLLNode current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) head = temp.prev;
    }

    public static void main(String[] args) {
        Doubly_LinkedList dll = new Doubly_LinkedList();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtBeginning(5);
        dll.insertAtMiddle(2, 25);

        System.out.println("Traverse Forward:");
        dll.traverseForward();

        System.out.println("Traverse Backward:");
        dll.traverseBackward();

        System.out.println("Search 25: " + dll.search(25));
        System.out.println("Search 40: " + dll.search(40));

        dll.deleteBegin();
        System.out.println("After deleting from beginning:");
        dll.traverseForward();

        dll.deleteEnd();
        System.out.println("After deleting from end:");
        dll.traverseForward();

        dll.deleteMiddle(2);
        System.out.println("After deleting from middle (pos=2):");
        dll.traverseForward();

        dll.reverse();
        System.out.println("After reversing:");
        dll.traverseForward();
    }
}
