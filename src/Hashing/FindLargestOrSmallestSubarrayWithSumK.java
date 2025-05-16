package Hashing;

import java.util.HashMap;

public class FindLargestOrSmallestSubarrayWithSumK {
    //3,1 3,-2, 2
    public static void main(String[] args) {
        int[] arr = {3,1,3,-2,2};

        int[] result = largestOrSmallestSubarray(arr, 4);

        System.out.print(result[0] );
    }

    private static int[] largestOrSmallestSubarray(int[] arr, int k) {
        int sum = 0;
        int smallestSubArrayLength = 0;
        int[] result = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for(int i = 0;i<arr.length;i++) {
            sum =- sum +arr[i];
            if(map.containsKey(sum-k)) {
                int length = i+1-map.get(sum-k);
                if (length> smallestSubArrayLength){
                    smallestSubArrayLength = length;
                    result[0] = map.get(sum-k)+1;
                    result[1] =i+1;
                }
            }
            if (map.containsKey(sum)) {
                map.put(sum, i+1);
            }
        }
        return result;
    }

}
