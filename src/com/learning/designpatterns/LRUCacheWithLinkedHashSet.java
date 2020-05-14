package com.learning.designpatterns;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUCacheWithLinkedHashSet {

    Set<Integer> cache;
    int capacity;

    public LRUCacheWithLinkedHashSet(int capacity)
    {
        this.cache = new LinkedHashSet<Integer>(capacity);
        this.capacity = capacity;
    }

    public boolean get(int key){
        if(!cache.contains(key)){
            return false;
        }
        cache.remove(key);
        cache.add(key);
        return true;
    }
    /* Refers key x with in the LRU cache */
    public void refer(int key)
    {
        if (get(key) == false)
            put(key);
    }

    public void put(int key)
    {
        // If already present, then
        // remove it first. Note that
        // we are going to add later
        if (cache.contains(key))
            cache.remove(key);

            // If cache size is full, remove the least
            // recently used.
        else if (cache.size() == capacity) {
            int firstKey = cache.iterator().next();
            cache.remove(firstKey);
        }

        cache.add(key);
    }
    // display contents of cache
    public void display()
    {
        Iterator<Integer> itr = cache.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args)
    {
        LRUCacheWithLinkedHashSet ca = new LRUCacheWithLinkedHashSet(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
