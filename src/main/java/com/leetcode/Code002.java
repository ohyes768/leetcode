package com.leetcode;

public class Code002 {


    //打印单链表
    public static void displayList(ListNode head)
    {
        if(head==null) return;
        ListNode p = head;
        while(p !=null)
        {
            if(p.next!=null)
                System.out.print(p.val+"->");
            else
                System.out.print(p.val+"");
            p=p.next;
        }
    }

    //头插法创建单链表
    public static ListNode MakeListFromHead(int[] arr, int len)
    {
        if(len<=0) return null;
        ListNode head=new ListNode(0);
        ListNode tmp;
        for(int i=0; i<len; i++)
        {
            tmp=new ListNode(arr[i]);
            if(head.next==null)
                head.next=tmp;
            else
            {
                tmp.next=head.next;
                head.next=tmp;
            }
        }
        return head;
    }

    public static ListNode MakeListFromTail(int[] arr, int len)
    {
        if(len<=0) return null;
        ListNode head=new ListNode(0);
        ListNode tail=head;
        ListNode tmp;
        for(int i=0; i<len; i++)
        {
            tmp=new ListNode(arr[i]);
            if(head.next==null)
            {
                tail=tmp;
                head.next=tail;
            }
            else
            {
                tail.next=tmp;
                tail=tmp;
            }
        }
        return head.next;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = new int[]{2,4,3};
        int[] arr2 = new int[]{5,6,4};

        ListNode l1=MakeListFromTail(arr1,arr1.length);
        displayList(l1);
        System.out.println();

        ListNode l2=MakeListFromTail(arr2,arr2.length);
        displayList(l2);
        System.out.println();

        ListNode result = addTwoNumbers(l1, l2);
        displayList(result);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val)
    {
        this.val=val;
        this.next=null;
    }
}