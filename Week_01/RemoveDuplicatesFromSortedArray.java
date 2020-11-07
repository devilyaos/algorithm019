public class RemoveDuplicatesFromSortedArray {
    /**
     * 1、双指针遍历，一个指针遍历，一个指针指向下一个可以插入的位置.
     * 因为数组给定条件为排序数组，所以与插入位置指针的上一位进行比较，相同则不插入
     * 且题目仅要求前N位符合要求即可，LENGTH - N位的元素无需处理，所以直接从后往前复制即可
     *
     * @param nums 原始数组
     * @return 不重复的元素数
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 排序数组，第一个元素一定不移动，所以直接从第二个元素开始
        int a = 1;
        int b = 1;
        int len = nums.length;
        while (a < len) {
            if (nums[a] > nums[b - 1]) {
                // 考虑到
                nums[b++] = nums[a];
            }
            a++;
        }
        return b;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray test = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = test.removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
