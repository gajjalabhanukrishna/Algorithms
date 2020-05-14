public class CheckNumEdges {
    public static int numEdges(Graph g) {

        // For undirected graph, just sum up the size of
        // all the adjacency lists for each vertex and then divide it by 2.
        // It will give us total number of edges in the graph.
        int sum = 0;

        for (int i = 0; i < g.vertices; i++) {

            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[i] != null)
                temp = g.adjacencyList[i].headNode;

            while (temp != null) {
                sum++;
                temp = temp.nextNode;
            }
        }
        return sum/2;
    }
}
