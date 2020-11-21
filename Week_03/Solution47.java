import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(nums[0]);
            result.add(tmpList);
            return result;
        }
        List<Integer> tmpList = new ArrayList<>();
        int[] usedArr = new int[nums.length];
        Arrays.sort(nums);
        dfs(result, tmpList, nums, 0, usedArr);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> tmpList, int[] nums, int start, int[] usedArr) {
        if (start == nums.length) {
            result.add(new ArrayList<>(tmpList));
        }
        for (int i = 0; i < nums.length; i++) {
            if (usedArr[i] == 1) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && usedArr[i - 1] == 0) {
                continue;
            }
            usedArr[i] = 1;
            tmpList.add(nums[i]);
            dfs(result, tmpList, nums, start + 1, usedArr);
            usedArr[i] = 0;
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution47().permuteUnique(new int[]{1,1,2}));
    }
}
