package com.able;

import java.util.Random;

/**
 * @param
 * @author jipeng
 * @date 2019-09-12 18:30
 */
public class TestQueue {

    public static void main(String[] args) {
        int opCount=100_000;
        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>();
        double time1 = testArrayQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue,time:"+time1+"s");

        LoopQueue<Integer> loopQueue=new LoopQueue<>();
        double time2 = testArrayQueue(loopQueue, opCount);
        System.out.println("loopQueue,time:"+time2+"s");

        /**在10W次的操作中
         * ArrayQueue,time:3.564126452s
         * loopQueue,time:0.013619204s
         */
    }


    private static double testArrayQueue(Queue<Integer> queue, int optCount) {
        long startTime = System.nanoTime();
        Random random=new Random();
        for (int i = 0; i < optCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < optCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime-startTime)/1000_000_000.0;
    }

}

