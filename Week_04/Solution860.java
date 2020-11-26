public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) {
            return false;
        }
        int[] changesArr = new int[2];
        for (int pay: bills) {
            if (pay == 5) {
                changesArr[0]++;
            } else if (pay == 10) {
                if (changesArr[0] > 0) {
                    changesArr[1]++;
                    changesArr[0]--;
                } else {
                    return false;
                }
            } else {
                if (changesArr[0] > 0 && changesArr[1] > 0) {
                    changesArr[0]--;
                    changesArr[1]--;
                } else if (changesArr[0] >= 3) {
                    changesArr[0] -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
