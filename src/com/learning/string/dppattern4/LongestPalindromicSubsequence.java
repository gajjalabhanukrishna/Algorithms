package com.learning.string.dppattern4;


/**
 *  Pattern 4: Palindromic Subsequence
 * A basic brute-force solution could be to try all the subsequences of the given sequence. We can start processing from the beginning and the end of the sequence. So at any step, we have two options:
 *
 * 1.  If the element at the beginning and the end are the same, we increment our count by two and make a recursive call for the remaining sequence.
 * 2. We will skip the element either from the beginning or the end to make two recursive calls for the remaining subsequence.
 * If option one applies then it will give us the length of LPS; otherwise, the length of LPS will be the maximum number returned by the two recurse calls from the second option.
 *
 * The time complexity of the above algorithm is exponential O(2^n),
 * where ‘n’ is the length of the input sequence. The space complexity is O(n) which is used to store the recursion stack.
 * */

public class LongestPalindromicSubsequence {

    public static int findPalndromicSubsequence(String s, int startIndex, int endIndex){


        if(startIndex > endIndex){
            return 0;
        }

        // every sequence with one element is a palindrome of length 1
        if(startIndex == endIndex){
            return 1;
        }

        // case 1: elements at the beginning and the end are the same
        if(s.charAt(startIndex) == s.charAt(endIndex)){
            return 2 + findPalndromicSubsequence(s, startIndex+1, endIndex-1);
        }

        // case 2: skip one element either from the beginning or the end
        int c1 = findPalndromicSubsequence(s, startIndex+1, endIndex);
        int c2 = findPalndromicSubsequence(s, startIndex, endIndex-1);

        return Math.max(c1, c2);

    }

    public static void main(String[] args) {
        System.out.println(findPalndromicSubsequence("abdbca", 0, 5));
        System.out.println(findPalndromicSubsequence("cddpd", 0, 4));
        System.out.println(findPalndromicSubsequence("pqr", 0, 2));
    }
}
