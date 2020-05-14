public class Stack <T> {

    private int top;
    private int maxSize;
    private T array[];

    public Stack(int maxSize){

        this.maxSize = maxSize;
        this.top = -1;
        array = (T[]) new Object[maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public T top(){
        if(isEmpty())
            return null;
        return array[top];
    }

    public T pop(){

        if(isEmpty()){
            return null;
        }
        return array[top--];// return and decrease top

    }

    public void push(T value){
        if(isFull()){
            System.err.println("Stack is full");
        }
        array[++top] = value; // increase top and add value
    }

}
