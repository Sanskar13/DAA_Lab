// Implement 0/1 Knapsack using greedy algorithm -> fractional knapsack

import java.util.*;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int profit[] = new int[n];
        int wt[] = new int[n];
        int W = sc.nextInt(); 

        for(int i=0;i<n;i++) wt[i] = sc.nextInt();
        for(int i=0;i<n;i++) profit[i] = sc.nextInt();

        knapsack(n,profit,wt,W);
    }

    public static void knapsack(int n, int profit[], int wt[], int W)
    {
        double ratio[] = new double[n];
        for(int i=0;i<n;i++) ratio[i] = (double)profit[i]/wt[i];
        double tot_cost = 0,cw=0;
        System.out.println("Items considered are : ");
        for(int i=0;i<n;i++)
        {
            int item = lar(ratio,n);
            if(item == -1) break;
            System.out.print(item+1 + " ");
            if(cw + wt[item] <= W)
            {
                tot_cost += profit[item];
                cw += wt[item];
            }else{
                tot_cost += (double)(((double)(W-cw)/wt[item])*profit[item]);
                cw = W;
                break;
            }
        }
        System.out.println();
        System.out.println(tot_cost);
    }

    public static int lar(double ratio[], int n)
    {
        double mx = -1;
        int mx_idx=-1;
        for(int i=0;i<n;i++)
        {
            if(mx < ratio[i])
            {
                mx = ratio[i];
                mx_idx = i;
            }
        }
        if(mx != -1) ratio[mx_idx] = -1;
        return mx_idx;
    }
}