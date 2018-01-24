package com.leetcode;

public class Code006 {

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
//        convert(input,3);
        System.out.println(convert(input,3));
        System.out.println(convert("",1));
        System.out.println(convert("ab",2));
        System.out.println(convert("abcd",4));

    }

    public static String convert(String s, int numRows) {
        String output = "";

        if(numRows == 1){
            return s;
        }else if(numRows == 2){
            char[] chars = s.toCharArray();
            String tmp1 = "";
            String tmp2 = "";
            int i ;
            for(i =0; i + 1< chars.length; i=i+2){
                tmp1 = tmp1 + chars[i];
                tmp2 = tmp2 + chars[i+1];
            }
            if( i-1 < chars.length -1){
                return tmp1 + chars[i] + tmp2;
            }else {
                return tmp1 + tmp2;
            }
        }else{
            int roll = 2 * numRows - 2;
            int times = s.length() / roll;
            char[] chars = s.toCharArray();

            for (int i = 0; i< numRows; i++){
                output = output + get(chars, roll, times, i);
            }
        }

        return  output;
    }

    public static String get(char[] chars, int roll, int times, int sign) {
        String result = "";
        if (sign == 0 || sign == roll / 2){
            for(int i = 0; i< times ; i++){
                result = result + chars[ roll * i + sign];
            }
            if(roll * times  + sign < chars.length){
                result = result + chars[roll * times + sign];
            }
        }else {
            for(int i = 0; i< times ; i++){
                result = result + chars[ roll * i + sign] + chars[ roll * i + roll - sign];
            }
            if(roll * times  + sign < chars.length){
                result = result + chars[roll * times + sign];
                if(roll * times + roll - sign < chars.length){
                    result = result + chars[ roll * times + roll - sign];
                }
            }

        }
        return  result;
    }

}
