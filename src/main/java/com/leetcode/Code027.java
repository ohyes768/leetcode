package com.leetcode;

public class Code027 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = new int[]{1,1,2};

        int result = removeElement(arr1, 1);
        System.out.println(result);
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0 || nums == null)
            return 0;

        int len = 0;
        for(int index = 0; index < nums.length; index++){
            if(nums[index] != val){
                nums[len] = nums[index];
                len++;
            }
        }
        return len;
    }

}