// Implement 0/1 Knapsack using Dynamic Programming

import java.util.*;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int profit[] = new int[n+1];
        int wt[] = new int[n+1];
        int W = sc.nextInt(); // represents capacity
        for(int i=1;i<=n;i++) profit[i] = sc.nextInt();
        for(int i=1;i<=n;i++) wt[i] = sc.nextInt();

        int[][] dp = new int[n+1][W+1];
        for(int i=0;i<=n;i++) // no objects
            dp[i][0] = 0;
        for(int i=0;i<=W;i++) 
            dp[0][j] = 0; // no weights

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=W;j++)
            {
                if(j >= wt[i])
                {
                    dp[i][j] = max(dp[i-1][j] , profit[i]+dp[i-1][j-wt[i]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println("Max profit earned while filling the knapsack is : " + dp[n][W]);

        // Items considered
        int i = n, j = W;
        while(i>0 && j>0)
        {
            if(v[i][j] != v[i-1][j])
            {
                System.out.print(i + " ");
                j -= wt[i];
            }i-=1;
        }
    }
}