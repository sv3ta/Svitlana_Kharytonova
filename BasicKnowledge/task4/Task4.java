package ua.home.task4;

import java.util.Arrays;

public class Task4 {
    private static int countOfPairs(int[] a, int target) {
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    k++;
                }
            }
        }
        return k;
    }

    private static int countOfPairsByStreams(int[] a, int target) {
        long k = Arrays.stream(a).peek(value -> Arrays.stream(a).filter(value1 -> value + value1 == target)).count() / 2;
        return (int) k;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 2, 2, 0, 4, 5};
        int target = 5;
        System.out.println(countOfPairs(a, target));
        System.out.println(countOfPairsByStreams(a, target));
    }
}
