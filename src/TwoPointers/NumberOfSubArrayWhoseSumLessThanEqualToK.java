package TwoPointers;

public class NumberOfSubArrayWhoseSumLessThanEqualToK {
    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int limit = 4;
        System.out.println(longestSubarray(nums, limit));
    }
    public static int longestSubarray(int[] arr, int limit) {
        int count =0;

        for(int i =0;i<arr.length;){
            int min = arr[i];
            int max = arr[i];
            int j =i;
            while(j<arr.length) {
                max= Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                int absluteValue = Math.abs(max-min);
                if(absluteValue<=limit) {
                    count++;
                }else{
                    break;
                }
                j++;
            }
            i =j;
        }
        return count;
    }
}
