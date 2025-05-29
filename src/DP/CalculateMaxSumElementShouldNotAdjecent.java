package DP;

public class CalculateMaxSumElementShouldNotAdjecent {

    public static void main(String[] args) {
        int arr[] = {2,-3,5,-8,7};
        System.out.print(calculateMAxSum(arr));
    }
    private static int calculateMAxSum(int a[]) {
        if (a.length == 1) {
            return a[0];
        }
        int[] dp = new int[a.length];
        dp[0] = Math.max(0, a[0]);
        dp[1] = Math.max(dp[0], a[1]);

        for (int i = 2; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1], a[i] + dp[i - 2]);
        }
        return dp[a.length-1];
    }
}
