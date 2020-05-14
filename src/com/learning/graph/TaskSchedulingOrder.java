package com.learning.graph;

import java.util.*;

public class TaskSchedulingOrder {



    public static List<Integer>  findOrder(int items, int[][] edges){

        List<Integer> results = new ArrayList<>();

        // initialize graph

        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0; i< items; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // build graph
        for(int i =  0; i< edges.length; i++){
            int parent = edges[i][0];
            int child = edges[i][1];

            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);

        }

        Queue<Integer> source = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0){
                source.add(entry.getKey());
            }
        }


        while(!source.isEmpty()){

            int vertex = source.poll();
            results.add(vertex);

            List<Integer> children =  graph.get(vertex);

            for(int child : children){
                inDegree.put(child, inDegree.get(child) - 1);

                if(inDegree.get(child) == 0)
                    source.add(child);
            }
        }

        if(results.size() != items){
            return  new ArrayList<>();
        }


        return results;
    }


    public static void main(String[] args) {
        List<Integer> result = TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(3,
                new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
        System.out.println(result);

        result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println(result);
    }
}
