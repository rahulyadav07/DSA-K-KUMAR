package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,2,3};
        System.out.println(findLongestConsecutive(nums));
    }
    private static int findLongestConsecutive(int nums[]) {
        int result =0;
        Set<Integer> set = new HashSet<>();
        // pahle saare element ko set mae daal do set liya kyoki repeative char bhi ho skte h
        for(int value:nums){
            set.add(value);
        }

        /**
         * yaha for array pr itrate kra uske baad hame lagaratar aane wale char ko dekhna h
         */
        for(int value: nums) {
            int currentLargestLength = 0;
            int currentValue = value;
            while (set.contains(currentValue)) {
                currentLargestLength++;
                currentValue++;
            }
            result =Math.max(result, currentLargestLength);
        }
        return result;
    }
}
