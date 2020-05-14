public class SquareSortedArray {

    public int[] squareSortedArray(int input[]){

        int output[] = new int[input.length];

        int left = 0;
        int right = input.length-1;

        for(int i = input.length-1; i >= 0; i--){
            if(Math.abs(input[left])> Math.abs(input[right])){
                output[i] = input[left] * input[left];
                left++;
            }else{
                output[i] = input[right] * input[right];
                right--;
            }
        }


        return output;

    }

    public static void main(String[] args) {
        SquareSortedArray s = new SquareSortedArray();
        int [] input = {-4,2,3,6,-7,8};

       int[] output =  s.squareSortedArray(input);

       for(int i=0; i<output.length ; i++){
           System.out.println(output[i]);
       }
    }
}
