package com.learning.graph;

import java.util.*;

public class TaskScheduling {

    public static boolean isSchedulingPossible(int task, int prerequisites[][]){

        List<Integer> sortedOrder = new ArrayList<>();

        if(task <= 0){
            return false;
        }

        //Initialize graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i< task; i++){
            inDegree.put(i,0);
            graph.put(i, new ArrayList<Integer>());
        }

        //build Graph

        for(int i =0; i < prerequisites.length ; i++){
            int parent = prerequisites[i][0]; int child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }


        Queue<Integer> source =  new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()){
            if(entry.getValue() == 0){
                source.add(entry.getKey());
            }
        }

        while(!source.isEmpty()){
            int vertex = source.poll();

            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);

            for(int child : children){
                inDegree.put(child, inDegree.get(child)-1);

                if(inDegree.get(child) == 0){
                    source.add(child);
                }
            }

        }

        return task == sortedOrder.size();

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
