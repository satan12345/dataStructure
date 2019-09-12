package com.able;

public interface Stack<E> {
    /**
     * 入栈
     * @param e
     */
    void  push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 查看栈顶元素
     * @return
     */
    E peek();

    /**
     * 获取栈中元素个数
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();




}
