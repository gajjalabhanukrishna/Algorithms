public class ReverseKChallenge {

    //1.Push first k elements in queue in a stack.
    //2.Pop Stack elements and enqueue them at the end of queue
    //3.Dequeue queue elements till "k" and append them at the end of queue
    //4.Dequeue the remaining elements and enqueue them again to append them at end of the queue
    public static <V> void reverseK(Queue<V> queue, int k) {
        if (queue.isEmpty() || k <= 0)
            return;
        Stack<V> stack = new Stack<>(k);

        while(!stack.isFull())
            stack.push(queue.dequeue());

        while(!stack.isEmpty())
            queue.enqueue(stack.pop());

        int size = queue.getCurrentSize();
        for(int i = 0; i < size - k; i++)
            queue.enqueue(queue.dequeue());
    }

    public static void main(String[] args) {
            Queue queue = new Queue(10);

            while(queue.currentSize < 10){
                queue.enqueue(queue.currentSize);
            }

            int i=0;
            while(i <10){
                System.out.println(queue.array[i]);
                i++;
        }


        reverseK(queue, 5);
        int j=0;
        while(j <10){
            System.out.println(queue.array[j]);
            j++;
        }


    }
}
