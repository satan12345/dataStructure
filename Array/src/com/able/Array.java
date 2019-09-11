package com.able;


public class Array<T> {

    /**
     * 存放元素的数组
     */
    private T[] data;
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
        data = (T[]) new Object[capacity];
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
    public void addLast(T element) {
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
    public void addFirst(T element) {
        add(element, 0);
    }

    /**
     * 获取指定索引下的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    /**
     * 设置元素
     *
     * @param index
     * @param element
     */
    public void set(int index, T element) {
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
    public void add(T element, int index) {
        //判断index 是否在范围中
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed Require index>=0 and index<=size");
        }
        //数组容量已经满了
        if (size == data.length) {
           // throw new RuntimeException("Add failed, Array is full");
            resize(2*data.length);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    private void resize(int capacity) {
        T[] newData= (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i]=data[i];
        }
        data=newData;

    }

    /**
     * 包含元素
     *
     * @param element
     * @return
     */
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i])) {
                return true;
            }
        }
        return false;
    }
    /***删除指定元素
    * @author jipeng
    * @date 2019/9/10 20:58
    * @return void
    **/
    public boolean removeElement(T element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 删除指定索引位的元素
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index error");
        }
        T node = data[index];
        /**
         * 指定i为要删除索引的后一个元素 之所以用i=index+1 则是为了保证用后一个元素不会超过size,导致数组越界
         *   for (int i = index; i < size; i++) {
         *             data[i ] = data[i+1];
         *         }
         *         这种写法 会存在在删除最后一个元素的时候 数组越界的问题
         */
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //这种情况会存在最后一个元素还在 所以需要通过data[size]=null 来释放最后一个元素 便于GC
        data[size]=null;

        if (size==data.length/2) {
            resize(data.length/2);
        }
        return node;
    }

    /***删除第一个元素
     * @author jipeng
     * @date 2019/9/10 20:53
     * @return int
     **/

    public T removeFirst() {
        return remove(0);
    }

    /***删除最后一个元素
     * @author jipeng
     * @date 2019/9/10 20:54
     * @return int
     **/

    public T removeLast() {
        return remove(size - 1);
    }


    /***
     * 查找元素的索引
     * @param element
     * @return
     */
    public int find(T element) {
        for (int i = 0; i < size; i++) {
            if (element == data[i]) {
                return i;
            }
        }
        return -1;
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


//    @Override
//    public String toString() {
//        return new StringJoiner(", ", Array.class.getSimpleName() + "[", "]")
//                .add("data=" + Arrays.toString(data))
//                .add("size=" + size)
//                .toString();
//    }
}
