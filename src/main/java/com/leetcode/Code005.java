package com.leetcode;

public class Code005 {

    public static void main(String[] args) {
        String input = "babad";
        String result = longestPalindrome(input);
        String result2 = longestPalindrome2(input);
        System.out.println(result);
        System.out.println(result2);

    }

    public static String longestPalindrome(String s) {
        int[] p = new int[2048];
        StringBuilder t = new StringBuilder("$");
        for (int i = 0; i < s.length(); ++i) {
            t.append('#');
            t.append(s.charAt(i));
        }
        t.append("#_");
        // mx为已判断回文串最右边位置，id为中间位置，mmax记录p数组中最大值
        int mx = 0, id = 0, mmax = 0;
        int right = 0;
        for (int i = 1; i < t.length() - 1; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (t.charAt(i + p[i]) == t.charAt(i - p[i]))
                p[i]++;
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
            if (mmax < p[i]) {
                mmax = p[i];
                right = i;
            }
        }
        // 最长为mmax - 1
        return s.substring(right/2 - mmax/2, right/2 - mmax/2 + mmax-1);
    }


    public static String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
