import java.io.*;
import java.util.*;

public class Short
{
    public static final String ABC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int BASE = ABC.length();
    
    public static String encode(int n)
    {
        StringBuilder str = new StringBuilder();
        while(n > 0)
        {
            str.append(ABC.charAt(n % BASE));
            n/=BASE;
        }
        return str.toString();
    }
    public static int decode(String s)
    {
        int n = 0;
        for(int i = 0; i < s.length(); i++)
        {
            n = n*BASE + ABC.indexOf(str.charAt(i));
        }
        return n;
    }
}