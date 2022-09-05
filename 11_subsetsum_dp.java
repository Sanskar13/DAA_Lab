// find a subset of a given set S = {s1,s2,..} whose sum is equal to the given target sum 'd' using backtracking

import java.util.*;

class Main
{
    static int n;
    static int target_sum;
    static int set[] = new int[10];
    static int solnvector[] = new int[10];
    static int cnt = 0;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int tot_sum = 0;
        n = sc.nextInt();
        for(int i=0;i<n;i++) {set[i] = sc.nextInt();tot_sum += set[i];}
        target_sum = sc.nextInt();

        if(target_sum > tot_sum){
            System.out.println("Solution set doesn't exist");
        }else   subset(0,0,tot_sum);
    }

    public static void subset(int sumsofar, int idx, int rem_sum)
    {
        solnvector[idx] = 1;
        if(sumsofar + set[idx] == target_sum)
        {
            System.out.println("Solution no " + (++cnt));
            for(int i=0;i<=idx;i++)
            {
                if(solnvector[i] == 1) System.out.print(set[i] + " ");
            }System.out.println();
        }
        else if(sumsofar+set[idx]+set[idx+1] <= target_sum)
        {
            subset(sumsofar+set[idx] , idx+1, rem_sum-set[idx]);
        }

        if((sumsofar + rem_sum - set[idx] >= target_sum) && (sumsofar+set[idx+1] <= target_sum))
        {
            solnvector[idx] = 0;
            subset(sumsofar,idx+1,rem_sum-set[idx]);
        }
    }
}