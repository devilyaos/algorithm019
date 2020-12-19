public class Solution208 {
    class Trie {

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode tmpNode = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (tmpNode.nexts[c - 'a'] == null) {
                    tmpNode.nexts[c - 'a'] = new TrieNode();
                }
                tmpNode = tmpNode.nexts[c- 'a'];
            }
            tmpNode.endFlag = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode tmpNode = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (tmpNode.nexts[c - 'a'] == null) {
                    return false;
                }
                tmpNode = tmpNode.nexts[c - 'a'];
            }
            return tmpNode.endFlag;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode tmpNode = root;
            int len = prefix.length();
            for (int i = 0; i < len; i++) {
                char c = prefix.charAt(i);
                if (tmpNode.nexts[c - 'a'] == null) {
                    return false;
                }
                tmpNode = tmpNode.nexts[c - 'a'];
            }
            return true;
        }

        class TrieNode {
            TrieNode[] nexts;
            boolean endFlag;

            TrieNode() {
                nexts = new TrieNode[26];
                endFlag = false;
            }
        }
    }
}
