public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = max[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                min[i] = Math.min(nums[i], min[i-1] * nums[i]);
                max[i] = Math.max(nums[i], max[i-1] * nums[i]);
            } else {
                min[i] = Math.min(nums[i], max[i-1] * nums[i]);
                max[i] = Math.max(nums[i], min[i-1] * nums[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {-2,3,-4};
        MaximumProductSubarray m = new MaximumProductSubarray();
        m.maxProduct(a);
    }
}
