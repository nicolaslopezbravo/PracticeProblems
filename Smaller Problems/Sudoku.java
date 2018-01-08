import java.io.*;
import java.util.*;
import java.awt.*;

public class Sudoku
{
    public static Point findUnassigned(int [][] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length; j++)
            {   
                if(arr[i][j] == 0)
                    return new Point(i,j);
            }
        }
        return null;
    }

    private static void printBoard(int arr[][])
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr.length; j++)
            {
                System.out.print(arr[i][j] + (((j + 1) % 3 == 0) ? " | " : " "));
            }
            System.out.println();
        }
    }

    private static void solve(int [][] arr)
    {   // find the next unassigned point
        Point p = findUnassigned(arr);
        if(p == null)
        {
            printBoard(arr);
            return;
        } 

        int row = (int)p.x;
        int col = (int)p.y;
        
        for(int i = 1; i <= 9; i++)
        {
            // if it's safe to add the number in that specific row and col else just move on to next possible choice
            if(isSafe(arr, row, col, i))
            {   // make a move
                arr[row][col] = i;
                // make recursive call
                solve(arr);
                // reset the state
                arr[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int [][] arr, int row, int col, int num)
    {
        int startRow = row - row % 3; // 4 - 1 = 3
        int startCol = col - col % 3;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[row][i] == num || arr[i][col] == num)
                return false;
        }

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(arr[i + startRow][j + startCol] == num)
                    return false;
            }
        }
        return true;
    }

    public static void main(String [] args)
    {
        int[][] arr = 
        {
            {3,0,6, 5,0,8, 4,0,0},
            {5,2,0, 0,0,0, 0,0,0},
            {0,8,7, 0,0,0, 0,3,1},
            /////////////////////
            {0,0,3, 0,1,0, 0,8,0},
            {9,0,0, 8,6,3, 0,0,5},
            {0,5,0, 0,9,0, 6,0,0},
            /////////////////////
            {1,3,0, 0,0,0, 2,5,0},
            {0,0,0, 0,0,0, 0,7,4},
            {0,0,5, 2,0,6, 3,0,0}
        };

        solve(arr);
    }
}