import java.io.*;
import java.util.*;

public class MergeSort
{
    public static void mergeSort(int [] a)
    {
        merge(a,0,a.length - 1);
    }

    private static void merge(int [] a, int lo, int hi)
    {
        if(lo >= hi) return;

        int mid = lo + (hi - lo)/2;

        merge(a,lo,mid);
        merge(a,mid+1,hi);

        int [] aux = new int[hi - lo + 1];
        int i = lo; int j = mid + 1; int k = 0;

        while(i <= mid || j <= hi)
        {
            if(j > hi || ((i <= mid) && a[i] < a[j]))
            {
                aux[k++]  = a[i++];
            }else
            {
                aux[k++] = a[j++];
            }   
        }

        for(i = lo; i <= hi; i++)
        {
            a[i] = aux[i - lo];
        }

    }
    public static void main(String [] args)
    {
        int n = Integer.parseInt(args[0]);
        int [] array = new int[n];
        for(int i = 0; i < n; i++)
        {
            array[i] = ((int)(Math.random() * 100) + 1);
        }

        System.out.println("Unsorted: ");
        System.out.println(Arrays.toString(array));

        mergeSort(array);

        System.out.println("Sorted: ");
        System.out.println(Arrays.toString(array));
    }
}