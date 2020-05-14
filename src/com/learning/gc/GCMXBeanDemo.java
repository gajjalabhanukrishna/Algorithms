package com.learning.gc;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class GCMXBeanDemo {
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> beans =  ManagementFactory.getGarbageCollectorMXBeans();

        for(GarbageCollectorMXBean bean : beans){
            System.out.println("Name : "+bean.getName());
            System.out.println("CollectionCount : "+bean.getCollectionCount());
            System.out.println("CollectionTime : "+bean.getCollectionTime());

            for (String name : bean.getMemoryPoolNames()){
                System.out.println("\t" + name);
            }

        }
    }
}
