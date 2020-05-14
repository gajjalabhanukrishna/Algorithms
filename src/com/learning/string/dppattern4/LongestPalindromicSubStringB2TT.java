package com.learning.string.dppattern4;


/**
 * Bottom-up Dynamic Programming #
 * Since we want to try all the substrings of the given string, we can use a two-dimensional array to store the subproblems’ results.
 * So dp[i][j] will be ‘true’ if the substring from index ‘i’ to index ‘j’ is a palindrome.
 *
 * We can start from the beginning of the string and keep adding one element at a time.
 * At every step, we will try all of its substrings. So for every endIndex and startIndex in the given string, we need to check the following thing:
 *
 * If the element at the startIndex matches the element at the endIndex,
 * we will further check if the remaining substring (from startIndex+1 to endIndex-1) is a substring too.
 *
 * */
public class LongestPalindromicSubStringB2TT {


    public static int findPalindrom(String s){

        boolean [][] dp = new boolean[s.length()][s.length()];

        for(int i =0; i < s.length(); i++){
            dp[i][i] = true;
        }

        int maxLength = 1;

        for(int startIndex = s.length() - 1; startIndex >=0 ; startIndex--){
            for(int endIndex = startIndex+1; endIndex< s.length(); endIndex++){
                if(s.charAt(startIndex) == s.charAt(endIndex)){
                    if(endIndex -startIndex == 1 || dp[startIndex +1][endIndex -1]){
                        dp[startIndex][endIndex] = true;
                        maxLength = Math.max(maxLength, endIndex-startIndex +1);
                    }
                }
            }
        }

        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(findPalindrom("abdbca"));
        System.out.println(findPalindrom("cdpdd"));
        System.out.println(findPalindrom("pqr"));
    }
}
