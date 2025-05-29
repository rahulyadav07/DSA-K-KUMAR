package DP;

public class SubsetOfArrayAreNotAdjecent {

    public static void main(String[] args) {
        int arr1[] = {2,3,4,-8,2};
        int arr2[] = {-5,8,3,1,-4};
        System.out.print(calculateMaxSumSubset(arr1, arr2));
    }
    private static int calculateMaxSumSubset(int arr1[], int arr2[]) {
        int dp[] = new int[arr1.length];
        dp[0] = Math.max(arr1[0], arr2[0]);
        dp[1] = Math.max(dp[0], Math.max(arr1[1], arr2[1]));

        for( int i =2;i<arr1.length;i++) {
            int x = dp[i-1];
            int y = arr1[i]-dp[i-2];
            int z = arr2[i]-dp[i-2];

            dp[i] = Math.max(x, Math.max(y,z));
        }
        return dp[arr1.length-1];
    }
}
