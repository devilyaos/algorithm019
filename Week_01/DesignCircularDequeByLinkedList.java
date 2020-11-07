/**
 * 目前实现为双端链表实现，也可以使用数组实现，只是为了熟悉下链表的操作
 */
public class DesignCircularDequeByLinkedList {

    private ItemNode head = null;

    private ItemNode last = null;

    private int currentSize = 0;

    private int maxSize = 0;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public DesignCircularDequeByLinkedList(int k) {
        maxSize = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (currentSize == maxSize) {
            return false;
        }
        ItemNode node = new ItemNode(value);
        if (head != null) {
            node.next = head;
            head.prev = node;
        } else {
            // head and last must be null at the same time
            last = node;
        }
        head = node;
        currentSize++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (currentSize == maxSize) {
            return false;
        }
        ItemNode node = new ItemNode(value);
        if (last != null) {
            last.next = node;
            node.prev = last;
        } else {
            head = node;
        }
        last = node;
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
        if (currentSize == 1) {
            currentSize--;
            head = null;
            last = null;
            return true;
        }
        currentSize--;
        ItemNode tmpNode = head;
        head = head.next;
        head.prev = null;
        tmpNode.next = null;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (currentSize == 0) {
            return false;
        }
        if (currentSize == 1) {
            currentSize--;
            head = null;
            last = null;
            return true;
        }
        currentSize--;
        ItemNode tmpNode = last;
        last = last.prev;
        last.next = null;
        tmpNode.prev = null;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (head == null) {
            return -1;
        }
        return head.value;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (last == null) {
            return -1;
        }
        return last.value;
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
        return currentSize == maxSize;
    }

    /**
     * Define item node structure
     */
    private class ItemNode {
        int value;
        ItemNode next = null;
        ItemNode prev = null;

        ItemNode() {
        }

        ItemNode(int _value) {
            this.value = _value;
        }
    }
}
