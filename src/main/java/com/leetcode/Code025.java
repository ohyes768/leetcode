package com.leetcode;

public class Code025 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = new int[]{2,3,4,5,9,6,7,8};

        ListNode l1 = Code002.MakeListFromTail(arr1,arr1.length);
        Code002.displayList(l1);
        System.out.println();

        ListNode result = reverseKGroup(l1, 3);
        Code002.displayList(result);
        System.out.println();
    }

    private static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;//where first will be doomed "last"
        ListNode cur = last.next;
        while(cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            count ++;
            ListNode next = cur.next;
            if(count == k){
                pre = reverse(pre, next);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }

}