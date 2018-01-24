package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code015 {
    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-4,-1,0,1,2,3}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (nums == null || length < 3)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            findTwoSum(nums, i + 1, length - 1, nums[i]);
        }
        return ans;
    }

    public static void findTwoSum(int[] num, int begin, int end, int target) {
        while (begin < end) {
            if (num[begin] + num[end] + target == 0) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(target);
                list.add(num[begin]);
                list.add(num[end]);
                ans.add(list);
                while (begin < end && num[begin + 1] == num[begin])
                    begin++;
                begin++;
                while (begin < end && num[end - 1] == num[end])
                    end--;
                end--;
            } else if (num[begin] + num[end] + target > 0)
                end--;
            else
                begin++;
        }
    }

}