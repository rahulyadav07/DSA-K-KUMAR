/**
 * @url [https://takeuforward.org/plus/dsa/problems/frog-jump]
 * A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.
 * To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference.
 * The frog can jump from any step either one or two steps, provided it exists.
 * Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
 *
 *
 *Input: heights = [2, 1, 3, 5, 4]
 *
 * Output: 2
 *
 * Explanation: One possible route can be,
 *
 * 0th step -> 2nd Step = abs(2 - 3) = 1
 *
 * 2nd step -> 4th step = abs(3 - 4) = 1
 *
 * Total = 1 + 1 = 2.
 *
 */


public class FrogJump {
    public static void main(String[] args) {
        int height[] = {2, 1, 3, 5, 4};
        int[] dp = new int[height.length];

        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);

        for (int i = 2; i < height.length; i++) {
            int oneJump = dp[i - 1] + Math.abs(height[i] - height[i - 1]);
            int twoJump = dp[i - 2] + Math.abs(height[i] - height[i - 2]);
            dp[i] = Math.min(oneJump, twoJump);
        }

        System.out.println("Minimum energy required: " + dp[height.length - 1]);
    }
}

