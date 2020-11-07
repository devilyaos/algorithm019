public class MergeTwoSortedLists {
    /**
     * 递归
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并升序链表
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 迭代
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode result = new ListNode();
        ListNode c = result;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                c.next = new ListNode(a.val);
                a = a.next;
            } else {
                c.next = new ListNode(b.val);
                b = b.next;
            }
            c = c.next;
        }
        if (a != null) {
            c.next = a;
        } else if (b != null) {
            c.next = b;
        }
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
