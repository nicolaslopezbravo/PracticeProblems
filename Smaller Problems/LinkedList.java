import javax.net.ssl.ExtendedSSLSession;

import java.io.*;
import java.util.*;

class Node<T>
{
    Node<T> next;
    T data;

    Node(T data)
    {
        this.data = data;
    }
}

public class LinkedList<T extends Comparable<T>>
{
    Node<T> head;
    Node<T> tail;

    public void insert(T data)
    {
        if(tail == null)
        {
            head = tail = new Node(data);
        }
        else
        {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    public T remove(T data)
    {
        Node<T> temp = head;
        while(temp.next != null)
        {
            if(temp.next.data == data)
            {
                temp = temp.next.next;
                return data;
            }
        }
        return null;
    }

    public void print()
    {
        for(Node<T> i = head; i != null; i = i.next)
        {
            System.out.print(i.data + ((i.next != null) ? " " : "\n")); 
        }
    }

    public void merge()
    {
        head = mergey(head);
    }

    public Node<T> mergey(Node<T> start)
    {
        if(start == null  || start.next == null) return start;

        Node<T> mid = start;
        Node<T> fast =  start.next;
        
        while(fast.next != null)
        {
            mid = mid.next;
            fast = fast.next;
        }

        Node<T> head1 = start;
        Node<T> head2 = mid.next;
        mid.next = null;
        
        head1 = mergey(head1);
        head2 = mergey(head2);
        LinkedList<T> aux = new LinkedList<>();

        while(head1 != null || head2 != null)
        {
            if(head2 == null || (head1 != null && head1.data.compareTo(head2.data) < 0))
            {
                aux.insert(head1.data);
                head1 = head1.next;
            }                
            else
            {
                aux.insert(head2.data);
                head2 = head2.next;
            }               
        }
        return aux.head;
    }

    public static void main(String [] args)
    {
        int N = Integer.parseInt(args[0]);

        LinkedList<Integer> listy = new LinkedList<>();

        for(int i = 0; i < N; i++)
        {
            listy.insert((int)(Math.random()*100) + 1);
        }

        listy.print();
        listy.merge();
        listy.print();
    }
}