package com.leetcode;

public class Code009 {

    public static void main(String[] args) {

        System.out.println(IsPalindrome(-2147483648));

    }

    public static boolean IsPalindrome(int num) {
        if (num < 0 || (num %10 ==0 && num != 0)){
            return false;
        }
        int revertedNumber = 0;
        while(num > revertedNumber) {
            revertedNumber = revertedNumber * 10 + num % 10;
            num /= 10;
        }
        return num == revertedNumber || num == revertedNumber/10;
    }

}
