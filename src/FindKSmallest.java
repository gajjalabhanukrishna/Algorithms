public class FindKSmallest {

    public int[] findKSmallest(int[] arr, int k){
        int result[] = new int[k];


        for(int  i = 0; i<k; i++){
            result[i] = removeRoot(arr);
        }
        System.out.println("Value of k = " + k+ "out of bounds!");
        return result;

    }

    public int removeRoot(int[] arr){
        Heap h = new Heap();
        h.buildMinHeap(arr);
        int min = arr[0];

        arr[0] = arr[arr.length -1];

        return min;

    }

    public static void main(String[] args) {


        int[] heapArray = {9, 4, 7, 1, -2, 6, 5};

        FindKSmallest fs = new FindKSmallest();

        int[] results = fs.findKSmallest(heapArray, 3);

        for(int i = 0; i < results.length; i++)
            System.out.println(results[i]);


    }
}
