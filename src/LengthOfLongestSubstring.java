import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring {

//    public int lengthOfLongestSubstring(String s) {
//
//        int maxValue = 0;
//        List tem = new ArrayList();
//
//        for(int i = 0; i < s.length(); i++){
//            if(!tem.contains(s.charAt(i))){
//                tem.add(s.charAt(i));
//                if(maxValue < tem.size()){
//                    maxValue = tem.size();
//                }
//            }else {
//                tem.clear();
//                if(s.charAt(i) == s.charAt(i-1)){
//
//                    tem.add(s.charAt(i));
//                    //maxValue = tem.size();
//                }
//            }
//
//        }
//        return maxValue;
//    }

    //Sliding Window
//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            // try to extend the range [i, j]
//            if (!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans, j - i);
//            }
//            else {
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
//    }

        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            int[] index = new int[128]; // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                i = Math.max(index[s.charAt(j)], i);
                ans = Math.max(ans, j - i + 1);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }


//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>(); // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j + 1);
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        LengthOfLongestSubstring ls = new LengthOfLongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring("abcba"));
    }

}

