import java.io.*;
import java.util.*;

public class Subsets
{
    public static void all(int [] a)
    {
        ArrayList<Integer> b =  new ArrayList<Integer>();
        all(a,0,b);
    }

    private static void all(int [] a, int index, ArrayList<Integer> set)
    {
        if(index >= a.length || set.size() > a.length || index > set.size())
        {
               System.out.println(Arrays.toString(set.subList(0, index).toArray()));
            return;
        }

        set.add(index,null);
        all(a,index+1,set);
        set.remove(index);
        set.add(index,a[index]);         
        all(a,index+1,set);
    }

    public static void main(String [] args)
    {
        int [] a = {1,2};
        all(a);
    }
}