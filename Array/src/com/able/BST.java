package com.able;

/**
 * @param
 * @author jipeng
 * @date 2019-09-18 19:56
 */
public class BST<E extends Comparable<E>> {

    /**
     * 根节点
     */
    private Node root;
    /**
     * 容量
     */
    private int size;

    public BST(){
        root=null;
        size=0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return getSize()==0;
    }

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
}

