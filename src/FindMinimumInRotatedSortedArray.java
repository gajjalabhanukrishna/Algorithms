public class FindMinimumInRotatedSortedArray {

//    public int findMin(int[] nums) {
//
//            int l = 0;
//            int r = nums.length - 1;
//
//            while (nums[l] > nums[r]) {
//                int m = (l + r) / 2;
//                if (nums[m] >= nums[l]) l = m + 1;
//                else r = m;
//            }
//
//            return nums[l];
//    }

    public static void main(String[] args) {
        int nums[] = {3,4,5,1,2};
        FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
        System.out.println(f.findMin(nums));
    }


    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int pivot =  (high + low) / 2;
            if (nums[pivot] < nums[high])
                high = pivot;
            else if (nums[pivot] > nums[high])
                low = pivot + 1;
            else
                high -= 1;
        }
        return nums[low];
    }
}
