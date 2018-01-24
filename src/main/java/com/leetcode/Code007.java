package com.leetcode;

public class Code007 {

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(201));
        System.out.println(reverse(-192));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));

    }

    public static int reverse(int x) {
        if(x==Integer.MIN_VALUE || x==Integer.MAX_VALUE)
            return 0;
        int num = Math.abs(x);
        int res = 0;
        while(num!=0){
            if(res>(Integer.MAX_VALUE-num%10)/10)//非常巧妙的判断了越界问题
                return 0;
            res = res*10+num%10;
            num /= 10;
        }
        return x>0?res:-res;
    }

}
