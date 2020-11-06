class PlusOne {
    /**
     * 加一
     *
     * @param digits 待加一的数组
     * @return 加一以后的数组
     */
    public int[] execute(int[] digits) {
        int len = digits.length;
        // 从最后一位向前遍历
        for (int i = len - 1; i >= 0; i--) {
            // 如果不为9, 则不会发生进位的情况
            // 如果不发生进位, 则在当前位结束加一操作
            if (digits[i] != 9) {
                digits[i] += 1;
                break;
            }
            // 如果为9, 则说明进位, 将本位置为0, 模拟进位
            digits[i] = 0;
        }
        // 如果第一位最终为0, 说明最高位需要进位, 此时则需要数组扩容
        // java特性, 新数组
        if (digits[0] == 0) {
            int[] arr = new int[len + 1];
            arr[0] = 1;
            return arr;
        }
        return digits;
    }
}
