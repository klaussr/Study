package com.Alex.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Sum10 extends RecursiveTask<Double> {
    final int seqThreshold = 500;
    double[] data;
    int start, end;

    Sum10(double[] v, int s, int e) {
        data = v;
        start = s;
        end = e;
    }

    protected Double compute() {
        double sum = 0;
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
        } else {
            int middle = (start + end) / 2;
            Sum10 subTask1 = new Sum10(data, start, middle);
            Sum10 subTask2 = new Sum10(data, middle, end);

            subTask1.fork();
            subTask2.fork();

            sum = subTask1.join() + subTask2.join();
        }
        return sum;
    }
}
public class RecurTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        double[] nums = new double[5000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) (((i % 2) == 0) ? i : -i);
        }
        Sum10 task = new Sum10(nums, 0, nums.length);
        System.out.println("Суммирование " + forkJoinPool.invoke(task));
    }
}
