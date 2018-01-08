import java.io.*;
import java.util.*;

/*
    A -> B -> C
         >D   <

    E

    A   B   C   D   E
A   0   1   0   0   0
B   1   0   1   1   0
C   0   1   0   1   0
D   0   1   1   0   0
E   0   0   0   0   0

*/



public class Mcolor
{
    public static boolean mcolor(boolean [][] matrix, int m)
    {
        int colors = 0;
        for(int i = 0; i < matrix.length; i++)
        {
            int c = 0;
            for(int j = 0; j < matrix.length; j++)
            {
                if(matrix[i][j]) c++;
            }
            if(c > colors)
                colors = c;
        }
        
        return colors == m ? true : false;
    }

    public static void main(String [] args)
    {
        boolean [][] matrix = 
        {
            {false,    true,   false,   false,  false},
            {true,     false,  true,    true,   false},
            {false,    true,   false,   true,   false},
            {false,    true,   true,    false,  false},
            {false,    false,  false,   false,  false}
        };

        System.out.println(mcolor(matrix,3));

    }
}