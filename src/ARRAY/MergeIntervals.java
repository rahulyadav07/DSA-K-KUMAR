package ARRAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        printList(intervals);
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        System.out.println("dfjkhjdsjkfhjdshjf");
        printList(intervals);

    }
    private static void printList(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
