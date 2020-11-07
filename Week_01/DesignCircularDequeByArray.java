/**
 * 数组实现双端队列
 * 题解中的头尾颠倒感觉应该是方便获取所有元素时可以直接将头尾交换达到正常的数组排序，感觉本题无需考虑头尾交换
 *
 */
public class DesignCircularDequeByArray {

    private int[] items;
    private int head = -1;
    private int last;
    private int currentSize = 0;
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public DesignCircularDequeByArray(int k) {
        this.items = new int[k];
        this.capacity = k;
        this.last = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (currentSize == capacity) {
            return false;
        }
        items[++head] = value;
        currentSize++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (currentSize == capacity) {
            return false;
        }
        items[--last] = value;
        currentSize++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (currentSize == 0) {
            return false;
        }
        if (head == -1) {
            items[capacity - 1] = 0;
            for (int i = capacity - 1; i > last; i--) {
                items[i] = items[i - 1];
            }
            items[last++] = 0;
        } else {
            items[head--] = 0;
        }
        currentSize--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (currentSize == 0) {
            return false;
        }
        if (last == capacity) {
            items[0] = 0;
            for (int i = 0; i < head; i++) {
                items[i] = items[i + 1];
            }
            items[head--] = 0;
        } else {
            items[last++] = 0;
        }
        currentSize--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (currentSize == 0) {
            return -1;
        }
        if (head == -1) {
            return items[capacity -1];
        }
        return items[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (currentSize == 0) {
            return -1;
        }
        if (last == capacity) {
            return items[0];
        }
        return items[last];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return currentSize == capacity;
    }
}
