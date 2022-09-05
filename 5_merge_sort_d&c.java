import java.util.*;

class Main
{
    static int arr[];

    
    public static void merge(int low, int mid, int high)
    {
        int i = low, j = mid+1,k=0;
        int n = high-low+1;
        int aux[] = new int[n];
        while((i<=mid) && (j<=high))
        {
            if(arr[i] <= arr[j])
            {
                aux[k] = arr[i];
                i++;
            }else{
                aux[k] = arr[j];
                j++;
            }
            k++;
            // System.out.print(aux[k-1] + " ");
        }
        // System.out.println();
        while(i<=mid){
            aux[k] = arr[i];
            k++;i++;
        }
        while(j<=high)
        {
            aux[k] = arr[j];
            k++;j++;
        }

        for(k=0;k<n;k++)
        {
            arr[k+low] = aux[k];
        }
    }

    public static void merge_sort(int low, int high)
    {
        if(low < high)
        {
            int mid = (low+high)/2;
            merge_sort(low,mid);
            merge_sort(mid+1,high);
            merge(low,mid,high);
        }
    }

    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int ch = sc.nextInt();
        arr = new int[n];
        switch(ch)
        {
            case 1 : for(int i=0;i<n;i++) arr[i] = i+1;
                        break;
            case 2 : int mx = 100,mn=1;
            for(int i=0;i<n;i++){
                        arr[i] = (int)Math.floor(Math.random()*(mx-mn+1) + mn);
                    }break;
            case 3 : for(int i=0;i<n;i++) arr[i] = n-i+1;
                        break;
        }

        // for(int i=0;i<n;i++) System.out.print(arr[i] + " ");
        // System.out.println();
        long start = System.nanoTime();
        merge_sort(0,n-1);
        long stop = System.nanoTime();

        System.out.println(stop-start);
        // for(int i=0;i<n;i++) System.out.print(arr[i] + " ");
        // System.out.println();
    }
    
    
}