package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Code001 {

    public static void main(String[] args) {
        int[] input= {3,2,4};
        int target = 6;
        int[] result = twoSum(input,target);

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int arm = target- nums[i];
            if(map.containsKey(arm) && map.get(arm) != i){
                return new int[]{i,map.get(arm)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
