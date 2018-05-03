package com.leetcode;

public class Code021 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = new int[]{2,3,4};
        int[] arr2 = new int[]{1,4,6};

        ListNode l1 = Code002.MakeListFromTail(arr1,arr1.length);
        Code002.displayList(l1);
        System.out.println();

        ListNode l2 = Code002.MakeListFromTail(arr2,arr2.length);
        Code002.displayList(l2);
        System.out.println();

        ListNode l3 = mergeTwoLists(l1, l2);
        Code002.displayList(l3);
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakehead = new ListNode(-1);
        ListNode l3 = fakehead;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }

        if(l1!=null)
            l3.next = l1;
        if(l2!=null)
            l3.next = l2;
        return fakehead.next;
    }

}