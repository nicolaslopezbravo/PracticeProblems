import java.io.*;
import java.util.*;

public class Geeky
{
    public static void lastN(String s, int n)
    {
        String [] arr = s.split("\n");
        if(arr.length - n < 0) n = arr.length;
        for(int i = arr.length - n; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }

    public static void rLE(String s)
    {
        char [] arr= s.toCharArray();
        HashMap<Character,Integer> h = new HashMap<>();

        for(char c : arr)
        {
            Integer n = h.get(c);
            if(n == null)
                h.put(c,1);
            else
                h.put(c,n+1);
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < arr.length; i++)
        {
            int n = h.get(arr[i]);
            str.append(arr[i]);
            str.append(n);
            i += n - 1;
        }
        System.out.println(str.toString());
    }
    public static void main(String [] args)
    {
        lastN("HELLO\nHowareyou\nnicolas\n",4);
        rLE("wwwwaaadexxxxxx");
    }
}