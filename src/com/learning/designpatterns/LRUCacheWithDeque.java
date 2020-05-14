package com.learning.designpatterns;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCacheWithDeque {

    // store keys of cache
    static Deque<Integer> dq;

    // store references of key in cache
    static HashSet<Integer> map;

    // maximum capacity of cache
    static int csize;

    public LRUCacheWithDeque(int n){
        dq = new LinkedList<>();
        map = new HashSet<>();
        csize = n;
    }

    public static void refer(int x){

        if(!map.contains(x)){

            if(dq.size() == csize){
                int last = dq.removeLast();
                map.remove(x);
            } else {
                int index = 0; int i=0;
                Iterator<Integer> it =  dq.iterator();

                while(it.hasNext()){
                    if(it.next() == x){
                            index = i;
                            break;
                    }
                    i++;
                }
                dq.remove(index);
            }
            dq.push(x);
            map.add(x);

        }

    }

    // display contents of cache
    public void display()
    {
        Iterator<Integer> itr = dq.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }



    public static void main(String[] args) {
        LRUCacheWithDeque ca = new LRUCacheWithDeque(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }

}
