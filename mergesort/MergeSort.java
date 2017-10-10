import java.io.*;
import java.util.*;

public class MergeSort
{
    public static void mergeSort(int [] a)
    {
        mergeSort(a,0,a.length - 1);
    }

    private static void mergeSort(int [] a, int low, int high)
    {
        if(low >= high) return;

        int mid = low + (high - low)/2;

        mergeSort(a,low,mid);
        mergeSort(a,mid+1,high);

        int i = low, j = mid + 1, k = 0;
        int [] aux = new int[high - low + 1];

        while(i <= mid || j <= high)
        {
            if(j > high || (i <= mid && a[i] < a[j]))
            {
                aux[k++] = a[i++];
            }else{
                aux[k++] = a[j++];
            }
        }

        for(i = low; i <= high; i++)
        {
            a[i] = aux[i - low];
        }
    }

    public static void main(String [] args)
    {
        int n = Integer.parseInt(args[0]);
        int [] array = new int[n];
        System.out.println("Merge sort of random array of size " + n);
        System.out.println("Unsorted: ");
        for(int i = 0; i < n; i++)
        {
            array[i] = ((int)(Math.random() * 100) + 1);
        }
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println("Sorted: ");
        System.out.println(Arrays.toString(array));
    }
}