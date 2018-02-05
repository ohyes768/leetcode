package com.leetcode;

public class Code019 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = new int[]{2,4,3,5,8,6};
        ListNode listnode = Code002.MakeListFromHead(arr1, arr1.length);
        Code002.displayList(listnode);
        removeNthFromEnd(listnode, 2);
        System.out.println();
        Code002.displayList(listnode);
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

}