package com.leetcode;

public class Code028 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int result = strStr("", "");
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        int sign = -1;
        for(int i= 0; i<= haystack.length() - needle.length(); i++){
            String match = haystack.substring(i, haystack.length());
            if (match.startsWith(needle)) {
                sign = i;
                break;
            }
        }
        return sign;
    }

}