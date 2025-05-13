package Hashing;

import java.util.HashMap;

public class DistanceLessThanEqualToK {

    public static void main(String[] args) {
      int[] arr = {3,2,4,3,6,4};
      int n = 3;
      System.out.println(bruetForceApproch(arr, n));
      System.out.print(solveByUsingHashing(arr, n));
    }

    private static Boolean bruetForceApproch(int[] arr, int k ) {
        for(int i =0;i<arr.length;i++) {
            for(int j = i+1; j<arr.length && j<i+k; i++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }

        }
        return  false;
    }

    /**
     *bhai ye check kr last mae kab aaya tha agr last mae k ki distance se kam h toh valid h warna nhi
     */
    private static Boolean solveByUsingHashing(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i =0;i<arr.length;i++) {
            if (map.containsKey(arr[i])) {
                int value =  map.get(arr[i]);
                int distance = i-value;
                if (distance<=k) {
                    return true;
                }
            }
            else {
                map.put(arr[i], i);
            }

        }
        return  false;
    }
}
