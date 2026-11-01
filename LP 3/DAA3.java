import java.util.Scanner;

public class DAA3 {

    // dp[i][w] = pehle i items se, w capacity mein, maximum value
    public static int knapsackDP(int W, int[] wt, int[] val, int n) {

        int[][] dp = new int[n + 1][W + 1];

        // Table bottom-up banao
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {
                    dp[i][w] = 0;                           // base case: koi item nahi ya jagah nahi
                }
                else if (wt[i - 1] <= w) {                  // item fit ho sakta hai
                    int include = val[i - 1] + dp[i - 1][w - wt[i - 1]];   // item rakha
                    int exclude = dp[i - 1][w];                            // item nahi rakha
                    dp[i][w] = Math.max(include, exclude);  // jo bada ho wo lo
                }
                else {                                      // item fit nahi hota
                    dp[i][w] = dp[i - 1][w];                // sirf exclude
                }
            }
        }
        return dp[n][W];                                    // answer: last cell
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] val = new int[n];
        int[] wt  = new int[n];

        System.out.println("Enter values of items:");
        for (int i = 0; i < n; i++) val[i] = sc.nextInt();

        System.out.println("Enter weights of items:");
        for (int i = 0; i < n; i++) wt[i] = sc.nextInt();

        System.out.print("Enter knapsack capacity (W): ");
        int W = sc.nextInt();

        // Solve
        int maxProfit = knapsackDP(W, wt, val, n);
        System.out.println("Maximum value achieved = " + maxProfit);

        sc.close();
    }
}