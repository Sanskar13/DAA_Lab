// All hamiltonian cycle in a undirected connected graph of n vertices using backtracking principle

import java.util.*;

class Main
{
    static int n;
    static int adj[][] = new int[10][10];
    static int x[] = new int[10];
    static int flag = 0;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                adj[i][j] = sc.nextInt();
            }
        }
        x[1] = 1;
        hamiltonian(2);
        if(flag == 0)
        {
            System.out.println("No Hamiltonian cycle exist");
        }
    }

    static void hamiltonian(int n)
    {
        do{
            next_vertex(k);
            if(x[n] == 0) return;
            if(k == n){
                flag = 1;
                for(int i=0;i<n;i++)
                {
                    System.out.print(x[i] + " ");
                    System.out.print("1");
                }
            }else hamiltonian(k+1);
        }while(true);
    }

    static void next_vertex(int n)
    {
        do{
            x[k] = (x[k]+1)%(n+1);
            if(x[k] == 0) return;
            if(adj[x[k-1]][x[k]] != 0)
            {
                int j;
                for(j=0;j<k;j++)
                {
                    if(x[j] == x[k]){
                        return;
                    }
                }
                if(j == k){
                    if((k<n) || ((k==n) && adj[x[n]][x[1]]==1))
                    {
                        return;
                    }
                }
            }
        }while(true);
    }
}