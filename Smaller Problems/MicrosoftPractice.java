import java.io.*;
import java.util.*;

public class MicrosoftPractice
{
    /*
        Check if a tree is a binary tree,
        For a binary tree to be binary, the left must be less than the root and the right must be greater.
        Every leaf must be a binary tree.  
    
    */

    private static void mergeyMerge(int [] a)
    {
        mergey(a,0,a.length - 1);
    }

    private static void mergey(int [] a, int lo, int hi)
    {
        if(lo >= hi) return;

        int mid = lo + (hi-lo)/2;

        mergey(a,lo,mid);
        mergey(a,mid+1,hi);

        int i = lo,j = mid + 1,k = 0;
        int [] aux = new int[hi - lo + 1];

        while(i <= mid || j <= hi)
        {
            if(j > hi || (i <= mid && a[i] < a[j]))
                aux[k++] = a[i++];
            else
                aux[k++] = a[j++];
        }

        for(i = lo; i < hi; i++)
        {
            a[i] = aux[i - lo];
        }

    }

    private static void inorder(Node<Integer> root,List<Integer> list)
	{

		if (root == null)
			return;

		inorder(root.left,list);
		list.add(root.data);
		inorder(root.right,list);
	}

    public static boolean checkBinary(Node<Integer> root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);

        ArrayList<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);

        for(int i = 0; i < list.size(); i++)
        {
            int x = list.remove(0);
            int y = sorted.remove(0);

            if(x != y) return false;
        }

        return true;
    }

    public static void main(String [] args)
    {
        
        
        for(int i = 0; i < a.length; i++)
        {
            a[i] = (int)(Math.random()*100 + 1);
        }
        System.out.println(Arrays.toString(a));
        mergeyMerge(a);
        System.out.println(Arrays.toString(a));
    }
}