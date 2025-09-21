
class ListNodee {
    int val;
    ListNodee next;
    ListNodee(int val) { 
        this.val = val; 
    }
}

 class Remove_duplicates_sortedList1 {
    public static ListNodee deleteDuplicates(ListNodee head) {
        ListNodee temp = head;

        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
               
                temp.next = temp.next.next;  //removes duplicate 
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        
        ListNodee head = new ListNodee(1);
        head.next = new ListNodee(1);
        head.next.next = new ListNodee(2);
        head.next.next.next = new ListNodee(3);
        head.next.next.next.next = new ListNodee(3);

  
        head = deleteDuplicates(head);

        // Print result
        ListNodee curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
