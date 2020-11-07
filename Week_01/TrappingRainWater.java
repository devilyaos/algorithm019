import java.util.Stack;

/**
 * TODO 待复习
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        TrappingRainWater test = new TrappingRainWater();
        System.out.println(test.trap1(new int[]{4, 2, 3}));
        System.out.println(test.trap1D1(new int[]{4, 2, 3}));
        System.out.println(test.trap2(new int[]{4, 2, 3}));
        System.out.println(test.trap3(new int[]{4, 2, 3}));
        System.out.println(test.trap3D1(new int[]{4, 2, 3}));
        System.out.println(test.trap4(new int[]{4, 2, 3}));
    }

    /**
     * 1.可以计算每一层可以接收雨水的面积，累加即为面积和。而能接收雨水的部分，则为扣减层数后两个不为0的元素作为边界。
     *
     * @param height 数组
     * @return 面积
     */
    public int trap1(int[] height) {
        // 先找出最大的数
        int max = 0;
        int len = height.length;
        for (int j : height) {
            max = Math.max(max, j);
        }
        // 寻找当层有边界的为0的个数
        int borderIndex = -1;
        int allArea = 0;
        int oneArea = 0;
        for (int level = 0; level < max; level++) {
            for (int i = 0; i < len; i++) {
                // 当边界条件为false且当前数大于0时，说明有边界
                if (borderIndex < 0 && height[i] > 0) {
                    borderIndex = i;
                }
                // 当有边界记录且当前元素大于0且间距超过1时，则说明一段面积已经形成
                else if (borderIndex > -1 && height[i] > 0) {
                    if (i - borderIndex > 1) {
                        oneArea += i - borderIndex - 1;
                    }
                    borderIndex = i;
                }
                height[i] -= 1;
            }
            allArea += oneArea;
            borderIndex = -1;
            oneArea = 0;
        }
        return allArea;
    }

    /**
     * 1.1 按列求
     *
     * @param height 数组
     * @return 面积
     */
    public int trap1D1(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 2. 动态规划
     *
     * @param height 数组
     * @return 面积
     */
    public int trap2(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 3. 栈
     *
     * @param height 数组
     * @return 面积
     */
    public int trap3(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }

    /**
     * 3.1 栈国际版
     *
     * @param height 数组
     * @return 面积
     */
    public int trap3D1(int[] height) {
        if (height == null) return 0;
        Stack<Integer> s = new Stack<>();
        int i = 0, maxWater = 0, maxBotWater;
        while (i < height.length) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int bot = s.pop();
                maxBotWater = s.isEmpty() ? // empty means no il
                        0 : (Math.min(height[s.peek()], height[i]) - height[bot]) * (i - s.peek() - 1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }

    /**
     * 4. 双指针
     *
     * @param height 数组
     * @return 面积
     */
    public int trap4(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}
