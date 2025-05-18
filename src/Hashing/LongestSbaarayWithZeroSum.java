package Hashing;

import java.util.HashMap;

public class LongestSbaarayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int value = findLongestSubArray(arr);
        System.out.println(value);
    }
    private static int findLongestSubArray(int[] arr) {

        int sum = 0;
        int maxLength =0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0;i<arr.length;i++) {
            sum = sum+arr[i];
            if (sum ==0){
                maxLength = i+1;
            }
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum)); // ✅ only use if key exists
            } else {
                map.put(sum, i); // 👈 only put if not already present
            }
        }
        return maxLength;
    }
}
