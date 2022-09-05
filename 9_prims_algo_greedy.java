// find min cost spanning tree from given connected undirected graph using prims algo.

import java.util.*;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int adj[][] = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                adj[i][j] = sc.nextInt();

        int vis[] = new int[n];
        int unvis[] = new int[n];

        for(int i=0;i<n;i++)
        {
            vis[i] = 0;
            unvis[i] = 1;
        }

        int cost=0,src=0,idx=0,min=999;
        vis[src] = 1;
        unvis[src] = 0;
        for(int i=0;i<n;i++)
        {
            min = 999;
            for(int j=0;j<n;j++)
            {
                if(vis[j]==1)
                {
                    for(int k=0;k<n;k++)
                    {
                        if(unvis[k]==1 && adj[j][k]!=999)
                        {
                            if(adj[j][k] < min)
                            {
                                min = adj[j][k];
                                src = j;
                                idx = k;
                            }
                        }
                    }
                }
            }
            vis[idx]=1;
            unvis[idx]=0;
            if(min != 999)
             {
                cost += min;
                System.out.println((src+1) + "->" + (idx+1) + " " + min);
            }
        }
        System.out.println("Min cost of spanning tree is : " + cost); 
    }
}