import java.util.HashMap;
import java.util.Map;

/**
 * 242 - 有效的字母异位词
 * <p>
 * 0. 暴力法：遍历每个字母出现的次数是否一致
 * 1. 构建一个HashMap，记录每个字母出现的次数，遍历两个字符串，如果字符刚好相同且数量一致，则说明成立
 * 2. 在1的基础上，可以先遍历一个字符串，再遍历另一个字符串时进行相同字符的扣减操作，如果最终没有值大于0的key，则说明成立
 * 3. 在2的基础上，考虑到是小写英文字母，可以使用26位数组来进行保存
 */
public class Solution242 {
    /**
     * 是否为字母异位词 - 哈希计数
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return true - 是 / false - 不是
     */
    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int tmpKey;
        for (char c : s.toCharArray()) {
            tmpKey = c;
            map.put(tmpKey, map.containsKey(tmpKey) ? map.get(tmpKey) + 1 : 1);
        }
        for (char c : t.toCharArray()) {
            tmpKey = c;
            // 如果存在map中没有的key值，说明不是字母异位词
            if (!map.containsKey(tmpKey)) {
                return false;
            }
            map.put(tmpKey, map.get(tmpKey) - 1);
            if (map.get(tmpKey) == 0) {
                map.remove(tmpKey);
            }
        }
        return map.isEmpty();
    }

    /**
     * 是否为字母异位词 - 数组
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return true - 是 / false - 不是
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null)  return false;
        if (s.isEmpty() && t.isEmpty())  return true;
        if (s.length() != t.length()) return false;
        int[] letterShowTimesArr = new int[26];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0, len = sc.length; i < len; i++) {
            letterShowTimesArr[sc[i] - 'a']++;
            letterShowTimesArr[tc[i] - 'a']--;
        }
        for (int times: letterShowTimesArr) {
            if (times != 0)  return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution242 test = new Solution242();
        System.out.println(test.isAnagram2("ab", "a"));
    }
}
