import java.io.*;
import java.util.*;

public class AddLongNumbers
{
    public static void addLong(Node<Integer> a, Node<Integer> b)
    {
        LinkedList<Integer> c = new LinkedList<>();
        int carryOver = 0;
        while(a != null || b != null)
        {
            int temp = a.data + b.data + carryOver;
            carryOver = (int)Math.floor((double)temp/10);
            if(temp < 10)
            {
                c.insert(temp);
            }else
            {                
                c.insert((temp == 10) ? 0 : temp % 10);
            }
            a = a.next;
            b = b.next;
        }
        if(carryOver != 0)
        {
            c.insert(carryOver);
        }
        c.print();
    }
    public static void main(String [] args)
    {
        LinkedList<Integer> num1 = new LinkedList<>();
        LinkedList<Integer> num2 = new LinkedList<>();

        for(int i = 0; i < 1000; i++)
        {
            num1.insert((int)(Math.random()*9 + 1));
            num2.insert((int)(Math.random()*9 + 1));
        }
        num1.print();
        num2.print();
        addLong(num1.head,num2.head);
    }
}