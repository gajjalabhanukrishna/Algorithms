package com.learning.string.dppattern4;

public class CountOfPalindromicSubstrings {

    public static int findPalindrom(String s){
        int count= 0;


        boolean dp[][] = new boolean[s.length()][s.length()];

        for(int i=0; i< s.length(); i++){
            dp[i][i]= true;
            count++;
        }

        for(int startIndex= s.length()-1; startIndex >=0; startIndex--){
            for(int endIndex= startIndex+1; endIndex < s.length(); endIndex++){
               if(s.charAt(startIndex) == s.charAt(endIndex)){
                   if(endIndex - startIndex == 1 || dp[startIndex+1][endIndex-1]){
                       dp[startIndex][endIndex] = true;
                       count++;
                   }
               }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPalindrom("abdbca"));
        System.out.println(findPalindrom("cdpdd"));
        System.out.println(findPalindrom("pqr"));
    }
}
