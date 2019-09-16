package com.able;

public class LinkedListQueue<E> implements Queue<E> {

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        //创建新节点
        Node node = new Node(e);
        if (tail == null) {
            //尾节点为 null 说明链表中还没有元素
            tail = node;
            head = node;
            size++;
            return;
        }
        //当前尾节点的下一个节点指向新增加的节点
        tail.next = node;
        //当前的尾节点指向新节点
        tail = node;
        //数量++
        size++;


    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("can not dequeue from an empty queue");
        }
        //获取要出队的节点
        Node cur = head;
        //头结点指向头结点的下一个节点
        head = head.next;
        //断开当前节点与队列的关联 便于GC
        cur.next = null;
        //如果新头节点的指针指向null 那么说明队列中已经没有元素了 为空 所以尾节点索引也应为nul
        if (head == null) {
            tail = null;
        }
        //数量-1
        size--;
        return cur.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue front ");
        Node cur = head;
        while (cur != null) {
            stringBuilder.append(cur + "->");
            cur = cur.next;
        }
        stringBuilder.append("Null tail");
        return stringBuilder.toString();
    }

    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] argsl) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if (i % 3 == 2) {
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }

}
