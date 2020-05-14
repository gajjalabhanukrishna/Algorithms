public class ProductArrayBhanu {

    public static void main(String args[]) {

        int[] arr = {-1, 2, -3, 4, -5};

        System.out.println("Array before product: " + arrayToString(arr));

        int[] prodArray = findProduct(arr);

        System.out.println("Array after product: " + arrayToString(prodArray));
    }

    public static String arrayToString(int arr[]){
        if (arr.length > 0){
            String result = "";
            for(int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        }
        else {
            return "Empty Array!";
        }
    }

    public static int[] findProduct(int arr[])
    {
        int n = arr.length;
        int i = 0, j, temp = 1;

        // Allocation of result array
        int result[] = new int[n];

        while(i<n){
            for(j=0; j<n; j++){
                if(i != j){
                    temp *= arr[j];
                }
            }
            result[i] = temp;
            temp=1;
            i++;
        }

        return result;
    }
}
