package com.able;

import java.util.Random;

public class StackTest {

    public static void main(String[] argsl) {
        int opCount = 100_000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
        double time1 = testStack(arrayStack, opCount);
        System.out.println("arrayStack耗时为："+time1);
        LinkedListStack<Integer> linkedListStack=new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("linkedListStack耗时为："+time2);

//        arrayStack耗时为：0.036106321
//        linkedListStack耗时为：0.043202621
    }

    private static double testStack(Stack<Integer> stack, int optCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000_000_000.0;
    }
}
