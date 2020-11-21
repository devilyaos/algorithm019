public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            // 如果等于val，则从后边复制一个到前面来
            if (nums[start] == val) {
                nums[start] = nums[end];
                end--;
            } else {
                start++;
            }
        }

        return end + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution27().removeElement(new int[]{3,2,2,3}, 3));
    }
}
