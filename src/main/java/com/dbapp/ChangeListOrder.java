package com.dbapp;

import java.util.LinkedList;

public class ChangeListOrder {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr1 = new int[]{2,3,4,5};

        LinkedList<String> strs = new LinkedList<>();
        strs.add("1");
        strs.add("2");
        strs.add("3");
        strs.add("4");
        for (String str : strs){
            System.out.println(str);
        }
//        strs.set(0, "5");
        System.out.println();
        strs.add(2,strs.remove(3));
        for (String str : strs){
            System.out.println(str);
        }
        System.out.println();
        strs.add(3,strs.remove(0));
        for (String str : strs){
            System.out.println(str);
        }
    }


}