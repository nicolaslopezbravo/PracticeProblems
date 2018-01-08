import java.io.*;
import java.util.*;

public class Pall
{
    private static void palindrome(String s)
    {
        char [] a = s.toCharArray();
        int start = 0, finish = 0;
        
        for(int i = 0; i < a.length; i++)
        {
            // even number expansion
            int lower = i, higher = i + 1;
            
            while(lower >= 0 && higher < a.length)
            {
                if(a[lower] - a[higher]  == 0)
                {
                    if(finish - start < higher - lower)
                    {
                        start = lower;
                        finish = higher;
                    }                 
                }
                lower--;
                higher++;
            }

            lower = i; higher = i + 2;

            while(lower >= 0 & higher < a.length)
            {
                if(a[lower] - a[higher]  ==0)
                {
                    if(finish - start < higher - lower)
                    {
                        start = lower;
                        finish = higher;
                    }
                }
                lower--;
                higher--;
            }        
        }
        System.out.println(s.substring(start,finish + 1)); 
        
    }
    public static void main(String [] args)
    {
        palindrome("asa");
    }
}