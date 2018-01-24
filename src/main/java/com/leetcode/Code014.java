package com.leetcode;

import java.util.Arrays;

public class Code014 {

    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"abcd","abrf","abcdes"}));
        System.out.println(longestCommonPrefix(new String[]{}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder("");

        if (strs != null && strs.length > 0) {
            Arrays.sort(strs);
            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    prefix.append(b[i]);
                } else {
                    return prefix.toString();
                }
            }
        }
        return prefix.toString();
    }

}
