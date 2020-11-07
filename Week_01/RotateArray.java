public class RotateArray {
    /**
     * 1. 暴力法求解
     * 时间复杂度O(n * k)
     * 空间复杂度O(1)
     *
     * @param nums 待处理的数组
     * @param k    右移位数
     */
    public void rotate1(int[] nums, int k) {
        int tmp1;
        int len = nums.length;
        if (len == 0) {
            return;
        }
        k = k % len;
        for (int i = 0; i < k; i++) {
            tmp1 = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1);
            nums[0] = tmp1;
        }
    }

    /**
     * 2. 环状替换
     * 因为右移K位元素，可以视作每个元素都向右移动K位，即现有的(index + k) % k即为新的下标（含超出数组后移动到数组头部的操作，即形成环状）
     * 环需要考虑两种场景：
     *  1）闭合单环：所有元素在操作时，都可以填充移动的产生的空缺。参考可知数组长n与移动位数k的最大公约数为1时可形成单环。
     *  2）多环：元素在移动k位时，不能完整填充产生的空位，仅部分元素可以互相填充形成环，所以对多个环进行遍历处理即可处理完全部数据。
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums 待处理的数组
     * @param k    右移位数
     */
    public void rotate2(int[] nums, int k) {
        if (nums.length == 0 || k < 1) {
            return;
        }
        int step = k % nums.length;
        int gcd = findGcd(nums.length, step);
        int position, count;
        for (int i = 0; i < gcd; i++) {
            position = i;
            count = nums.length / gcd - 1;
            for (int j = 0; j < count; j++) {
                position = (position + step) % nums.length;
                // 三次异或可以交换两数
                // 第一次异或计算后，得到一个值a，可以视为两个数的定情信物
                // 第二次异或时，其中一个数用这个定情信物可以还原另一个对象，可以视作逆操作
                // 第三次异或时，用定情信物去找还原后的值，可以再还原出之前的第二个数
                // 简单说，第一次异或完生成定情信物后，双方都可以使用定情信物变成对方
                nums[i] ^= nums[position];
                nums[position] ^= nums[i];
                nums[i] ^= nums[position];
            }
        }
    }

    /**
     * 寻找最大公约数
     * 搜索得知为：欧几里得算法（递归式）, 也叫辗转相除法, 高效稳定， 还有非递归式
     * public static int getGCD1(int num1, int num2) {
     *     // 先获得绝对值，保证负数也可以求
     *     num1 = Math.abs(num1);
     *     num2 = Math.abs(num2);
     *     // 假定第一个数较大；如果第二个较大，在第二轮会颠倒过来
     *     // 如果第二个数为 0，则第一个数就是最大公约数
     *     while (num2 != 0) {
     *         // 求余
     *         int remainder = num1 % num2;
     *         // 交换数，等同递归调用
     *         num1 = num2;
     *         num2 = remainder;
     *     }
     *
     *     return num1;
     * }
     *
     * @param a 数值1
     * @param b 数值2
     * @return 最大公约数
     */
    private int findGcd(int a, int b) {
        if (a == 0 || b == 0) {
            return a + b;
        }
        return findGcd(b, a % b);
    }

    /**
     * 3. 反转数组: 可以看成因为要把最后K位数置换到数组头部，但是置换后顺序与期望相反，所以最后一步调整顺序即可
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param nums 待处理的数组
     * @param k    右移位数
     */
    public void rotate3(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        k = k % len;
        // 先反转全部数组
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    /**
     * 反转数组中的指定元素
     *
     * @param nums  源数组
     * @param start 起点下标
     * @param end   终点下标
     */
    private void reverse(int[] nums, int start, int end) {
        int len = nums.length;
        if (len == 0) {
            return;
        }
        int tmp;
        while(start < end) {
            tmp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = tmp;

        }
    }
}
