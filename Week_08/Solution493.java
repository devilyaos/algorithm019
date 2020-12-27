public class Solution493 {
    private int count;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start <= end) {
            return;
        }
        int mid = start + (end - start) >> 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            // 此处因为左右已经排序，所以如果左边的数i不能按规则大于右边的某一位数j，则i也不可能按规则大于j后面的所有数，所以直接判断i后面的数即可
            if ((long) nums[i] > 2 * (long) nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        // 统计完之后合并
        int[] tempArr = new int[end - start + 1];
        i = start;
        j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= end) {
            tempArr[idx++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tempArr[idx++] = nums[i++];
        }
        while (j <= end) {
            tempArr[idx++] = nums[j++];
        }
        for (i = 0, j = start; j <= end; i++, j++) {
            nums[j] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution493().reversePairs(new int[]{1,3,5,2,3,1,1}));
    }
}
