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

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void add1(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        }
        add1(root, e);
    }

    /**
     * 向以node为根的二分搜索树添加元素e  递归算法
     *
     * @param node
     * @param e
     */
    private void add1(Node node, E e) {
        if (e.compareTo(node.e) == 0) {
            return;
        }
        //要插入的元素小于节点的元素 且节点的左节点为null 则要插入的元素变为该节点的左子树
        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        }
        //要插入的元素大于节点的元素 且节点的右子树为nul 则要插入的元素变为该节点的右子树
        if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        //要插入的元素小于节点的元素 且节点的左节点不为null 则把当前节点的左节点作为下一次调用的根节点
        if (e.compareTo(node.e) < 0 && node.left != null) {
            add(node.left, e);
            return;
        }
        //要插入的元素大于节点的元素 且节点的右子树不为nul 则把当前节点的右节点作为下一次调用的根节点
        if (e.compareTo(node.e) > 0 && node.right != null) {
            add(node.right, e);
            return;
        }
    }

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 以Node为根的二分搜索树种插入元素e 递归算法
     * 返回插入新节点后的二分搜索树的根
     *
     * @param parentNode
     * @param e
     * @return
     */
    private Node add(Node parentNode, E e) {
        //只有的node为空的时候 才递归结束 返回新节点
        if (parentNode == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(parentNode.e) > 0) {
            parentNode.right = add(parentNode.right, e);
        } else if (e.compareTo(parentNode.e) < 0) {
            parentNode.left = add(parentNode.left, e);
        }
        return parentNode;
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

