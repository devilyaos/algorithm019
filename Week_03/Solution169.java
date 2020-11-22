import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution169 {
    // 先排序，然后遍历查找
    public int majorityElement1(int[] nums) {
        // 因为假定是存在多数元素，所以数组不可能为空
        int targetMinNum = nums.length / 2;
        Arrays.sort(nums);
        int pre = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if (i - pre + 1 > targetMinNum) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];
    }

    // 摩尔投票
    public int majorityElement2(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new Solution169().majorityElement2(new int[]{3,3,4}));
    }
}
