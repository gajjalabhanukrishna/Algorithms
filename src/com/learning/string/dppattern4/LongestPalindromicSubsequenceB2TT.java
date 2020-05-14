package com.learning.string.dppattern4;

public class LongestPalindromicSubsequenceB2TT {

    public static int findLPSLength(String s){

        int dp[][] = new int[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }

        for(int startIndex = s.length()-1; startIndex >=0; startIndex--){
            for(int endIndex = startIndex+1; endIndex < s.length(); endIndex++){
                if(s.charAt(startIndex) == s.charAt(endIndex)){
                    dp[startIndex][endIndex] = 2 + dp[startIndex+1][endIndex-1];
                }else{
                    dp[startIndex][endIndex] = Math.max(dp[startIndex+1][endIndex], dp[startIndex][endIndex-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }
}
