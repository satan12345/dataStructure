package com.able;

/**
 * @param
 * @author jipeng
 * @date 2019-09-17 9:53
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        //创建虚拟头结点 用于连接原来的头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        //初始化虚拟头结点为前一个节点 循环判断前一个节点的下一个节点是否为null
        // 不为null的时候则判断value值是否相等 相等则将节点从链表中移除 不相等则位移前一个节点的指针
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElements1(ListNode head, int val) {
        //在不使用虚拟头结点的时候 对头结点进行特殊处理
        if (head == null) {
            return head;
        }
        //头结点的值等于val
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                break;
            }
        }
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }

        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

