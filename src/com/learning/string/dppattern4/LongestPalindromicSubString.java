package com.learning.string.dppattern4;


/**
 * This problem follows the Longest Palindromic Subsequence pattern. The only difference is that in a palindromic subsequence characters can be non-adjacent, whereas in a substring all characters should form a palindrome. We will follow a similar approach though.
 *
 * The brute-force solution will be to try all the substrings of the given string. We can start processing from the beginning and the end of the string. So at any step, we will have two options::
 *
 * If the element at the beginning and the end are the same, we make a recursive call to check if the remaining substring is also a palindrome. If so, the substring is a palindrome from beginning to the end.
 * We will skip either the element from the beginning or the end to make two recursive calls for the remaining substring. The length of LPS would be the maximum of these two recursive calls.
 *
 *
 * Due to the three recursive calls, the time complexity of the above algorithm is exponential O(3^n),
 * where ‘n’ is the length of the input string. The space complexity is O(n) which is used to store the recursion stack.
 *
 * */
public class LongestPalindromicSubString {


    public static int findPalindrom(String s, int startIndex, int endIndex){


        if(startIndex > endIndex){
            return 0;
        }

        if(startIndex == endIndex){
            return 1;
        }

        if(s.charAt(startIndex) == s.charAt(endIndex)){
            int remainingLength = endIndex - startIndex -1;

            if(remainingLength == findPalindrom(s, startIndex+1, endIndex--)){
                return remainingLength + 2;
            }
        }

        int c1 = findPalindrom(s, startIndex+1, endIndex);
        int c2 = findPalindrom(s, startIndex, endIndex-1);

        return Math.max(c1, c2);

    }

    public static void main(String[] args) {

        System.out.println(findPalindrom("abdbca", 0, 5));
        System.out.println(findPalindrom("cddpd", 0, 4));
        System.out.println(findPalindrom("pqr", 0, 2));

    }
}
