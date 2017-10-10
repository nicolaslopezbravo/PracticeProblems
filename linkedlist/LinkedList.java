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

public class LinkedList<T>
{
    Node<T> head;
    Node<T> tail;

    public boolean isEmpty()
    {
        return (head == null);
    }
    public T getHead()
    {
        return (head == null) ? null : head.data;
    }

    public T removeHead()
    {
        if(head == null) return null;
        T val = head.data;
        head = head.next;
        return val;
    }

    public T removeTail()
    {
        if(tail == null) return null;
        Node<T> temp = head;
        while(temp.next != tail)
        {
            temp = temp.next;
        }
        T data = tail.data;
        tail = temp;
        return data;
    }
    public void insertAtHead(T data)
    {
        Node<T> temp = new Node<T>(data);
        if(tail == null) tail = temp;
        temp.next = head;
        head = temp;
    }

    public void insertAtTail(T data)
    {
        Node<T> temp = new Node<T>(data);
        if(head == null) head = tail = temp;
        else{
            tail.next = temp;
            tail = tail.next;
        }
    }

    public void print()
    {
        Node<T> temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String [] args)
    {
        LinkedList<Integer> listy = new LinkedList<Integer>();

        for(int i = 0; i < 20; i++)
        {
            listy.insertAtHead((int)(Math.random() * 100 + 1));
        }
        listy.print();  
        listy.removeHead();
        listy.print();
        listy.insertAtTail(0);
        listy.print(); 
        listy.insertAtHead(0);
        listy.print();
    }
}