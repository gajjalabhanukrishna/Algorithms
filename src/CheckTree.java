public class CheckTree {
    public static boolean isTree(Graph g) {
        int root = 0;
        //Boolean Array to hold the history of visited nodes (by default-false)
        //Make a node visited whenever you enqueue it into queue
        boolean[] visited = new boolean[g.vertices];

        //Create Queue for Breadth First Traversal and enqueue root in it
        Queue<Integer> queue = new Queue<>(g.vertices);

        queue.enqueue(root);
        visited[root] = true;

        //Store the number of visited nodes to check at end if all are visited
        int numberOfVisited = 1; //root is already visited

        //Traverse while queue is not empty
        while (!queue.isEmpty()) {

            //Dequeue a vertex/node from queue and add it to result
            int current_node = queue.dequeue();

            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then enqueue them in the Queue
            DoublyLinkedList<Integer>.Node temp = null;
            if(g.adjacencyList[current_node] != null)
                temp = g.adjacencyList[current_node].headNode;

            while (temp != null) {

                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true; //Visit the current Node
                    numberOfVisited++;
                }
                else
                    return false;
                temp = temp.nextNode;
            }
        }//end of while

        //If all vertices are visited then return true
        if (numberOfVisited == g.vertices)
            return true;

        return false;
    }
}
