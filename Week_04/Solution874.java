import java.util.HashSet;
import java.util.Set;

public class Solution874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for (int[] arr: obstacles) {
            set.add(arr[0] + "," + arr[1]);
        }
        int[] directArr = {0, 1};
        int[] currentPoint = {0, 0};
        int result = 0;
        int tmpx = 0, tmpy = 0;
        for (int command: commands) {
            if (command < 0) {
                updateDirectArr(command, directArr);
                continue;
            }
            while (command-- > 0) {
                tmpx = currentPoint[0] + directArr[0];
                tmpy = currentPoint[1] + directArr[1];
                if (!set.contains(tmpx + "," + tmpy)) {
                    currentPoint[0] = tmpx;
                    currentPoint[1] = tmpy;
                    result = Math.max(result, currentPoint[0] * currentPoint[0] + currentPoint[1] * currentPoint[1]);
                }
            }
        }
        return result;
    }

    private void updateDirectArr(int command, int[] lastDirectArr) {
        if (lastDirectArr[1] != 0) {
            lastDirectArr[0] = command == -2 ? lastDirectArr[1] * -1 : lastDirectArr[1];
            lastDirectArr[1] = 0;
        } else {
            lastDirectArr[1] = command == -2 ? lastDirectArr[0] : lastDirectArr[0] * -1;
            lastDirectArr[0] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,-1,4,-2,4};
        int[][] arr2 = {{2,4}};
        System.out.println(new Solution874().robotSim(arr, arr2));
    }

//    public int robotSim(int[] commands, int[][] obstacles) {
//        int[] currentPoint = new int[2];
//        int[] directionArr = new int[]{0, 1};
//        Set<String> set = new HashSet<>();
//        for (int[] arr: obstacles) {
//            set.add(arr[0] + "," + arr[1]);
//        }
//        int result = 0;
//        for (int command : commands) {
//            if (command == -2) {
//                dealDirectionArr(directionArr, -2);
//            } else if (command == -1) {
//                dealDirectionArr(directionArr, -1);
//            } else {
//                while(command-- > 0) {
//                    int tmpx = currentPoint[0] + directionArr[0];
//                    int tmpy = currentPoint[1] + directionArr[1];
//                    if (!set.contains(tmpx + "," + tmpy)) {
//                        currentPoint[0] = tmpx;
//                        currentPoint[1] = tmpy;
//                        result = Math.max(result, currentPoint[0] * currentPoint[0] + currentPoint[1] + currentPoint[1]);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private void dealDirectionArr(int[] directionArr, int type) {
//        if (directionArr[1] > 0) {
//            directionArr[0] = type == -2 ? -1 : 1;
//            directionArr[1] = 0;
//        } else if (directionArr[1] < 0) {
//            directionArr[0] = type == -2 ? 1 : -1;
//            directionArr[1] = 0;
//        } else if (directionArr[0] > 0) {
//            directionArr[0] = 0;
//            directionArr[1] = type == -2 ? 1 : -1;
//        } else if (directionArr[0] < 0) {
//            directionArr[0] = 0;
//            directionArr[1] = type == -2 ? -1 : 1;
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new Solution874().robotSim(new int[]{-2,-1,-2,3,7}, new int[][]{{1,-3},{2,-3},{4,0},{-2,5},{-5,2},{0,0},{4,-4},{-2,-5},{-1,-2},{0,2}}));
//    }
}
