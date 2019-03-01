package com.leetcode;

public class Code033 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start <= end){
            int middle = (start + end) >> 1;
            if(target == nums[middle]) return middle;
            if(rightVal(target, nums[0]) > rightVal(nums[middle], nums[0]))
                start = middle + 1;
            else
                end = middle - 1;
        }
        return -1;
    }

    private static int rightVal(int x, int start){
        return x < start ? x + 0x3f3f3f3f - start : x;
    }

}