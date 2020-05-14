import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //List<int []> results = new ArrayList<>();
        for(int i =0; i < nums.length; i++){
            int balance = target - nums[i];

            if(map.containsKey(balance)){
                //results.add(new int[]{map.get(nums[i]), i});
                return new int[]{map.get(balance), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int [] nums = {2, 7, 11, 15};
        System.out.println(ts.twoSum(nums, 9));
    }
}
