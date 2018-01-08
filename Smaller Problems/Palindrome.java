import java.io.*;
import java.util.*;

public class Palindrome
{
    public static int longestPalindrome(String s)
    {   /*
        
            D   E   D   A
        D   1   0   
        E       1   0
        D           1   0
        A               1
        
        */
        int max = 1;
        boolean [][] matrix = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;

        for(int i = 0; i < matrix.length; i++)
        {   //all single letters are palindromes (fill diagonally)
            matrix[i][i] = true;
        }
        //check for two spaces fill diagonally
        for(int i = 0; i < matrix.length - 1; i++)
        {
            if(matrix[i][i+1] == matrix[i][i])
            {
                matrix[i][i + 1] = true;
                max = 2;
            }
        }

        for(int i = 3; i <= matrix.length; i++) 
        {
            for(int j = 0; j < matrix.length - j + 1; j++)  
            {
                int k = i + j - 1; 
                
                //get the one further and one before
                if(matrix[j+1][k-1] && s.charAt(j) == s.charAt(k))
                {
                    matrix[j][k] = true;
                    if(i > max)
                    {
                        max = i;
                        start = j;
                    }
                }
            }
        }
        end = max + start;
        System.out.println(s.substring(start,end));

        return max;
    }
    public static boolean palinfun(String s)
    {
        int n = (int)Math.ceil(s.length()/2);
        
        for(int i = 0; i <= n; i++)
        {   
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args)
    {
        //System.out.println(palinfun(args[0]));
        System.out.println(longestPalindrome("geeegk"));
    }
}