package com.learning.string;

public class StringReverseOfKChar {

    public static String reverseString(String s, int k){

        char[] a = s.toCharArray();

        for(int start = 0; start< s.length(); start += 2*k){

            int i = start;
            int j = Math.min(start+k-1, s.length()-1);

            while(i < j){

                char temp = a[i];
                a[i++]= a[j];
                a[j--] = temp;

            }


        }

        return new String(a);

    }


    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseString(s, 2));
    }
}
