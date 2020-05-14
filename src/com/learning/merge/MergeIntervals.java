package com.learning.merge;

import java.util.*;

public class MergeIntervals {


    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();

        if(intervals.size() < 2){
            return intervals;
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));


        Iterator<Interval> intervalIterator = intervals.listIterator();

        Interval interval = intervalIterator.next();

        int start = interval.start;
        int end = interval.end;


        while(intervalIterator.hasNext()){
            interval =  intervalIterator.next();
            if(interval.start <= end){

                end = Math.max(end, interval.end);

            }else{
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

//        for(int i = 0; i < intervals.size(); i++){
//            if(intervals.get(i).end < intervals.get(i+1).start){
//                mergedIntervals.add(intervals.get(i));
//            }else{
//                mergedIntervals.add(new Interval(intervals.get(i).start, intervals.get(i+1).end));
//            }
//        }

        mergedIntervals.add(new Interval(start, end));


        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}


class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};