### 概念

1. **哈希表**：也叫散列表，键值对结构，根据key的哈希值作为存储的映射，进行直接存储取用的结构，一般为线程不安全的。
2. **映射**：和哈希表的结构类似，但是是线程安全的，一般取哈希的值不能重复。
3. **树**：是一种父子结构的关系，链表可以视作特殊化的tree，即子节点仅有一个。同时，树是不能闭环的，即首尾是不能相连的。
4. **二叉树**：每个节点至多只有两个孩子节点的树。
5. **二插搜索树**：左节点全部小于父节点，右节点全部大于父节点。
6. **堆**：可以快速找到一堆数中最大值或最小值的数据结构。
7. **大/小顶堆**：也叫大/小根堆，最大/小的值在堆顶的堆。



###  分析

#### HashMap

1. 实现方式：位桶+链表+红黑树

   > 存储时放入Key-Value，通过对Key哈希计算，得到存放的位置，在该位置存放数据；
   >
   > 当发生哈希碰撞时（即不同key的哈希值重复），则放入同一个key对应的链表中，当链表超过一定阈值时，则改为红黑树。

2. 初始化时，会默认分配一个大小的内存池，如果不断添加，到达阈值时，在添加前会动态添加大小，，所以如果开始时能确定容量大小，则初始化时指定大小即可。
3. 理想状况下，查询的复杂度为O(1)，但因为哈希碰撞后，数据放入同一个链表，极端情况下需要遍历全部链表，即O(n)，所以遍历的最坏情况是o(n)。

![来自网络](./watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3poZW5nd2FuZ3p3,size_16,color_FFFFFF,t_70.png)



#### 树遍历

1. 树的顺序遍历分为前序遍历、中序遍历以及后序遍历。

   * 前序遍历：根-左-右
   * 中序遍历：左-根-右
   * 后续遍历：左-右-根

2. 数的遍历方法一般常用迭代法

   ```java
   /**
    * 前序遍历
    */
   public void scanTree1(TreeNode root) {
     if (root == null) return;
     // 根
     deal(root.val);
     // 左
     scanTree1(root.left);
     // 右
     scanTree1(root.right);
   }
   
   /**
    * 中序遍历
    */
   public void scanTree1(TreeNode root) {
     if (root == null) return;
     // 左
     scanTree1(root.left);
     // 根
     deal(root.val);
     // 右
     scanTree1(root.right);
   }
   
   /**
    * 后序遍历
    */
   public void scanTree1(TreeNode root) {
     if (root == null) return;
     // 左
     scanTree1(root.left);
     // 右
     scanTree1(root.right);
     // 根
     deal(root.val);
   }
   ```

3. 但是迭代法复杂度较高，一般还可以用栈+迭代法进行操作，一般可以看做深度优先遍历DFS

   ```java
   /**
    * 前序遍历
    */
   public void scanTree1(TreeNode root) {
     if (root == null) return;
     Deque<TreeNode> stack = new LinkedList<>();
     TreeNode tmpNode = root;
     while(!stack.isEmpty() || tmpNode != null) {
       // 指针先遍历左孩子节点，并处理根节点
       while(tmpNode != null) {
         deal(tmpNode.val);
       	stack.push(root);
       	tmpNode = root.left;
       }
       // 左孩子全部遍历完成后，开始处理右节点
       tmpNode = stack.pop();
       node = node.right;
     }
   }
   
   /**
    * 中序遍历
    */
   public void scanTree2(TreeNode root) {
     if (root == null) return;
     Deque<TreeNode> stack = new LinkedList<>();
     TreeNode tmpNode = root;
     while(!stack.isEmpty() || tmpNode != null) {
       // 先遍历所有左孩子，此时不处理根节点
       while(tmpNode != null) {
         stack.push(tmpNode);
         tmpNode = tmpNode.left;
       }
       // 左孩子全部遍历完后，处理节点
       tmpNode = stack.pop();
       deal(tmpNode.val);
       // 根据左根右的规则，此时寻找一下右孩子
       tmpNode = tmpNode.right;
     }
   }
   
   /**
    * 后序遍历
    */
   public void scanTree3(TreeNode root) {
     if (root == null) return;
     Deque<TreeNode> stack = new LinkedList<>();
     TreeNode tmpNode = root;
     TreeNode prevNode = null;
     while(!stack.isEmpty() || tmpNode != null) {
       // 先遍历所有左孩子
       while(tmpNode != null) {
         stack.push(tmpNode);
         tmpNode = tmpNode.left;
       }
       // 左孩子遍历完后，处理节点
       tmpNode = stack.pop();
       if (tmpNode.right == null || tmpNode.right == prevNode) {
         // 该处借用临时变量，当遇到右节点时再向下寻找一次，当寻找返回时遇到
         deal(tmpNode.val);
         prevNode = tmpNode;
         tmpNode = null;
       } else {
         stack.push(tmpNode);
         tmpNode = tmpNode.right;
       }
     }
   }
   ```

   另外，还有精选题解中，对于不强求遍历顺序，最终结果一致的解法

   ```java
   /**
    * 先序遍历
    */
   public List preorder1(TreeNode root){
       Stack stack = new Stack();
       List list = new LinkedList();
       while(!stack.isEmpty() || root!=null){
           if(root!=null){
               List.add(root.val);
               if(root.right!=null)
                   stack.push(root.right);
               root = root.left;
           }else {
               root = stack.pop();
           }
       }
       return list;
   }
   
   /**
    * 先序遍历
    */
   public List preorder2(TreeNode root){
     Stack stack = new Stack();
       List list = new LinkedList();
       while(!stack.isEmpty || root!=null){
           if(root!=null){
               stack.push(root);
               root = root.left;
           } else{
               root = stack.pop();
               list.add(root.val);
               root = root.right;
           }
       }
       return list;
   }
   
   /**
    * 后序遍历
    */
   public List preorder3(TreeNode root){
     TreeNode node = new TreeNode();
       Stack stack = new Stack();
       List list = new LinkedList();
       while(!stack.isEmpty() || root!=null){
           if(root!=null){
               //头插法
               List.addFirst(root.val);
               if(root.left!=null)
                   stack.push(root.left);
               //优先访问右子树
               root = root.right;
           }else {
               root = stack.pop();
           }
       }
       return list;
   }
   ```

   

#### 大根堆、小根堆

1. 第K大的数/前K大的数：小根堆

   ```java
   public void topK(int[] nums) {
     PriorityQueue<Integer> heap = new PriorityQueue<>();
     for (int num: nums) {
       heap.offer(num);
       // 如果当前堆中元素数量超过k，则删除堆顶，即删掉最小值
       // 最终留下来的则为前k大的值，堆顶为第k大的值
       if (heap.size() > k) {
         heap.poll();
       }
     }
     deal(heap, k);
   }
   ```

   

2. 第K小的数/前K小的数：大根堆

   ```java
   public void topK(int[] nums) {
     // 优先级队列默认为小根堆，需要重写比较条件
     PriorityQueue<Integer> heap = new PriorityQueue<>((a1, a2) -> a2 - a1);
     for (int num: nums) {
       heap.offer(num);
       // 如果当前堆中元素数量超过k，则删除堆顶，即删掉最大值
       // 最终留下来的则为前k小的值，堆顶为第k小的值
       if (heap.size() > k) {
         heap.poll();
       }
     }
     deal(heap, k);
   }
   ```

3. 该类问题还可以使用快排的思想做，即确定一个中间值T，将比T大的值都挪到T右边，比T小的值都挪到T左边，根据取大取小，在左边或者右边在进行该交换，循环往复后，找到第k个数，[0, k-1]或[0, k+1]即为题解。