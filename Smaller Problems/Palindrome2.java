import java.io.*;
import java.util.*;

public class Palindrome2
{
    public static void palindrome(String s)
    {   // the max length for any word of length > 1 is 1
        int max = 1;
        int start = 0;
        int len = s.length();
        int low, high;

        for(int i = 1; i < len; i++)
        {
            low = i - 1; // for even sized palindromes
            high = i;

            while(low >= 0 &&  high < len && s.charAt(low) == s.charAt(high))
            {
                if(high - low + 1 > max)
                {
                    start = low;
                    max = high - low + 1;
                }
                high++;
                low--;
            }

            low = i - 1; // for odd sized palindromes
            high = i + 1;

            while(low >= 0 && high < len && s.charAt(low) == s.charAt(high))
            {
                if(high - low + 1> max)
                {
                    start = low;
                    max = high - low + 1; // the range
                }
                high++;
                low--;
            }
        }

        System.out.println(s.substring(start,start + max));
    }
    public static void main(String [] args)
    {
        palindrome(args[0]);
    }
}