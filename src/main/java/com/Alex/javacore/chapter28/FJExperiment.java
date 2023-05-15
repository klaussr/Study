package com.Alex.javacore.chapter28;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Transform extends RecursiveAction {
    int seqThreshold;
    double[] data;
    int start, end;

    Transform(double[] vals, int s, int e, int t) {
        data = vals;
        start = s;
        end = e;
        seqThreshold = e;
    }

    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0) data[i] = Math.sqrt(data[i]);
                else data[i] = Math.cbrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new Transform(data, start, middle, seqThreshold), new Transform(data, middle, end, seqThreshold));
        }
    }
}

public class FJExperiment {
    public static void main(String[] args) {
        int pLevel;
        int threshold;
        Scanner scanner = new Scanner(System.in);

        pLevel = Integer.parseInt(scanner.next());
        threshold = Integer.parseInt(scanner.next());

//        if (args.length != 2) {
//            System.out.printf("Использование: FJExperiment параллелизм порог");
//            return;
//        }

        long beginT, endT;
        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        double[] nums = new double[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) i;
        }
        Transform task = new Transform(nums, 0, nums.length, threshold);

        beginT = System.nanoTime();
        fjp.invoke(task);
        endT = System.nanoTime();

        System.out.println("Уровень параллелизма " + pLevel);
        System.out.println("Порог последовательной обработки " + threshold);
        System.out.println("Истекшее время " + (endT - beginT) + " нс");
    }
}
