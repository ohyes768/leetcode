package com.leetcode;

public class Code034 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(searchRange(nums, 0));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] count = {-1,-1};
        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid] > target){
                right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else{
                left = mid;
                right = mid;
                while (left >= 0 && nums[left] == target){
                    left--;
                }
                count[0] = left+1;

                while (right < nums.length && nums[right] == target){
                    right++;
                }
                count[1] = right-1;
                break;
            }
        }
        return count;
    }
}