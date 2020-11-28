public class Solution55 {
    public boolean canJump4(int[] nums) {
        int count = 0, len = nums.length - 2;
        while (len >= 0) count = nums[len--] > count ? 0: ++count;
        return count == 0;
    }

    public boolean canJump3(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

    // 其实核心思想已经触达了最远点思想，实现太low了
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int[] tmp = new int[nums.length];
        tmp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int tmpVal = nums[i];
            if (tmpVal > 0) {
                for (int j = i + 1, len = Math.min(i + tmpVal + 1, nums.length); j < len; j++) {
                    tmp[j] += 1;
                }
            }
            if (tmp[i] == 0) {
                return false;
            }
            if (tmp[tmp.length - 1] > 0) {
                return true;
            }
        }
        return tmp[tmp.length - 1] > 0;
    }

    // 倒推时应该BFS，比较最远触达，感觉自己是个傻子
    // 似乎可以从最后一个节点不断向前推进，如果向前遍历过程中，没有一个点能访问到该节点，则说明不可达
    // 第二次遍历的时候，可以从可访问到最后一个点的元素继续向前遍历，从后往前DFS，有一条路径可达即可返回，无需全部扫完
    public boolean canJump1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        return _findPath1(nums, nums.length - 1);

    }

    private boolean _findPath1(int[] nums, int lastIndex) {
        for (int i = lastIndex - 1; i >= 0; i--) {
            if (nums[i] >= (lastIndex - i)) {
                if (i == 0 || _findPath1(nums, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution55().canJump2(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
        System.out.println(new Solution55().canJump2(new int[]{2,3,1,1,4}));
        System.out.println(new Solution55().canJump2(new int[]{2, 0, 0}));
        System.out.println(new Solution55().canJump2(new int[]{3,2,1,0,4}));
    }
}
