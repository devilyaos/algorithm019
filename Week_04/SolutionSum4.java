import java.util.ArrayList;
import java.util.List;

public class SolutionSum4 {
    public int jump(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(nums[0]);
        _dfs(nums, 0, result, tmpList);
        int step = Integer.MAX_VALUE;
        for (List<Integer> list: result) {
            step = Math.min(step, list.size());
        }
        return step;
    }

    private void _dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> tmpList) {
        if (index >= nums.length) {
            result.add(tmpList);
            return;
        }
        int len = Math.min(nums.length, index + nums[index]);
        for (int i = index + 1; i < len; i++) {
            tmpList.add(nums[i]);
            _dfs(nums, i, result, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new SolutionSum4().jump(new int[]{2,3,1,1,4}));
    }
}
