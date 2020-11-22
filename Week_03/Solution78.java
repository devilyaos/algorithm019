import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        for (Integer n : nums) {
            for (int i = 0, len = result.size(); i < len; i++) {
                List<Integer> newSub = new ArrayList<>(result.get(i));
                newSub.add(n);
                result.add(newSub);
            }
        }
        return result;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        _deal(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void _deal(List<List<Integer>> result, ArrayList<Integer> tmpList, int[] nums, int start) {
        result.add(new ArrayList<>(tmpList));
        for (int i = start; i < nums.length; i++) {
            tmpList.add(nums[i]);
            _deal(result, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[3];
        for (int i = 1; i < 4; i++) {
            arr[i - 1] = i;
        }
        System.out.println(new Solution78().subsets2(arr));
    }
}
