package com.leetcode;

public class Code023 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = new int[]{2,3,4};
        int[] arr2 = new int[]{1,4,6};
        int[] arr3 = new int[]{5,6,9};

        ListNode l1 = Code002.MakeListFromTail(arr1,arr1.length);
        Code002.displayList(l1);
        System.out.println();

        ListNode l2 = Code002.MakeListFromTail(arr2,arr2.length);
        Code002.displayList(l2);
        System.out.println();

        ListNode l3 = Code002.MakeListFromTail(arr3,arr3.length);
        Code002.displayList(l3);
        System.out.println();

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode result = mergeKLists(lists);
        Code002.displayList(result);
        System.out.println();
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length ==0)
            return null;
        return MSort(lists,0,lists.length-1);
    }

    public static ListNode MSort(ListNode[] lists, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            ListNode leftlist = MSort(lists,low,mid);
            ListNode rightlist = MSort(lists,mid+1,high);
            return mergeTwoLists(leftlist,rightlist);
        }
        return lists[low];
    }

}