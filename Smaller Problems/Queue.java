import java.util.*;
import java.io.*;

public class Queue<T>
{
    LinkedList<T> list;

    Queue()
    {
        list = new LinkedList<T>();
    }

    public T pop()
    {
        return list.removeHead();
    }

    public void add(T data)
    {
        list.tailInsert(data);
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public void print()
    {
        list.print();
    }

    public static void main(String []args){
        Queue<String> q = new Queue<String>();
        
        q.add("NICK");
        q.add("Chili");
        q.print();
        q.pop();
        q.print();

    }
}