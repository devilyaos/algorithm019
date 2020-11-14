import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionJz40 {
    /**
     * 找出最小的K个数
     * 大顶堆实现，将每个元素放入大顶堆，如果堆大小超过k，则删除堆顶最终堆中所有的值即为题解
     *
     * @param arr 数组
     * @param k   元素数量
     * @return 结果数组
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a1, a2) -> a2 - a1);
        for (int num : arr) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    /**
     * 找出最小的K个数
     * 仿快排
     *
     * @param arr 数组
     * @param k   元素数
     * @return 结果数组
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        if (arr.length <= k) {
            return arr;
        }
        return partitionArray(arr, 0, arr.length - 1, k);
    }

    private int[] partitionArray(int[] arr, int start, int end, int k) {
        int j = partition(arr, start, end);
        if (j == k) {
            return Arrays.copyOf(arr, j + 1);
        }
        return j > k ? partitionArray(arr, start, j - 1, k) : partitionArray(arr, j + 1, end, k);
    }

    private int partition(int[] arr, int start, int end) {
        int value = arr[start];
        int i = start, j = end + 1;
        while(true) {
            while(++i <= end && arr[i] < value);
            while(--j >= start && arr[j] > value);
            if (i >= j) {
                break;
            }
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
        }
        arr[start] = arr[j];
        arr[j] = value;
        return j;
    }
}
