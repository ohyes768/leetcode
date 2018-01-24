package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code016 {
    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-4,-1,0,1,2,3},0));

    }

    public static int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target)
                    start++;
                else
                    end--;
            }
        }
        return closest;
    }

}