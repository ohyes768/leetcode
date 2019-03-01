package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Code032 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "((()()())()())))";
        int result = longestValidParentheses(s);
        System.out.println(result);
    }

    public static int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int start = 0;
        int max = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stack.push(i);
            }
            else
            {
                if(stack.isEmpty())
                {
                    start = i+1;
                }
                else
                {
                    stack.pop();
                    max = stack.isEmpty()?Math.max(max,i-start+1):Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }

}