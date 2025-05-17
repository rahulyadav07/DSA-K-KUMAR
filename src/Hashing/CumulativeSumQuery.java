package Hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CumulativeSumQuery {
    public static void main(String[] args) {
        int arr[] = {1,4,1};
        ArrayList<ArrayList<Integer>> queryList = new ArrayList<>();
        queryList.add(new ArrayList<>(List.of(1,1)));
        queryList.add(new ArrayList<>(List.of(2,2)));
        queryList.add(new ArrayList<>(List.of(0, 2)));

        calculateCumulativeSummary(arr, queryList);
    }
    private static void calculateCumulativeSummary(int[] arr, ArrayList<ArrayList<Integer>> queryList) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (ArrayList<Integer> query : queryList) {
            int l = query.get(0);
            int r = query.get(1);
            int sum;

            if (l == 0) {
                sum = prefix[r];
            } else {
                sum = prefix[r] - prefix[l - 1];
            }

            System.out.println("Sum from index " + l + " to " + r + " = " + sum);
        }
    }
}
