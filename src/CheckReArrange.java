public class CheckReArrange {

    public static void main(String args[]){
        int []arr = {10, -1, 20, 4, 5, -9, -6};
        int neg = 0;
        int po = arr.length-1;

        int [] results = new int[arr.length];
        for(int i=0 ; i< arr.length; i++){
            if(arr[i]< 0){
                results[neg] = arr[i];
                neg++;
            } else{
                results[po] = arr[i];
                po--;
            }
        }

        for(int j =0 ; j < results.length; j++){
            System.out.println(results[j]);
        }

    }
}
