package com.learning.string.dppattern4;

/**
 *  Top-down Dynamic Programming with Memoization
 *
 * The two changing values to our recursive function are the two indexes, startIndex and endIndex.
 * Therefore, we can store the results of all the subproblems in a two-dimensional array.
 * (Another alternative could be to use a hash-table whose key would be a string (startIndex + “|” + endIndex))
 *
 *
 * What is the time and space complexity of the above solution?
 * Since our memoization array dp[st.length()][st.length()] stores the results for all the subproblems,
 * we can conclude that we will not have more than N*NN∗N subproblems (where ‘N’ is the length of the input sequence).
 * This means that our time complexity will be O(N^2)
 * ​​ ).
 *
 * The above algorithm will be using O(N^2) space for the memoization array. Other than that we will use O(N) space for the recursion call-stack.
 * So the total space complexity will be O(N^2 + N), which is asymptotically equivalent to O(N^2)
 *
 * */


public class LongestPalindromicSubsequenceT2BM {

    public static int findPalndrom(String s){

        Integer [][] dp =  new Integer[s.length()][s.length()];

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
            dp[startIndex][endIndex] =  2 + findPalndromicSubsequence(dp, s, startIndex+1, endIndex-1);
        } else {
            int c1 = findPalndromicSubsequence(dp, s, startIndex+1, endIndex);
            int c2 = findPalndromicSubsequence(dp, s, startIndex, endIndex-1);
            dp[startIndex][endIndex] = Math.max(c1, c2);

        }
        return dp[startIndex][endIndex];

    }

    public static void main(String[] args) {

        System.out.println(findPalndrom("abdbca"));
        System.out.println(findPalndrom("cddpd"));
        System.out.println(findPalndrom("pqr"));

    }
}
