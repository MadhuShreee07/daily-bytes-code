class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}


class Merge_Two_SortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       if (list1 == null && list2 == null) return null;
        
        //creating a dummy node
        ListNode returnNode = new ListNode(Integer.MIN_VALUE);

        //During merging, we move returnNode forward step by step.
         //If we don’t keep a copy, we lose the start of the merged list.
      ListNode headNode = returnNode; 

      
        while(list1!=null && list2!=null){   //Traverse till one of the list reaches null
            if(list1.val<=list2.val){        ////compare two 2 of lists
                returnNode.next=list1;
                list1=list1.next;         // //move the pointer forward
            }
            else{
                returnNode.next=list2;
                list2=list2.next;
            }
    //Move the returnNode to the node we just attached,
    // so the next attachment happens after it.
        returnNode=returnNode.next;
    }

            //appending whichever is left out
            if(list1==null){                       
                returnNode.next=list2;
            }
            else{
                returnNode.next=list1;
            }
        
        return headNode.next;

    }

    // print list
    public void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
    	Merge_Two_SortedList sol = new Merge_Two_SortedList();

        //creating first sorted list: 1->3->5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        //creating second sorted list: 2->4->6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        System.out.println("List 1:");
        sol.printList(list1);
        System.out.println("List 2:");
        sol.printList(list2);

        //merging two sorted lists
        ListNode merged = sol.mergeTwoLists(list1, list2);
        System.out.println("Merged List:");
        sol.printList(merged);
    }
}
