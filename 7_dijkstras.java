// From a given vertex in a weighted connected graph, find the shortest path to all other vertices

import java.util.*;

class Main
{
    // static final int V = 4;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] adj = new int[n][n];
        int[] vis = new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                adj[i][j] = sc.nextInt();
            }
        }
        int src = sc.nextInt();
        dijkstras(adj,n,src,vis);
    }

    public static void dijkstras(int adj[][], int n, int src, int vis[])
    {
        int dist[] = new int[n];
        for(int i=0;i<n;i++)
        {
            dist[i] = adj[src-1][i];
            vis[i] = 0;
        }
        vis[src-1] = 1;
        for(int i=0;i<n-1;i++)
        {
            int u = min_dist(dist,vis,n);
            vis[u] = 1;
            for(int v=0;v<n;v++)
            {
                if(vis[v]==0 && dist[v] > dist[u]+adj[u][v] && dist[v]]!=Integer.MAX_VALUE && adj[u][v]!=0)
                {
                    dist[v] = dist[u]+adj[u][v]
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            System.out.print(dist[i] + " ");
        }
    }

    public static int min_dist(int dist[], int vis[], int n)
    {
        int mn = Integer.MAX_VALUE,mn_idx = -1;
        for(int i=0;i<n;i++)
        {
            if(vis[i] == 0)
            {
                if(dist[i] < mn)
                {
                    mn = dist[i];
                    mn_idx = i;
                }
            }
        }
        return mn_idx;
    }
}

/*
 * Time Complexity -> O(V^2).
 */