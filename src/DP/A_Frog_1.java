package DP;

import java.util.Scanner;

public class A_Frog_1 {

    /**
     * Problem Statement
     *
     * There are N stones, numbered 1,2,3....N for each(i (1<i<N)) the height of stone i is h.
     *
     * there is a frog is currently on stone i. jump to stone i+1 or stone i+2 here. a cost of |hi-hj| is incurred , where
     * j is the stone to land on.
     *
     *
     * Find the minimum possible total cost incurred before the frog reaches Stone N
     */
    public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            long[] b = new long[n+1];

            for (int i = 1; i <= n; i++) {
                b[i] = scanner.nextLong();
            }

            long[] dp = new long[n+1];

            dp[1] = 0;


            dp[2] = Math.abs(b[1] - b[2]);

            for (int i = 3; i <= n; i++) {
                dp[i] = Math.min(dp[i-1] + Math.abs(b[i] - b[i-1]), dp[i-2] + Math.abs(b[i] - b[i-2]));
            }

            System.out.println(dp[n]);

    }
}
