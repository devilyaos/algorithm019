public class Solution153 {
    // 可以考虑双指针头尾夹逼, 并采用二分思想每次用中点跳一半
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int a = 0, b = nums.length - 1;
        while(a < b) {
            int mid = a + (b - a) / 2;
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            }
            if (nums[mid] >= nums[b]) {
                a = mid + 1;
            } else {
                b = mid;
            }
        }
        return nums[a];
    }

    public static void main(String[] args) {
        System.out.println(new Solution153().findMin(new int[]{4,5,6,7,1,2,3}));
    }
}
