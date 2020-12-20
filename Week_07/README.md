## 字典树

* 数据结构

  是一种树形结构，典型应用是用于统计和排序大量的字符串（不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。这也是他的一个**优点**：最大限度的减少无谓的字符串比较，查询效率比哈希高。

* 核心思想

  1. Trie树的核心思想是空间换时间。
  2. 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

* 基本性质

  1. 结点本身不存完整单词
  2. 从根结点到某一结点，路径上经过的字符连接起来，为该节点对应的字符串。
  3. 每个结点的所有子结点路径代表的字符串都不相同。
  4. 结点可以一并存储其他信息，例如词频。

代码模板

```java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```



## 并查集

Union-Find 算法解决的是图的动态连通性问题，这个算法本身不难，能不能应用出来主要是看你抽象问题的能力，是否能够把原始问题抽象成一个有关图论的问题。例如朋友圈问题，或者岛屿问题，可以看做矩阵有效点的连通性问题，获得不连通元素的数量。

并查集模板中，主要是parent数组的类型需要根据实际需要进行变化。

并查集代码模板（未路径压缩）

```java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

并查集使用模板（朋友圈问题示例）

```java
public int findCircleNum(int[][] M) {
  int n = M.length;
  UnionFind uf = new UnionFind(n);
  for (int i = 0; i < n; i++) {
    // 这里j小于i，是因为朋友圈的矩阵是个沿（i, i）对称的矩阵，所以只要判断半边即可
    for (int j = 0; j < i; j++) {
      if (M[i][j] == 1) {
        uf.union(i, j);
      }
    }
  }
  return uf.count;
}
```

## 高级搜索，红黑树，AVL树

高级搜索其实不是一种固定的算法，而是一种对基础算法的优化思想。例如剪枝，双向BFS等，还有例如给BFS时增加权重属性，提前先搜索高权重的分支，提高搜索的成功率，减少搜索的时间的启发式搜索。

其实高级搜索的核心思想是减少遍历路径，从而变相提高搜索效率和搜索质量。



而红黑树和AVL树，其实也是对于基础数据结构的一种优化，从数据结构优化入手提高检索效率。