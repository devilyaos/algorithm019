import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    /**
     * 生成括号
     *
     * @param n 共需多少对括号
     * @return 所有可能
     */
    public List<String> generateParenthesis(int n) {
        return generate(0, 0, n,"", new ArrayList<>());
    }

    /**
     * 生成括号，转化为可以生成多少个左括号与右括号并配对的问题
     * 当left小于n的时候，可以添加左括号，右括号只能在左括号后添加
     * @param left 左括号的个数
     * @param right 右括号的个数
     * @param n 目标对数
     * @param str 当前字符串
     * @return 结果列表
     */
    private List<String> generate(int left, int right, int n, String str, List<String> list) {
        if (left == n && right == n) {
            list.add(str);
            return list;
        }
        // 当left小于n的时候，说明还可以添加左括号
        if (left < n) generate(left + 1, right, n, str + "(", list);
        if (left > right) generate(left, right + 1, n, str + ")", list);
        return list;
    }
}
