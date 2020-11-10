import java.util.*;

public class Solution49 {
    /**
     * 字母异位词分组
     * 1. 可以利用哈希表将每个组合存储起来，以排序后字母作为key，value则为列表，最终将列表组合成一个列表即可
     *
     * @param strs 待区分的数组
     * @return 分组
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);
        String tmpStr;
        char[] tmpCharArr;
        for (String s: strs) {
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
}
