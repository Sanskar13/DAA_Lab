// Find minimum cost spanning tree of a connected undirected graph using kruskals algorithm
// using disjoint set union
import java.util.*;

class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int adj[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                adj[i][j] = sc.nextInt();
            }
        }

        int edges[] = new int[100];
        int src[] = new int[100];
        int dest[] = new int[100];
        int k=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(adj[i][j]!=0 && adj[i][j]!=999)
                {
                    edges[k] = adj[i][j];
                    src[k] = i;
                    dest[k] = j;
                    k++;
                }
            }
        }

        for(int i=0;i<k-1;i++)
        {
            for(int j=0;j<k-i-1;j++)
            {
                if(edges[j] > edges[j+1])
                {
                    swap(edges,j);
                    swap(src,j);
                    swap(dest,j);
                }
            }
        }

        int parent[] = new int[n];
        int mn_cost = 0;
        for(int i=0;i<n;i++)
            parent[i] = -1;

        for(int i=0;i<k;i++)
        {
            int a = find(parent,src[i]);
            int b = find(parent,dest[i]);
            if(a!=b)
            {
                mn_cost += edges[i];
                union(parent,a,b);
                System.out.println(src[i] + "->" + dest[i] + ":" + edges[i]);
            }
        }
        System.out.println("Min cost is : " + mn_cost);
    }

    public static void swap(int arr[], int idx)
    {
        int tmp = arr[idx];
        arr[idx] = arr[idx+1];
        arr[idx+1] = tmp;
    }

    public static int find(int parent[], int vertex)
    {
        if(parent[vertex] == -1)
            return vertex;
        return find(parent, parent[vertex]);
    }
    
    public static void union(int parent[], int a, int b)
    {
        parent[a] = b;
    }
}