import java.io.*;
import java.util.*;

public class Longest
{
    /**
     *  Table - word is DEDA
     *  [T   F   T]   F   
     *  0   T   F   F
     *  0   0   T   F
     *  0   0   0   T
     */
    public static void longestPalindromicSubString(String s)
    {
        int len = s.length();
        boolean [][] table = new boolean[len][len];
        int maxLength = 1;
        // fill the diagonals true, all single letters are palindromes
        for(int i = 0; i < len; i++)
        {
            table[i][i] = true;
        }

        int start = 0;
        // check for palindromes of length 2 (filling out diagonally too)
        for(int i = 0; i < len - 1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        //check one before and one after the already filled table
        for(int k = 3; k <= len; k++)
        {
            for(int i = 0; i < len - k + 1; i++)
            {
                int j = i + k - 1;

                //get the one further and one before
                if(table[i+1][j-1] && s.charAt(i) == s.charAt(j))
                {
                    table[i][j] = true;
                    if(k > maxLength)
                    {
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }

        int end = maxLength + start;
        /*
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        */
        System.out.println(s.substring(start,end));

    }
    public static void main(String [] args)
    {
        longestPalindromicSubString("DEDA");
    }
}