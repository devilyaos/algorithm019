import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionJksj20 {
    public int[] filterRestaurants(int[][] restaurants, int[] filters) {
        // 先筛选出符合条件的餐馆
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a1, a2) -> {
            if (a2[1] < a1[1]) {
                return -1;
            }
            return a2[1] > a1[1] ? a2[1] - a1[1] : a2[0] - a1[0];
        });
        for (int i = 0, len = restaurants.length; i < len; i++) {
            if (check(restaurants[i], filters)) {
                heap.offer(restaurants[i]);
            }
        }
        int size = heap.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = heap.poll()[0];
        }
        return result;
    }

    private boolean check(int[] restaurant, int[] filters) {
        return restaurant[2] == filters[0]
                && restaurant[3] <= filters[1]
                && restaurant[4] <= filters[2];
    }

    public static void main(String[] args) {
        int[][] arr = {{0,4,1,40,10},{1,8,0,50,5},{2,8,1,30,4},{3,10,0,10,3},{4,1,1,15,1}};
        int[] arr2 = new int[]{0, 40, 10};
        System.out.println(new SolutionJksj20().filterRestaurants(arr, arr2));
    }
}
