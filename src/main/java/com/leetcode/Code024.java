package com.leetcode;

public class Code024 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = new int[]{2,3,4,5};

        ListNode l1 = Code002.MakeListFromTail(arr1,arr1.length);
        Code002.displayList(l1);
        System.out.println();

        ListNode result = swapPairs(l1);
        Code002.displayList(result);
        System.out.println();
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode fakehead = new ListNode(-1);
        fakehead.next = head;

        ListNode ptr1 = fakehead;
        ListNode ptr2 = head;

        while(ptr2!=null && ptr2.next!=null){
            ListNode nextstart = ptr2.next.next;
            ptr2.next.next = ptr2;
            ptr1.next = ptr2.next;
            ptr2.next = nextstart;
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        return fakehead.next;
    }

}