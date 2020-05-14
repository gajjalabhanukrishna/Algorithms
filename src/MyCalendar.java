import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
//    TreeMap<Integer, Integer> calendar;
//
//    MyCalendar() {
//        calendar = new TreeMap();
//    }

    List<int[]> calendar;

    MyCalendar() {
        calendar = new ArrayList();
    }

//    public boolean book(int start, int end) {
//        Integer prev = calendar.floorKey(start),
//                next = calendar.ceilingKey(start);
//
//        System.out.println(prev +":"+ next);
//        if ((prev == null || calendar.get(prev) <= start) &&
//                (next == null || end <= next)) {
//            calendar.put(start, end);
//            return true;
//        }
//        return false;
//    }
//public boolean book(int start, int end) {
//    Map.Entry<Integer, Integer> beforeEnd = calendar.lowerEntry(end);
//    if (beforeEnd != null && beforeEnd.getValue() > start) {
//        return false;
//    }
//    calendar.put(start, end);
//    return true;
//}

    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();

        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(15, 25)); // returns false
        System.out.println(myCalendar.book(20, 30)); // returns true
    }
}
