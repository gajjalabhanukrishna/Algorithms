public class CountLargestGroup {
    public int countLargestGroup(int n) {
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            int s = sumDigit(i);
            count[s]++;
        }

        int max = 0, res = 0;
        for (int x : count) {
            if (x > max) {
                max = x;
                res = 1;
            } else if (x == max) {
                res++;
            }
        }
        return res;
    }

    private int sumDigit(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountLargestGroup cg = new CountLargestGroup();
        cg.countLargestGroup(13);
    }
}
