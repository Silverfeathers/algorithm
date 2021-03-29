package pers.liuq.linkedList;

/**
 * @program: algorithm
 * @description: 链表节点
 * @author: liuq
 * @Date: 2021/3/29 19:13
 * @Version: 1.0
 */
public  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}