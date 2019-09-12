package com.able;

/**
 * @author jipeng
 * @date 2019-09-12 11:16
 * @description
 */
public interface Queue<E> {
    /**
     * 入队
     * @param e
     */
    void  enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    E getFront();

    /**
     * 查询队列中的元素个数
     * @return
     */
    int getSize();

    /**
     * 判断是否为空
     * @return
     */
    boolean isEmpty();
}
