package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.leetcode.Code020.isValid;

public class Code022 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> list= generateParenthesis(3);
        for(String str : list){
            System.out.println(str);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String item = new String();

        if (n <= 0)
            return res;

        dfs(res,item,n,n);
        return res;
    }

    public static void dfs(List<String> res, String item, int left, int right){
        if(left > right)//deal wiith ")("
            return;

        if (left == 0 && right == 0){
            res.add(new String(item));
            return;
        }

        if (left>0)
            dfs(res,item+'(',left-1,right);
        if (right>0)
            dfs(res,item+')',left,right-1);
    }

}