package com.able;

/**
 * @param
 * @author jipeng
 * @date 2019-09-12 11:22
 */
public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue() {
        this.array = new Array<>();
    }
    public ArrayQueue(int capaCity) {
        this.array = new Array<>(capaCity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return  array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("queue front");
        stringBuilder.append("[");

        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i!=array.getSize()-1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("] tail ");
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        for (int i = 0; i <10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if (i%3==2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }
}

