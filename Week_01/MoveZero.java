public class MoveZero {

    public static void main(String[] args) {
        MoveZero test = new MoveZero();
        test.execute2(new int[]{1, 0, 3, 0, 4, 0, 5});
        test.execute2(new int[]{0, 0, 1});
        test.execute2(new int[]{1, 0, 0});
        test.execute2(new int[]{1, 1});
    }

    /**
     * 移动零
     * 双指针: 一个指针正常遍历，一个指针指向可交换的值为0的元素，形成快慢指针，当遇到不为0的数时，直接将后方的数与前方的0进行交换
     *
     * @param nums 待操作的数组
     */
    public void execute1(int[] nums) {
        // 少于两个元素时无需操作
        if (nums.length < 2) {
            return;
        }
        int tmpIndex = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            // 只有当元素不为0的时候才移动tmpIndex指针, 否则指针停留原地等待交换
            if (nums[i] != 0) {
                // 当两个指针重合时,说明当前还没有遇到0,此时不用做无用的交换,保持原位即可
                if (i > tmpIndex) {
                    nums[tmpIndex] = nums[i];
                    // 交换后将当前遍历元素的值置为0,达到交换的目的
                    // 因为tmpIndex遇到0的时候会停留,所以此时可以视作与tmpIndex位置进行交换
                    nums[i] = 0;
                }
                tmpIndex++;
            }
        }
    }

    /**
     * 移动零
     * 双循环: 先将所有非零的记录移动到数组的前面，再将后面的元素全部置为零
     * 其实本质上和双指针的处理方式大同小异
     *
     * @param nums 待处理数组
     */
    public void execute2(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int j = 0;
        int len = nums.length;
        // 先将所有的非0元素复制到数组前方
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < len; j++) {
            nums[j] = 0;
        }
    }
}
