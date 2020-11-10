import java.util.*;

public class Solution49 {
    /**
     * 字母异位词分组
     * 1. 可以利用哈希表将每个组合存储起来，以排序后字母作为key，value则为列表，最终将列表组合成一个列表即可
     *
     * @param strs 待区分的数组
     * @return 分组
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);
        String tmpStr;
        char[] tmpCharArr;
        for (String s : strs) {
            tmpCharArr = s.toCharArray();
            Arrays.sort(tmpCharArr);
            tmpStr = new String(tmpCharArr);
            if (!map.containsKey(tmpStr)) {
                map.put(tmpStr, new ArrayList<>());
            }
            map.get(tmpStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 字母异位词分组
     * 2. 利用26个英文字母的特性减少sort开销
     *
     * @param strs 待区分的数组
     * @return 分组
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        char[] letterArr = new char[26];
        Map<String, List<String>> map = new HashMap<>(strs.length);
        char[] tmpArr;
        String tmpKey;
        for (String s: strs) {
            tmpArr = s.toCharArray();
            for (char c: tmpArr) {
                letterArr[c - 'a']++;
            }
            tmpKey = String.valueOf(letterArr);
            if (!map.containsKey(tmpKey)) {
                map.put(tmpKey, new LinkedList<>());
            }
            map.get(tmpKey).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
