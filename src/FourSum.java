import java.util.*;

public class FourSum {

//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length; i++){
//            if(i != 0 && nums[i] == nums[i-1]) continue;
//            for(int j = i+1; j < nums.length; j++){
//                if(j != i+1 && nums[j] == nums[j-1]) continue;
//                int t = target - nums[i] - nums[j];
//                int m = j+1, n = nums.length-1;
//                while(m < n){
//                    if(nums[m]+nums[n] == t){
//                        Integer[] temp = {nums[i], nums[j], nums[m], nums[n]};
//                        res.add(Arrays.asList(temp));
//                        m++;
//                        n--;
//                        while(m < nums.length && nums[m] == nums[m-1]) m++;
//                        while(n >= 0 && nums[n] == nums[n+1]) n--;
//                    } else if(nums[m]+nums[n] < t){
//                        m++;
//                    } else n--;
//                }
//            }
//        }
//        return res;
//    }

//    public static void main(String args[]){
//        FourSum fs = new FourSum();
//
//        int target = 0;
//        int nums[] = new int[]{1, 0, -1, 0, -2, 2};
//
//        System.out.println(fs.fourSum(nums, target));
//    }


    static class pair
    {
        int first, second;
        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    // The function finds four elements
// with given sum X
    static void findFourElements(int arr[],
                                 int n, int X)
    {

        List<List> res = new ArrayList<>();
        // Store sums of all pairs in a hash table
        HashMap<Integer,
                pair> mp = new HashMap<Integer,
                                pair>();
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                mp.put(arr[i] + arr[j],
                        new pair(i, j));

        // Traverse through all pairs and search
        // for X - (current pair sum).
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                int sum = arr[i] + arr[j];

                // If X - sum is present in hash table,
                if (mp.containsKey(X - sum))
                {

                    // Making sure that all elements are
                    // distinct array elements and an element
                    // is not considered more than once.
                    pair p = mp.get(X - sum);
                    if (p.first != i && p.first != j &&
                            p.second != i && p.second != j)
                    {


                        List l = Arrays.asList(arr[i], arr[j], arr[p.first], arr[p.second]);
                        Collections.sort(l);
                        if(!res.contains(l)){
                            System.out.print(l);
                            res.add(l);
                        }
                       // return;
                    }
                }
            }
        }
    }

    // Driver Code
    public static void main(String[] args)
    {
        int arr[] = {1, 0, -1, 0, -2, 2};
        int n = arr.length;
        int X = 0;
        findFourElements(arr, n, X);
    }
}
