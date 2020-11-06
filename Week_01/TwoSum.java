import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        test.execute1(new int[]{1, 2}, 3);
        test.execute1(new int[]{3, 4, 1, 6, 2}, 7);

        test.execute2(new int[]{1, 2}, 3);
        test.execute2(new int[]{3, 4, 1, 6, 2}, 7);
    }

    /**
     * 双重循环暴力寻找
     *
     * @param nums 数组
     * @return 符合条件的元素下标
     */
    public int[] execute1(int[] nums, int target) {
        for (int i = 0, len = nums.length; i < len; i++) {
            // 在i前方的记录已经遍历过, 无需重复计算
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 借助哈希构造缓存
     *
     * @param nums   原始数组
     * @param target 目标加值
     * @return 新数组
     */
    public int[] execute2(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[0];
    }
}
