package com.learning.string.dppattern4;

/**
 * Top-down Dynamic Programming with Memoization #
 * We can use an array to store the already solved subproblems.
 *
 * The two changing values to our recursive function are the two indexes, startIndex and endIndex.
 * Therefore, we can store the results of all the subproblems in a two-dimensional array.
 * (Another alternative could be to use a hash-table whose key would be a string (startIndex + “|” + endIndex))
 *
 *
 * The above algorithm has a time and space complexity of O(n^2)
 * because we will not have more than n*nn∗n subproblems.
 * */

public class LongestPalindromicSubStringT2BM {

    public static int findPalindrom(String s){
        Integer dp[][] = new Integer[s.length()][s.length()];
        return findPalndromicSubsequence(dp, s, 0, s.length()-1);

    }

    public static int findPalndromicSubsequence(Integer[][] dp, String s, int startIndex, int endIndex){
        if(startIndex > endIndex){
            return 0;
        }

        if(startIndex == endIndex){
            return 1;
        }

        if(dp[startIndex][endIndex] != null){
            return dp[startIndex][endIndex];
        }

        if(s.charAt(startIndex) == s.charAt(endIndex)){
            int remainingLength = endIndex - startIndex -1;

            if(remainingLength == findPalndromicSubsequence(dp, s, startIndex+1, endIndex-1)) {
                dp[startIndex][endIndex] = remainingLength + 2;
                return dp[startIndex][endIndex];
            }
        }
        int c1 = findPalndromicSubsequence(dp, s, startIndex+1, endIndex);
        int c2 = findPalndromicSubsequence(dp, s , startIndex, endIndex-1);

        dp[startIndex][endIndex] = Math.max(c1, c2);
        return dp[startIndex][endIndex];
    }
    public static void main(String[] args) {



        System.out.println(findPalindrom("abdbca"));
        System.out.println(findPalindrom("cddpd"));
        System.out.println(findPalindrom("pqr"));
    }
}
