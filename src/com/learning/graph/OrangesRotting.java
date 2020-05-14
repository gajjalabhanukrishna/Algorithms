package com.learning.graph;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }

        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        for(int i =0; i < ROWS; i++){
            for(int j=0; j<COLS; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[] {i,j});
                }else if(grid[i][j] == 1){
                    count_fresh++;
                }
            }
        }

        if(count_fresh == 0) return 0;
        int count = 0;

        while(!queue.isEmpty()){
            ++count;
            int size = queue.size();
            int dirs[][]= {{0,1},{0,-1},{1,0},{-1,0}};

            for(int i=0; i<size; i++){
                int[] point = queue.poll();

                for(int dir[] : dirs){
                    int x = point[0] + dir[0];
                    int y = point[1] + point[0];

                    if(x > 0 && x < grid.length && y>0 && y < grid.length && grid[x][y] != 2){
                        continue;
                    }
                    grid[x][y] = 2;
                    queue.add(new int[]{x,y});
                    count_fresh--;

                }
            }

        }

        return count_fresh == 0? count-1 :-1;
    }
}
