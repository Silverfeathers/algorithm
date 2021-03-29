package pers.liuq.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithm
 * @description: 链表相关学习
 * @author: liuq
 * @Date: 2021/3/29 19:12
 * @Version: 1.0
 */
public class LinkedListStudy {

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(hasCycle(listNode1));
    }

    /**
     * LeetCode 92: 局部反转链表
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode(0, head), con = hair, tail = null;
        int n = right - left + 1;
        while (left > 1) {
            con = con.next;
            left--;
        }
        con.next = reverse(con.next, n);
        return hair.next;
    }

    public ListNode reverse(ListNode head, int n) {
        ListNode pre = new ListNode(), curr = head, next = null;
        while (n > 0) {
            next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
            n--;
        }
        head.next = curr;
        return pre.next;
    }

    /**
     * LeetCode 206: 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * LeetCode 202: 快乐数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast && fast != 1);
        if (fast == 1){
            return true;
        }
        return false;
    }

    public int getNext(int n) {
        int x = 0;
        while (n != 0) {
            x += (n % 10) * (n % 10);
            n = n / 10;
        }
        return x;
    }

    /**
     * LeetCode 142: 链表判环
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        }while (slow != fast && fast != null && fast.next != null);
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }

    /**
     * LeetCode 141: 链表判环 哈希表
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> resutSet = new HashSet<>();
        if (head == null){
            return false;
        }
        while (head.next != null){
            boolean add = resutSet.add(head);
            if (!add) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * LeetCode 141: 链表判环 快慢指针
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do{
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }while (slow != fast);
        return true;
    }
}
