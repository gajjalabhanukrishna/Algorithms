import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ReverseInt {
    /* Iterative function to reverse
    digits of num*/
    static int reversDigits(int x)
    {

        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                return true;
            }
        }
        return false;
    }

    // Driver code
    public static void main (String[] args)
    {
        int num = 1534236469;
        System.out.println("Reverse of no. is "
                + reversDigits(num));
    }
}

/*
* public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }
* */
