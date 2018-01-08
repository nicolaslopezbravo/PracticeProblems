import java.io.*;
import java.util.*;

public class Invert
{
    public static String invertString(String s)
    {
        String [] strs = s.split(" ");
        StringBuilder result = new StringBuilder();
        int n = 0;
        while(n < strs.length)
        {
            result.append(new StringBuilder(strs[n]).reverse().toString() + ((n == strs.length) ? "" :" "));
            n++;
        }

        return result.toString();
    }
    public static void main(String [] args)
    {
        System.out.println(invertString("Hey Alex I can talk backwards"));
    }
}