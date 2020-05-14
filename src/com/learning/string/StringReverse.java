package com.learning.string;

public class StringReverse {

    public static String wordReverse(String orgString){

        String reverse = "";

        for(int i = orgString.length() - 1; i >=0 ; i--){
            reverse += orgString.charAt(i);
        }

        return reverse;

    }

    public static String reverse(String orgString){
        String reverse = "";

        if(orgString == null && orgString.length() == 0){
            return "";
        }

        String stringArr[] = orgString.split(" ");

        for(int i = stringArr.length-1; i>=0; i--){
            reverse += stringArr[i] + " ";
        }
        return reverse;
    }

    public static String reverseWords(String s) {



        String reverse = "";
        String stringArr[] = s.trim().split("\\s+");

        for(int i = stringArr.length-1; i>=0; i--){

            reverse += stringArr[i];
            if(i > 0 && !" ".equals(stringArr[i])){
                reverse += " ";
            }
        }
        return reverse;
    }

    public static void main(String[] args) {

       // System.out.println(reverse("Bhanu"));
        System.out.println(reverseWords("a good   example"));

    }
}
