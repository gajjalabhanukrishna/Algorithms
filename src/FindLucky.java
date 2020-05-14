import java.util.HashMap;
import java.util.Map;

/*
* Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.



Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
Example 2:

Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
Example 3:

Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.
Example 4:

Input: arr = [5]
Output: -1
Example 5:

Input: arr = [7,7,7,7,7,7,7]
Output: 7
*
*
* */

public class FindLucky {

    public int findLucky(int[] arr) {

        // Use a HashMap to count how many times each num
        // appears in arr.
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int largestLuckyNumber = -1;
        // Iterate over the key/ value pairs of the dictionary.
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            // If this is a lucky number
            if (entry.getKey().equals(entry.getValue())) {
                // Keep the largest out of this lucky number and our current largest.
                largestLuckyNumber = Math.max(largestLuckyNumber, entry.getKey());
            }
        }

        return largestLuckyNumber;
    }


}
