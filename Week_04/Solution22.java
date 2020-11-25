import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        _dfs(result, "", n, n);
        return result;
    }

    private void _dfs(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left > 0) {
            _dfs(result, str + "(", left - 1, right);
        }
        if (left < right) {
            _dfs(result, str + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }
}
