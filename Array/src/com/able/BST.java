package com.able;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

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

    /**
     * 查询是否存在元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node parent, E e) {
        //节点为null 则不存在还有元素
        if (parent == null) {
            return false;
        }
        //节点中的元素跟要查询的元素相同 则存
        if (e.compareTo(parent.e) == 0) {
            return true;
        } else if (e.compareTo(parent.e) < 0) {
            //元素小于节点中的元素 则继续中节点的左节点开始查找
            return contains(parent.left, e);
        } else {
            //元素大于节点中的元素 则继续从节点的右子树节点开始递归
            return contains(parent.right, e);
        }

    }

    /**
     * 非递归二分搜索树的前序遍历
     */
    public void preOderNR() {
        Stack<Node> stack = new Stack<>();
        //节点入栈
        stack.push(root);
        //循环判断栈是否为null
        while (!stack.isEmpty()) {
            //元素出栈
            Node pop = stack.pop();
            System.out.println(pop.e);
            //节点的又子树入栈
            if (pop.right != null) {
                stack.push(pop.right);
            }
            //节点左子树入栈
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public void preLevelOder() {
        Queue<Node> queue = new LinkedList<>();
        //入队
        ((LinkedList<Node>) queue).addLast(root);
        //循环判断队列是否为空
        while (!queue.isEmpty()) {
            //队列中的元素
            Node node = ((LinkedList<Node>) queue).removeFirst();
            System.out.println(node.e);
            if (node.left != null) {
                ((LinkedList<Node>) queue).addLast(node.left);
            }
            if (node.right != null) {
                ((LinkedList<Node>) queue).addLast(node.right);
            }
        }
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历 以Node为根节点的二分搜索树 递归算法
    private void preOrder(Node e) {
        if (e == null) {
            return;
        }
        //对当前节点进行访问操作
        System.out.println(e.e);
        //遍历左子树
        preOrder(e.left);
        //遍历右子树
        preOrder(e.right);
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        midOrder(root);
    }

    private void midOrder(Node parent) {
        if (parent == null) {
            return;
        }
        //递归调用当前节点的左子树
        midOrder(parent.left);
        //操作当前元素的节点
        System.out.println(parent.e);
        //递归调用当前节点的右子树
        midOrder(parent.right);

    }

    //后续遍历
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        //操作左子树
        postOrder(node.left);
        //操作右子树
        postOrder(node.right);
        //操作当前节点
        System.out.println(node.e);

    }

    public E minimum1() {
        if (isEmpty()) {
            throw new RuntimeException("empty tree");
        }
        Node cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.e;
    }

    /**
     * 最小值
     *
     * @return
     */
    public E minimum() {
        if (isEmpty()) {
            throw new RuntimeException("empty tree");
        }
        Node node = minimum(root);
        return node.e;
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);

    }

    public E maxNum1() {
        if (isEmpty()) {
            throw new RuntimeException("empty tree");
        }
        Node cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.e;
    }

    /**
     * 最大值
     *
     * @return
     */
    public E maxNum() {
        if (isEmpty()) {
            throw new RuntimeException("empty tree");
        }
        return maxNode(root).e;
    }

    public Node maxNode(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxNode(node.right);
    }

    /**
     * 移除最小值
     *
     * @return
     */
    public E removeMin() {
        E minimum = minimum();
        root = removeMin(root);
        return minimum;

    }

    /**
     * 查找到节点为根的二分搜索树 返回移除最小值的二叉树 将其作为节点的左子树
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        //找到最小节点 删除 并返回删除后的新的根节点
        if (node.left == null) {
            Node retNode = node.right;
            node.right = null;
            size--;
            return retNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 移除最大值
     * @return
     */
    public E removeMax() {
        E max = maxNum();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node root) {
        if (root.right == null) {
            Node left = root.left;
            root.right = null;
            size--;
            return left;
        }
        root.right = removeMax(root.right);
        return root;
    }


    public static void main(String[] argsl) {

        BST<Integer> bst=new BST<>();
        Random random=new Random();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }
        System.out.println(bst.minimum());
        List<Integer> list=new ArrayList<>();
        while (!bst.isEmpty()) {
            list.add(bst.removeMin());
        }
        System.out.println(list);


//        BST<Integer> bst = new BST<>();
//        int[] nums = new int[]{5, 3, 6, 8, 4, 2};
//        for (int num : nums) {
//            // bst.add(num);
//            bst.add1(num);
//        }
        //////////////////////////////
        //            5             //
        //          /  \            //
        //         3    6           //
        //        / \     \         //
        //       2   4     8        //
        //////////////////////////////
//        bst.preOrder();
//        System.out.println("=======");
////        System.out.println(bst);
//
//        // bst.midOrder();
//        bst.preOderNR();
//        System.out.println("===");
//        bst.preLevelOder();
//        System.out.println("===============");
//        System.out.println(bst.minimum());
//        System.out.println(bst.minimum1());
//
//        System.out.println("==============");
//        System.out.println(bst.maxNum());
//        System.out.println(bst.maxNum1());
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        generateBstString(root, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private void generateBstString(Node node, int depth, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append(generateDepthSring(depth) + "NULL\n");
            return;
        }
        stringBuilder.append(generateDepthSring(depth) + node.e + "\n");
        generateBstString(node.left, depth + 1, stringBuilder);
        generateBstString(node.right, depth + 1, stringBuilder);
    }

    private String generateDepthSring(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
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

