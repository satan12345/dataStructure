package com.able;

/**
 * @param
 * @author jipeng
 * @date 2019-09-17 9:53
 */
public class Solution {
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        //当前节点下一个节点 关联后面的链表
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

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

    public static void main(String[] argsl) {
        int[] arr = new int[]{1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

//        ListNode result = new Solution().removeElements(listNode, 6);
//        System.out.println(result);
        ListNode result = new Solution().removeElements2(listNode, 6);
        System.out.println(result);


    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val + "->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}

