import java.io.*;
import java.util.*;

public class Amazon
{
    private static boolean hasLoop(LinkedList<Node> list)
    {
        if(list.isEmpty()) return false;

        Node head = list.getFirst();
        HashSet<Node> visited = new HashSet<Node>();
        while(head != null)
        {
            if(visited.contains(head)) {
                System.out.println("vi" + head.val); return true;}
            visited.add(head);
            head = head.next;
        }        
        return false;
    }

    private static Node kthFromTheEnd(LinkedList<Node> list, int k)
    {
        if(list.size() == 1) return list.getFirst();
        if(list.size() < 1) return null;

        Node head = list.getLast();
        Node p1 = head;
        Node p2 = head;
        
        int c = 0;                      //    p2  p1
        while(p1.next != null)          // 2 3 7 6 4, we want 3rd from last so 7.
        {
            if(c >= k-1)                // 3 >= 2 ? yes. 5-2 = x. there needs to be a k difference between pointers
            {
                p2 = p2.next;           // when there is a k-1 difference, we start moving them until the end.
            }
            p1 = p1.next;
            c++;
        }
        return p2;
    }


    private static int fibby(int n)
    {
        int [] array = new int[2];
        array[0]= 1;
        array[1] = 1;
        int i = 0;
        for(i = 2; i <= n; i++)
        {
            array[i%2] = array[(i-1)%2] + array[(i-2)%2];
        }
        return array[i%2];
    }

    private static boolean pythagoreanTriplets(int [] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            a[i] *= a[i]; 
        }
        Arrays.sort(a);
        int k = a.length - 1;
        for(int i = a.length - 1; i >= 2; i--)
        {
            int l = 0;
            int r = i - 1;

            while(l < r)
            {
                if(a[i] == a[l] + a[r]) return true;
                if(a[i] < a[l] + a[r]) r--;
                if(a[i] > a[l] + a[r]) l++;
            }
        }
        return false;
    }

    private static void reverseMyList(LinkedList<Node> normal)
    {
        Node head = normal.getLast();
        LinkedLisit<Node> rev = new LinkedList<Node>();
        
        
        while(head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.print(",");
    }


    private static void kReverse(int k, LinkedList<Node> list)
    {
        Node head = list.getLast();
        LinkedList<Node> revy = new LinkedList<Node>();
        int c = 0;

        while(head != null)
        {
            revy.push(head);
            head = head.next;
            ++c;
            if(c % k == 0)
            {
                reverseMyList(revy);
                System.out.println();
                revy.clear();
            }
            
        }

        if(list.size() == 0) System.out.println("Empty List");
    }
    public static void main(String [] args)
    {
        LinkedList<Node> rev = new LinkedList<Node>();
       
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        rev.push(n1);
        rev.push(n2);
        rev.push(n3);
        rev.push(n4);
        rev.push(n5);
        rev.push(n6);
        
        kReverse(2,rev);
    }
}