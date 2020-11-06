public class MergeSortedArray {
    /**
     * 将数组2中元素合并到数组1中,并成为有序数组
     * 题目中显示为升序, 故仅考虑升序情况
     * 1. 将数组2拼接到数组1后面，然后对数组1进行排序
     * 2. 每个数组一个指针，比较指针大小
     * 3. 官方题解：双指针从末尾开始比较，结果从末尾开始插入，因为从两个数组的最末尾开始比较，及从两数组的最大值开始比较，
     * 所以比较出的结果一定是两个数组中的最大值，依次类推
     *
     * @param nums1 数组1
     * @param m     数组1中有效元素
     * @param nums2 数组2
     * @param n     数组2中有效元素
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m <= 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n <= 0) {
            return;
        }
        int a = m - 1;
        int b = n - 1;
        int currentIndex = m + n - 1;
        while (a >= 0 && b >= 0) {
            if (nums2[b] > nums1[a]) {
                nums1[currentIndex] = nums2[b];
                b--;
            } else {
                nums1[currentIndex] = nums1[a];
                a--;
            }
            currentIndex--;
        }
        // 当nums1先跑完时，需要将nums2剩余部分填充到nums1的头部
        if (a < 0) {
            System.arraycopy(nums2, 0, nums1, 0, b + 1);
        }
    }
}
