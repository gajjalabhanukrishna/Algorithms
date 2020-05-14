import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequent {

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        List<Integer> output = new ArrayList<>();

        for(int j : map.keySet()){
            if(map.get(j) >= k){
                output.add(j);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        TopKFrequent t = new TopKFrequent();
        t.topKFrequent(nums, 2);
    }
}
