import java.io.*;
import java.util.*;

public class Stack<T>
{
    LinkedList<T> list;

    Stack()
    {
        list = new LinkedList<T>();
    }
    public void push(T data)
    {
        list.headInsert(data);
    }
    public T pop()
    {
        return list.removeHead();
    }
    public T peek()
    {
        return list.getHead();
    }
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public static void main(String [] args){
        Stack<String> s = new Stack<String>();

        s.push("Nick");
        s.push("Alex");

        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

}