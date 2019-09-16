package com.able;

public class LinkedList<E> {
    //虚拟节点
    private Node dummyHead;
    //链表的容量
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除指定位置的节点
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal Index");
        }
        //用于定位要删除节点的前一个节点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //当前要删除的节点
        Node delNode = prev.next;
        //前一个节点的下一个节点 指向要删除节点的下一个节点
        prev.next = delNode.next;
        //方便GC
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 获取指定索引位的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal Index");
        }

        Node cur = dummyHead.next;
        for (Integer i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 更新指定索引位的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal Index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /***查找链表中是否存在元素
     * @author jipeng
     * @date 2019/9/16 18:23
     * @return boolean
     **/

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return Boolean.TRUE;
            }
            cur = cur.next;
        }
        return Boolean.FALSE;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            stringBuilder.append(cur + "->");
            cur = cur.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
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
        add(0, e);
    }

    /**
     * 指定索引为添加节点
     *
     * @param index
     * @param e
     */
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
        for (int i = 0; i < index; i++) {
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
            return e.toString();
        }
    }
}
