package MergeKSortedLists;

public class MergeKSortedLists {
    public ListNode mergeTwoSortedLists(ListNode listNode1, ListNode listNode2){
        ListNode result = null;
        if (listNode1 == null){
            return listNode2;
        }
        else if (listNode2 == null){
            return listNode1;
        }
        if (listNode1.val <= listNode2.val){
            result = listNode1;
            result.next = mergeTwoSortedLists(listNode1.next, listNode2);
        } else {
            result = listNode2;
            result.next = mergeTwoSortedLists(listNode1, listNode2.next);
        }
        return result;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        int last = lists.length - 1;
        while (last != 0){
            int i = 0, j = last;
            while (i < j){
                lists[i] = mergeTwoSortedLists(lists[i], lists[j]);
                i++; j--;
            }
            if (i >= j){
                last = j;
            }
        }
        return lists[0];
    }
    public static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        ListNode arr[] = new ListNode[0];

//        arr[0] = new ListNode(1);
//        arr[0].next = new ListNode(3);
//        arr[0].next.next = new ListNode(5);
//        arr[0].next.next.next = new ListNode(7);
//
//        arr[1] = new ListNode(2);
//        arr[1].next = new ListNode(4);
//        arr[1].next.next = new ListNode(6);
//        arr[1].next.next.next = new ListNode(8);
//
//        arr[2] = new ListNode(0);
//        arr[2].next = new ListNode(9);
//        arr[2].next.next = new ListNode(10);
//        arr[2].next.next.next = new ListNode(11);

        // Merge all lists
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode head = mergeKSortedLists.mergeKLists(arr);
        printList(head);
    }
}
