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
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node==null) {
            return;
        }
        //操作左子树
        postOrder(node.left);
        //操作右子树
        postOrder(node.right);
        //操作当前节点
        System.out.println(node.e);

    }

    public static void main(String[] argsl) {
        BST<Integer> bst = new BST<>();
        int[] nums = new int[]{5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            // bst.add(num);
            bst.add1(num);
        }
        //////////////////////////////
        //            5             //
        //          /  \            //
        //         3    6           //
        //        / \     \         //
        //       2   4     8        //
        //////////////////////////////
        bst.preOrder();
        System.out.println("=======");
//        System.out.println(bst);

        bst.midOrder();
        System.out.println("===");
        bst.postOrder();
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

