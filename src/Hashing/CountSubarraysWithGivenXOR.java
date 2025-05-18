package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenXOR {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;

        System.out.println(calculatingXOR(arr, k));
    }

    /**
     * samjh nhi aaya sahi se
     * @param arr
     * @param k
     * @return
     */
    private static int calculatingXOR(int arr[], int k ) {
            Map<Integer, Integer> map = new HashMap<>();
            int xor = 0;
            int count = 0;

            for (int num : arr) {
                xor ^= num;
System.out.println(xor);
                if (xor == k) {
                    count++; // current prefix xor is equal to k
                }

                int required = xor ^ k;

                if (map.containsKey(required)) {
                    count += map.get(required);
                }

                map.put(xor, map.getOrDefault(xor, 0) + 1);
            }

            return count;

    }
}
