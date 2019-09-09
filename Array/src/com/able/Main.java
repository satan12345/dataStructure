package com.able;

public class Main {
    public static void main(String[] argsl) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }

        System.out.println(array);

        array.add(100,1);
        System.out.println(array);

        array.addFirst(-1);

        System.out.println(array);
    }
}
