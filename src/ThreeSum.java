import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
       // Set<List<Integer>> cache = new HashSet();
        Arrays.sort(nums);
        int dig1 = 0;
        List<List<Integer>> lst = new ArrayList<>();
        for(int x = 0; x < nums.length; x++){
            for(int y = x+1; y < nums.length; y++){
                dig1 = nums[x];
                int dig2 = nums[y];
                int comp = (dig1 + dig2) * -1;
                if(set.contains(comp)){
                    List<Integer> lst2 = new ArrayList<Integer>();
                    lst2.add(dig1);
                    lst2.add(dig2);
                    lst2.add(comp);

//                    if(!cache.contains(lst2)){
//                        lst.add(lst2);
//                        cache.add(lst2);
//                    }
                    if(!lst.contains(lst2)){
                        lst.add(lst2);
                        //cache.add(lst2);
                    }
                }
            }
            set.add(dig1);
        }

        return  lst;
    }

    public static void main(String[] args) {
        int []nums = {-1, 0, 1, 2, -1, -4};

        ThreeSum ts = new ThreeSum();

        System.out.println(ts.threeSum(nums));
    }
}
