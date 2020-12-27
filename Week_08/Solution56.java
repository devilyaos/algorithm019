import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] arr: intervals) {
            if (idx == -1 || arr[0] > res[idx][1]) {
                res[++idx] = arr;
            } else {
                res[idx][1] = Math.max(res[idx][1], arr[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
