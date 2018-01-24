package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Code003 {

    public static void main(String[] args) {
        String s = "ssdsxgvdsf";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
        int result2 = lengthOfLongestSubstring2(s);
        System.out.println(result2);
        int result3 = lengthOfLongestSubstring3(s);
        System.out.println(result3);

    }

    public static int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
                i= i + 1;
            } else {
                maxlen = map.size()> maxlen ? map.size(): maxlen;
                i = i - map.size()+ 1;
                map.clear();
            }
        }
        return map.size()> maxlen ? map.size(): maxlen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
