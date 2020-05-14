public class SinglyLinkedList<T> {

    public Node headNode;
    public int size;

    public SinglyLinkedList(){
        headNode = null;
        int size = 0;
    }

    public boolean isEmpty(){
        if(headNode == null){
            return true;
        }
        return false;
    }

    public void insertAtHead(T data){
        Node node = new Node();
        node.data=data;
        node.nextNode = this.headNode;
        headNode = node;
        size++;
    }

    public void insertAtTail(T data){
        Node node = new Node();
        node.data=data;
        node.nextNode = null;

        if(isEmpty()){
            insertAtHead(data);
            return;
        }

        Node last = this.headNode;

        while(last.nextNode != null){
            last = last.nextNode;
        }

        last.nextNode = node;
        size++;

    }

    public void insertAfter(T data, T previous){
        Node node = new Node();
        node.data=data;
        node.nextNode = null;

        Node current = this.headNode;


        while(current != null && !current.data.equals(previous)){
            current = current.nextNode;
        }

        node.nextNode = current.nextNode;
        current.nextNode = node;

        size++;
    }

    public boolean searchNode(T data){

        if(isEmpty()){
            return false;
        }

        Node current = this.headNode;

        while(current != null){
            if(current.data.equals(data)){
                return true;
            }
            current = current.nextNode;
        }



        return false;
    }

   public void deleteAtHead(){
       if(isEmpty()){
           return;
       }
       headNode = headNode.nextNode;

       size--;

   }

   public void deleteByValue(T data){
       if(isEmpty()){
           return;
       }

       Node current = this.headNode;
       Node previous = null;

       if(current.data.equals(data)) {
           //data is at head so delete from head
           deleteAtHead();
           return;
       }

       while(current != null){
           if(current.data.equals(data)){
               previous.nextNode = current.nextNode;
               return;
           }
           previous = current;
           current = current.nextNode;
       }
    }

    public static <T> void reverse(SinglyLinkedList<T> list){
        Node next = null;
        Node prev = null;
        Node current = list.headNode;

        while(current != null){
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        list.headNode = prev;
    }

    public static <T> boolean detectLoop(SinglyLinkedList<T> list){
        Node slow = list.headNode;
        Node fast = list.headNode;
        while(slow != null && fast != null && fast.nextNode != null){
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static <T> Object findMiddle(SinglyLinkedList<T> list) {

        Node current = list.headNode;
        Node mid = list.headNode;

        while(current != null && mid != null && current.nextNode != null){
            current = current.nextNode.nextNode;

            if(current != null){
                mid = mid.nextNode;
            }
        }

        return mid.data;
    }

    public static <T> void removeDuplicates(SinglyLinkedList<T> list){
        Node current = list.headNode;
        Node compare = null;

        while(current != null && current.nextNode != null){
            compare = current;
            while(compare.nextNode !=  null){
                if(current.data.equals(compare.nextNode.data)){
                    compare = compare.nextNode.nextNode;
                }else{
                    compare = compare.nextNode;
                }
            }
            current  = current.nextNode;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> s = new SinglyLinkedList<>();
        int i =0;
        while(i < 10){

            s.insertAtTail(i);

            i++;

        }


        s.printList();
        s.deleteAtHead();
        s.deleteByValue(5);
        s.printList();
        System.out.println( s.searchNode(5));
        reverse(s);
        s.printList();
        System.out.println(findMiddle(s));
    }


}
