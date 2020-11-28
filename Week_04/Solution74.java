public class Solution74 {
    // 因为从左到右升序，从上到下升序，所以可以用每行第一个元素做跳表，然后在每行中二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int targetLevel = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length == 0) {
                return false;
            }
            if (matrix[i][0] == target || matrix[i][matrix[i].length - 1] ==  target) {
                return true;
            }
            if (matrix[i][0] < target && matrix[i][matrix[i].length - 1] > target) {
                targetLevel = i;
                break;
            }
        }
        if (targetLevel < 0) {
            return false;
        }
        int[] targetArr = matrix[targetLevel];
        return binarySearch(targetArr, target, 0, targetArr.length - 1);
    }

    private boolean binarySearch(int[] targetArr, int target, int start, int end) {
        if (start >= targetArr.length || end < 0 || start > end) return false;
        int middle = start + (end - start) / 2;
        if (targetArr[middle] > target) {
            return binarySearch(targetArr, target, start, middle - 1);
        }
        if (targetArr[middle] < target) {
            return binarySearch(targetArr, target, middle + 1, end);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
//        int[][] arr = new int[][]{{1,3, 5}};
        System.out.println(new Solution74().searchMatrix(arr, 13));
    }
}
