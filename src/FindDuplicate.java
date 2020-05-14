import java.util.HashMap;

public class FindDuplicate {

    public static void main(String[] args) {

        int arr[] = {4,3,5,3,2,1};

        FindDuplicate fd = new FindDuplicate();

        int results = fd.findDuplicate(arr);

        System.out.println(results);

    }

    public int findDuplicate(int arr[]){

        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i]) && map.get(arr[i])){
                return arr[i];
            }
            map.put(arr[i], true);
        }

        return -1;
    }
}
