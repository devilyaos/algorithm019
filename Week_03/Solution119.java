import java.util.*;

public class Solution119 {
    /**
     * 递归
     *
     * @param rowIndex 行数
     * @return 结果
     */
    public List<Integer> getRow1(int rowIndex) {
        if (rowIndex < 0) return new LinkedList<>();
        if (rowIndex == 0) return Arrays.asList(1);
        if (rowIndex == 1) return Arrays.asList(1, 1);

        List<Integer> list = getRow1(rowIndex - 1);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1, len = list.size(); i < len; i++) {
            result.add(list.get(i) + list.get(i - 1));
        }
        result.add(1);
        return result;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        // 从第二行开始
        for (int i = 1; i <= rowIndex; i++) {
            // 因为计算的时候使用的是j - 1 + j进行的计算，所以j>=1即可
            // 因为list没有初始值，所以最后一位没有值，无法像c那样直接累加
            for (int j = i - 1; j >= 1; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution119().getRow2(3));
    }
}
