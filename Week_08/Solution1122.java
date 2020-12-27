public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] countTmpArr = new int[1001];
        int[] result = new int[arr1.length];
        int index = 0;
        for (int item: arr1) {
            countTmpArr[item]++;
        }
        for (int item: arr2) {
            while (countTmpArr[item] > 0) {
                result[index++] = item;
                countTmpArr[item]--;
            }
        }
        for (int i = 0; i < 1001; i++) {
            if (countTmpArr[i] < 1) {
                continue;
            }
            while (countTmpArr[i] > 0) {
                result[index++] = i;
                countTmpArr[i]--;
            }
        }
        return result;
    }
}
