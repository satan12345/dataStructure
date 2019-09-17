package com.able;

public class Sum {

    public static void main(String[] argsl) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(new Sum().sum(arr));
    }

    public int sum(int[] arr) {
        return calc(arr, 0);
    }

    private int calc(int[] arr, int index) {
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + calc(arr, index + 1);
    }
}
