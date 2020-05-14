import java.util.HashMap;

public class LongestPalindrome {

    public long longestPalindrome(String str){
        char charArr[] = str.toCharArray();

        long maxCount = 1;

        HashMap<Character, Integer> map = new HashMap();
        for(int i =0; i< charArr.length; i++){
            if(map.containsKey(charArr[i])){
                map.put(charArr[i], map.get(charArr[i]) + 1);
            }else{
                map.put(charArr[i], 1);
            }

        }

        for (char c : map.keySet()) {
            if(map.get(c) % 2 ==0){
                maxCount = maxCount + map.get(c);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        String str = "abccccdd";
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome(str));
    }
}
