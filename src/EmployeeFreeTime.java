import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        int OPEN = 0, CLOSE = 1;

        List<int[]> events = new ArrayList();
        for (List<Interval> employee: avails)
            for (Interval iv: employee) {
                events.add(new int[]{iv.start, OPEN});
                events.add(new int[]{iv.end, CLOSE});
            }

        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        List<Interval> ans = new ArrayList();

        int prev = -1, bal = 0;
        for (int[] event: events) {
            // event[0] = time, event[1] = command
            if (bal == 0 && prev >= 0)
                ans.add(new Interval(prev, event[0]));
            bal += event[1] == OPEN ? 1 : -1;
            prev = event[0];
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Interval>> intervals = new ArrayList<>();
        EmployeeFreeTime e = new EmployeeFreeTime();
       // [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
        Interval ee = new Interval(1,3);

        intervals.add(Arrays.asList(new Interval(1,3),new Interval(6,7)));
        intervals.add(Arrays.asList(new Interval(2,4)));
        intervals.add(Arrays.asList(new Interval(2,5),new Interval(9,12)));

        System.out.println(e.employeeFreeTime(intervals));
    }
}
