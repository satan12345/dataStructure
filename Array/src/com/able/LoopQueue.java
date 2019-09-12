package com.able;

/**
 * @param
 * @author jipeng
 * @date 2019-09-12 15:35
 */
public class LoopQueue<E> implements Queue<E> {
    /**
     * 数组容器
     */
    private E[] data;
    /**
     * 队首索引 与队尾索引
     */
    private int front, tail;
    /**
     * 队列中元素个数
     */
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        //判断队列是否满了
        if ((tail + 1) % data.length == front) {
            reSize(getCapacity() * 2);
        }
        //元素入队
        data[tail] = e;
        //队尾索引+1 （取模用于控制数字在数组长度之间）
        tail = (tail + 1) % data.length;
        //队列中元素个数+1
        size++;
    }

    /**
     * 扩容
     *
     * @param newCapacity
     */
    private void reSize(int newCapacity) {
        //创建新的容器
        E[] newData = (E[]) new Object[newCapacity + 1];
        //把原来队列中的元素添加到新的数组中
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 出队
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        //获取队首元素
        E e = getFront();
        //将数组引用设置为null 便于GC
        data[front] = null;
        //队首索引后移
        front = (front + 1) % data.length;
        //队列中元素-1
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 > 1) {
            reSize(getCapacity() / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取容积
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("LoopQueue size=%d,capacity=%d \n", size, getCapacity()));
        stringBuilder.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            stringBuilder.append(data[i]);
            if ((i+1)%data.length!=tail) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args){
      LoopQueue loopQueue=new LoopQueue();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i%3==0) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }

    }
}

