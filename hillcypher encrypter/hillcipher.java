import java.io.*;
import java.util.*;
/*
    Nicolas Lopez
    CIS 3360
    6/13/2017

    Hill Cypher
*/
public class hillcipher
{
    public static char[] encrypt(int[][] k, int [] t, int col)
    {
        int rLength = col * k.length;
        int [] result = new int[rLength];
        int x = 0;
        int z = 0;
        /* Perform matrix multiplication and modding by alphabet */
        for(int b = 0; b < col; b++)
        {
            for(int i = 0; i < k.length; i++)
            {   
                for(int j = 0; j < k.length; j++)
                {  
                    if(z < rLength)
                    {         
                        result[z] += (k[i][j] * t[j + x]); 
                    }  
                }
                if(z < rLength)
                {     
                    result[z++] %= 26;
                } 
            }
            x += k.length;
        }

        char [] cypher = new char [result.length];
        
        for(int i = 0; i < result.length; i++)
        {
            cypher[i] = (char)(result[i] + 'a');
        }
        return cypher;
    }

    public static void main(String [] args)
    {
        /* Open the files */
       File key = new File((String)args[0]);
       File text = new File((String)args[1]);

        try
        {   /* Read in text file */
            Scanner sc = new Scanner(key);
            int n = sc.nextInt();
            int[][] k = new int[n][n];
            int i = 0; 
            int j = 0;

            while(sc.hasNextInt())
            {
                k[i][j] = sc.nextInt();
                j++;
                if(j == n)
                { 
                    j = 0; i++; 
                }
            }

            /* Output Key to screen */
            System.out.println();
            System.out.println("Key matrix: ");
            System.out.println();
            for(i = 0; i < n; i++)
            {
                for(j = 0; j < n; j++)
                {
                    System.out.print(k[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            /* Read, calculate letter value & print text file*/
            Scanner sf = new Scanner(text);
            int[] t = new int[10000];
            Arrays.fill(t,-1);
            String s;
            i = 0; 
            
            System.out.println("Plaintext: ");
            System.out.println();
            while(sf.hasNext())
            {
                s = sf.next();
                char [] x = s.toCharArray(); 
                j = 0;

                while(j < x.length)
                {
                    if((x[j] - 'a' >= 0) && (x[j]-'a' <= 25))
                    {
                        t[i++] = x[j] - 'a';
                    }else if((x[j] - 'A' >= 0) && (x[j]-'A' <= 25))
                    {
                        t[i++] = x[j] - 'A';
                    }
                    j++;
                }
            }

            n = 0;
            int col = (int)Math.ceil(i/(double)k.length);
            while(n < col * k.length)
            {
                for(j = 0; j < 80 && n < col * k.length; j++)
                {
                    if(t[n] < 0)
                    {
                        t[n] = 'x' - 'a';
                    }
                    System.out.print((char)(t[n++] + 'a'));
                }
                System.out.println();
            }
            System.out.println();

            // we input the key, the text in number form, 
            // and the length of each column.                      
            char [] cypher = encrypt(k,t,col); 

            /* Output cypher text to screen */ 
            System.out.println("Cyphertext: ");
            System.out.println();
            n = 0;
            while(n < cypher.length)
            {
                for(j = 0; j < 80 && n < cypher.length; j++)
                {
                    System.out.print(cypher[n++]);
                }
                System.out.println();
            }
        }catch(IOException e){
            //error, unreachable.
            System.out.println("File not found! :(");
        }       
    }
}