public class MaximumSubarray {

    //Dynamic programming
//    public static int maxSubArray(int[] nums) {
//        int n = nums.length, maxSum = nums[0];
//        for(int i = 1; i < n; ++i) {
//            if (nums[i - 1] > 0) {
//                nums[i] += nums[i - 1];
//            }
//            maxSum = Math.max(nums[i], maxSum);
//        }
//        return maxSum;
//    }

    public static int maxSubArray(int[] nums){
        int max=nums[0];
        int previous = nums[0];

//        if(nums.length == 1 && nums[0] > 0){
//            return nums[0];
//        }

        for(int i =1; i < nums.length; i++){
            previous = Math.max(nums[i], nums[i] + previous);
            max = Math.max(previous, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = new int []{-2};

        System.out.println(maxSubArray(nums));
    }
}
