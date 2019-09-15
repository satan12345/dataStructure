package com.able;

public class LinkedList<E> {
    //虚拟节点
    private Node dummyHead;
    //链表的容量
    private int size;

    public LinkedList() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向链表头部添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
//        创建新节点
//        Node node = new Node(e);
//        新节点的下一个节点指向原来的头结点
//        node.next = dummyHead;
//       头结点 指向新创建的节点
//        dummyHead = node;
//        dummyHead = new Node(e, dummyHead);
        add(0,e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("wrong index");
        }
       /* 引入虚拟节点
       if (index == 0) {
            addFirst(e);
            return;
        }*/
        Node prev = dummyHead;
        //找到要添加索引的前一个索引的元素 用他作为新添加元素的前一个元素
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        //创建新节点
//        Node node=new Node(e);
        //新节点的下一个节点 指向原来索引下一个节点
//        node.next=prev.next;
        //前一个节点指向当前节点
//        prev.next=node;

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
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
            return "Node{" +
                    "e=" + e +
                    '}';
        }
    }
}
