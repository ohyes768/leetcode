package com.leetcode;

import java.util.Stack;

public class Code020 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        if(s.length()==1)
            return false;
        Stack<Character> x = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                x.push(s.charAt(i));
            }else{
                if(x.size()==0)
                    return false;
                char top = x.pop();
                if(s.charAt(i)==')'){
                    if(top!='(')
                        return false;
                }else if(s.charAt(i)=='}'){
                    if(top!='{')
                        return false;
                }else if(s.charAt(i)==']'){
                    if(top!='[')
                        return false;
                }
            }
        }
        return x.size()==0;
    }

}