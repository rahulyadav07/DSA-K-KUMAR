package Hashing;

import java.util.HashMap;

public class CountTheNumberOfSubArrayWithSumK {
    public static void main(String[] args) {

        int[] arr = {3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
        System.out.print(countNumberOfSubArray(arr, 5));

    }
    private static int countNumberOfSubArray(int[] arr, int k ) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        /**
         * calculate Prefix
         */
        int sum =0;

        int count =0;

        for(int value :arr) {
            sum = sum+value;
            if(map.containsKey(sum-k)) {
                count++;
            }
            else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}
