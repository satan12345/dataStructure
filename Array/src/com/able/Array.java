package com.able;


import java.util.Arrays;

public class Array {

    /**
     * 存放元素的数组
     */
    private int[] data;
    /**
     * data数组中有效元素的个数 或者可以说是数组的下一个元素的索引位置
     */
    private int size;

    /**
     * 初始容量
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 默认构造函数
     */
    public Array() {
        this(10);
    }

    /**
     * 获取当前元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获得数组容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 数据是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向所有元素后添加一个元素
     *
     * @param element
     */
    public void addLast(int element) {
//        if (size >= data.length) {
//            throw new RuntimeException("Add Last failed Array is Full");
//        }
//        data[size] = element;
//        size++;
        add(element, size);
    }

    /**
     * 添加到头部
     *
     * @param element
     */
    public void addFirst(int element) {
        add(element, 0);
    }

    /**
     * 获取指定索引下的元素
     *
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 设置元素
     * @param index
     * @param element
     */
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        data[index] = element;
    }

    /**
     * 指定位置添加元素
     *
     * @param element
     * @param index
     */
    public void add(int element, int index) {
        if (size >= data.length) {
            throw new RuntimeException("Add failed, Array is full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed Require index>=0 and index<=size");
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append(String.format("Array:sie=%d, capacity=%d \n", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


}
