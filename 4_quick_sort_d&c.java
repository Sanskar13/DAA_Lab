// sort the elements using quick sort method

import java.util.*;

class Main
{
    static int n;
    static int arr[] = new int[100];
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int ch = sc.nextInt();
        switch(ch)
        {
            case 1 :    int mx = 5000,mn=1000;
                      for(int i=0;i<n;i++)
                      {
                             arr[i] = (int)Math.floor(Math.random()*(mx-mn+1) + mn);
                      }
                      break;
            case 2 : for(int i=0;i<n;i++) arr[i] = i+1;
                      break;
        }
        long start = System.nanoTime();
        quick_sort(0,n-1);
        long stop = System.nanoTime();

        System.out.println(stop-start);
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quick_sort(int low, int high)
    {
        if(low < high)
        {
            int j = partition(low,high);
            quick_sort(low,j-1);
            quick_sort(j+1,high);
        }
    }

    public static void partition(int low, int high)
    {
        int pivot = arr[low],i=low,j=high;

        while(i<j)
        {
            while(arr[i]<=pivot && i<high) i++;
            while(arr[j]>=pivot && j>low) j--;

            if(i<j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[low] = arr[j]
        arr[j] = pivot;
        return j;
    }
}
