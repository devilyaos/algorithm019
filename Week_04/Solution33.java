public class Solution33 {
    // 题解异或思路
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low == high && nums[low] == target ? low : -1;
    }
}
