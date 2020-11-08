# 学习笔记

### 数组

1. 开辟一段连续内存地址。
1. 因为通过下标访问，所以访问的时间复杂度为O(1)
1. 插入删除元素时，如果插入删除在末尾，时间复杂度为O(1)，如果在中间插入删除元素，需要将后续的元素向后挪位，最差情况为O(n)。 
1. ArrayList就是基于数组实现的，所以ArrayList的随机访问特别快，为O(1)，同时插入删除也继承了数组的O(n)。
1. ArrayList在新增时，当数组不够时，会进行扩容操作，即copy一个新数组。

### 链表

1. 一般分为单向链表与双向链表。
1. LinkedList就是基于链表实现的，且为双向列表。
1. LinkedList基于链表的操作，插入删除的时间复杂度为O(1)，查询则性能较差，时间复杂度为O(n)。
1. LRU就是基于多链表实现的。

### 跳表

1. 在链表的基础上增加多级索引，在查询时从最高级索引向下查询，直至查到目标数据。
1. 只能用于元素有序的情况。
1. 对标平衡树和二分查找。
1. 插入删除搜索都是O(logn)。
1. Redis，LevelDB等用跳表代替平衡树。
1. 核心思想为：升维+空间换时间。

### 栈

1. 先入后出
1. 添加删除都为O(1)
1. 查询为O(n)

### 队列

1. 先进先出
1. 添加删除都为O(1)
1. 查询为O(n)

### 双端队列

1. 栈和队列的结合体
1. 插入删除是O(1)
1. 查询时O(n)

### 优先级队列

1. 插入O(1)
1. 取出O(logn)：按照元素的优先级取出。
1. 底层使用堆实现。

### 常用解题模板

1. 双指针循环
    ```java
    for (int i = 0; i < length; i++) {
        for (int j = i + 1; j < length; j++) {
            dealLogic();
        }
    }
    ```

1. 双指针夹逼
    ```java
    int i = 0;
    int j = end - 1;
    while(i < j) {
        dealLogic()
        if (judge(arr[i], arr[j])) {
            i++;
        } else {
            j--;
        }
    }
    ```

1. 双数组双指针
    ```java
    int a = 0;
    int b = 0;
    while(a <= maxA && b <= maxB) {
        if (judge(arrA[a], arrB[b])) {
            dealLogic(arrA[a]);
            a++;
        } else {
            dealLogic(arrB[b]);
            b++;
        }
    }
    ```

1. 利用hash去重
    ```java
    Set<T> set = new HashSet<>();
    for (int i = 0; i < length; i++) {
        if (set.contains(arr[i])) {
            continue;
        }
        dealLogic();
    }
    ```

1. 链表插入与删除中间节点
    ```java
    // 新增
    ListNode tmpNode = new ListNode();
    tmpNode.next = nodeA.next;
    nodeA.next = tmpNode;
    // 删除
    ListNode tmpNode = new ListNode();
    tmpNode = nodeA.next;
    nodeA.next = tmpNode.next;
    tmpNode.next = null;
    tmpNode = null;
    ```

1. 数组插入与删除中间节点(空间充足)
    ```java
    // 新增
    System.arraycopy(arr, targetIndex, arr, targetIndex + 1, length - targetIndex);
    arr[targetIndex] = targetValue;
    // 删除
    System.arraycopy(arr, targetIndex + 1, arr, targetIndex, length - targetIndex);
    arr[length - 1] = 0;
    ```
   
1. 数字型数组交换位置
    ```java
    arr[a] ^= arr[b];
    arr[b] ^= arr[a];
    arr[a] ^= arr[b];
    ```
