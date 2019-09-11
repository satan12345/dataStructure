package com.able;

public class Main {
    public static void main(String[] argsl) {
        Array<String> array = new Array(20);
        for (int i = 0; i < 11; i++) {
            array.addLast(String.valueOf(i)+"X");
        }

//
//        System.out.println(array);
//
//        array.add(100,1);
//        System.out.println(array);
//
//        array.addFirst(-1);

        System.out.println(array);

        array.removeLast();
        System.out.println(array);
//        array.remove(19);
//        array.removeFirst();
//        System.out.println(array);
//        array.removeLast();
//        System.out.println(array);
    }
}
