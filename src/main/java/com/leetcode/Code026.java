package com.leetcode;

public class Code026 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = new int[]{1,1,2};

        int result = removeDuplicates(arr1);
        System.out.println(result);
    }

    public static int removeDuplicates(int[] A) {
        if(A.length == 0 || A == null)
            return 0;

        int len = 1;
        for(int index = 1; index < A.length; index++){
            if(A[index] != A[index-1]){
                if(A[index] != A[len])
                    A[len] = A[index];
                len++;
            }
        }
        return len;
    }

}