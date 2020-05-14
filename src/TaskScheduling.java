import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskScheduling {

    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {

        List<Integer> sortedOrder = new ArrayList<>();
        if(tasks == 0){
            return false;
        }

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for(int i = 0; i< tasks; i++){
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());

        }

        // b. Build the graph
        for(int i = 0; i < prerequisites.length; i++){
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);

        }


        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for(int i =0; i<inDegree.size(); i++){
            if(inDegree.get(i) == 0){
                sources.add(i);
            }
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while(!sources.isEmpty()){
            int vertex = sources.poll();

            sortedOrder.add(vertex);
            List<Integer> childVertex = graph.get(vertex); // get the node's children to decrement their in-degrees

            for(int i =0; i< childVertex.size(); i++){

                inDegree.put(childVertex.get(i), inDegree.get(childVertex.get(i))-1);
                if(inDegree.get(childVertex.get(i)) == 0){
                    sources.add(childVertex.get(i));
                }
            }

        }

        // if sortedOrder doesn't contain all tasks, there is a cyclic dependency between tasks, therefore, we
        // will not be able to schedule all tasks
        return sortedOrder.size() == tasks;

    }

    public static void main(String[] args) {
        boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println("Tasks execution possible: " + result);

        result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
                new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println("Tasks execution possible: " + result);
    }
}
