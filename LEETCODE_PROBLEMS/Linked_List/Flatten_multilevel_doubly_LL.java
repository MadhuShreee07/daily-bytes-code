// Definition of Node for multilevel doubly linked list
class Node {
    int data;
    Node prev;
    Node next;
    Node child;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}

public class Flatten_multilevel_doubly_LL {

    // Function to flatten a multilevel doubly linked list
    public Node flatten(Node head) {
        if (head == null) return head;    //Empty List

        Node temp = head; //initially 1(acc to this example)
        while (temp != null) {
            if (temp.child != null) {      //if the current node has a child list → we need to insert that child list between temp and temp.next
                Node next = temp.next; //Before breaking the list, store the node after temp(will reconnect it later)

                // recursively flatten the child list
                temp.next = flatten(temp.child);
                temp.next.prev = temp;
                temp.child = null; // remove child pointer

                // move to the end of the flattened child
                Node tail = temp.next;
                while (tail.next != null) {
                    tail = tail.next;
                }

                // connect saved next node
                if (next != null) {
                    tail.next = next;
                    next.prev = tail;
                }
            }
            temp = temp.next; // move forward(initially 1 moving to 2)damnn 
        }
        return head;
    }

    // print the doubly linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
    	Flatten_multilevel_doubly_LL list = new Flatten_multilevel_doubly_LL();

        // Create nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        // Add a child to node 2
        head.next.child = new Node(7);
        head.next.child.next = new Node(8);
        head.next.child.next.prev = head.next.child;

        head.next.child.child = new Node(9);

        System.out.println("Original structure (level-order connections):");
        System.out.println("1 - 2 - 3");
        System.out.println("    |");
        System.out.println("    7 - 8");
        System.out.println("    |");
        System.out.println("    9");

        // Flatten list
        Node flatHead = list.flatten(head);

        System.out.println("\nFlattened list:");
        list.printList(flatHead);
    }
}
