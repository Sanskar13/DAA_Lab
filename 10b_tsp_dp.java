import java.util.*;

class Main
{
    static Scanner sc = new Scanner(System.in);
    static int cost = 0;
    public static void main(String args[])
    {
        int n = sc.nextInt();
        int adj[][] = new int[n][n];
        int vis[] = new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                adj[i][j] = sc.nextInt();
            }
            vis[i] = 0;
        }

        mincost(adj,n,0,vis);
    }

     public static void mincost(int adj[][], int n, int city, int vis[])
    {
        vis[city] = 1;
        System.out.print((city+1) + "->");
        int city_no = least(adj,n,city,vis);
        if(city_no == 999)
        {
            city_no = 0;
            System.out.println(city_no+1);
            cost += adj[city][city_no];
            System.out.println(cost);
            return;
        }
        mincost(adj,n,city_no,vis);
    }

    public static int least(int adj[][], int n, int city, int vis[])
    {
        int m1 = 999,m2 = 0, min = 999;
        for(int i=0;i<n;i++)
        {
            if(adj[city][i]!=0 && vis[i]==0)
            {
                if(adj[city][i] < m1){
                    m1 = adj[city][i] + adj[i][0];
                    m2 = adj[city][i];
                    min = i;
                }
            }
        }
        if(min != 999)
            cost += m2;
        return min;
    }
}