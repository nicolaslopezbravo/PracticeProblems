/*
    Nicolas Lopez
    CS2 -  Assignement 4
    SkipList
 */
import java.io.*;
import java.util.*;
class Node<T>
{   
    int height;
    T value;
    ArrayList<Node<T>> next;

    Node(int height)    //creates head node
    {
        this.height = height;
        this.next = new ArrayList<>(height);  //create new arraylist
        for(int i = 0; i < height; i++) //initialize all node.next values to null
        {
            this.next.add(null);
        }
    }

    Node(T data, int height)            //creates a new node with value data and height height
    {   
        this.height = height;
        this.value = data;
        this.next = new ArrayList<>(height);  
        
        for(int i = 0; i < height; i++) //initialize all node.next values to null
        {
            this.next.add(null);
        }
    }

    public T value()    //returns value of the node
    {
        return this.value;
    }

    public int height() //returns height of the node
    {
        return this.height;
    }

    public Node<T> next(int level)                                      //returns a reference to the next node at that level 
    {                               
        if(level < 0 || (level > (this.height - 1))) return null;       //out of bounds returns null
        return this.next.get(level);
    }

    //suggested methods
    public void setNext(int level, Node<T> node)    
    {
        this.next.set(level,node);         
    }

    public void grow()                                                //grow the head by one
    {
        this.height += 1;                                             //increase the height by one
        this.next.add(height-1,null);                                 //set the top level of the node to null
    }

    public void maybeGrow()
    {   
        Random randy = new Random();
        if(randy.nextInt() % 2 == 1) grow();
    }

    public void trim(int height)
    {   
        for(int i = this.height - 1; i >= height; i--) 
        {
            this.next.remove(i);
        }
        if(height < this.height) this.height = height;
    }
}

public class SkipList<T extends Comparable<T>>
{   
    Node<T> head;
    int size;
    int height;

    SkipList()
    {
        head = new Node<>(1);           //creates the head node.
        height = 1;
        size = 0;
    }

    SkipList(int height)
    {
        size = 0;
        if(height < 1)                  //if height is less than one set it to the default of one.
        {
            head = new Node<>(1);       //creates the head node.
            height = 1;   
        }else
        {
            head = new Node<>(height);  
            this.height = height;
        }
    }
    
    public int size()
    {
        return this.size;               //return number of nodes in the skip list   
    }

    public int height()
    {
        return this.height;
    }

    public Node<T> head()
    {
        return this.head;
    }

    public void insert(T data)  
    {          
        int h = generateRandomHeight(this.height);                  //generate a random height                                                                  
        insert(data,h);                                             //call insert method
    }

    public void insert(T data, int height)
    { 
        Node<T> node = new Node<>(data,height);                     //with the specified value. 
        HashMap<Integer,Node<T>> pointers = new HashMap<>();        //create a hashmap of pointers where it goes down.
                                                                    //look for the position it needs to be in.
        Node<T> temp = this.head;
        for(int i = this.height - 1; i >= 0; i--)                   //start at top node
        {                                                             
            while(temp != null && temp.next(i) != null && data.compareTo(temp.next(i).value()) > 0)             
            {      
                temp = temp.next(i);                                //traverse to next node if it's less 
            }            
            pointers.put(i,temp);                                   //keep count when it goes down a level.                                              
        }
                                                                    
        for(int i = height - 1; i >= 0; i--)        
        {   
            Node<T> pointy = pointers.get(i).next(i);
            node.setNext(i,pointy);                                 //set all pointers to point to the new node.
            pointers.get(i).setNext(i,node);                        //set the node to point to what the pointers were previousely pointing to.         
        }
        this.size++;       
        int maxHeight = getMaxHeight(this.size);
        if(maxHeight > this.height)
        {                  
            this.height = maxHeight;                                //grow the node by one.
            growSkipList();  
        }  
    }

    public void delete(T data) 
    {
        if(contains(data))
        {   
            HashMap<Integer,Node<T>> pointers = new HashMap<>(); 
            Node<T> temp = head;
            
            for(int i = this.height - 1; i >= 0; i--)               //start at top node
            {                                                               
                while(temp != null && temp.next(i) != null && data.compareTo(temp.next(i).value()) > 0)             
                {   
                    temp = temp.next(i);                            //traverse to next node if it's less 
                }
                pointers.put(i,temp);                              //keep count when it goes down a level with a hashMap                                              
            }
            temp = temp.next(0);                                   //start at the head of the deleting node.
            for(int i = temp.height() - 1; i >= 0 ; i--)
            {
                if(pointers.get(i)!= null && pointers.get(i).next(i) != null)
                {    
                    pointers.get(i).setNext(i,pointers.get(i).next(i).next(i));  
                }
            }

            this.size--;    //trim skiplist if needed
            int maxHeight = getMaxHeight(size);

            if(this.height > maxHeight && maxHeight >= 1)
            {
                    this.height = maxHeight;    //change height
                    trimSkipList();
            } 
		
        }
    }

    public boolean contains(T data)
    {
        Node<T> temp = head; 

        for(int i = this.height - 1; i >= 0; i--) //start at top node
        { 
          while(temp != null && temp.next(i) != null && data.compareTo(temp.next(i).value()) > 0)
          {
              temp = temp.next(i);  //traverse just like the insert/delete algorithm
          }
          if(temp.next(i) != null && data.compareTo(temp.next(i).value()) == 0) return true;
        } 
        return false;        
    }

    public Node<T> get(T data)
    {
        Node<T> temp = head;        
        for(int i = this.height - 1; i >= 0; i--)                   //start at top node
        { 
          while(temp != null && temp.next(i) != null && data.compareTo(temp.next(i).value()) > 0)
          {
              temp = temp.next(i);  //traverse at the same level
          }
          if(temp.next(i) != null && data.compareTo(temp.next(i).value()) == 0) return temp.next(0);//make sure we return the first instance
        } 
        return null; 
    }

    private static int getMaxHeight(int n)
    {
        return (int)Math.ceil((Math.log(n))/(Math.log(2)));
    }

    private static int generateRandomHeight(int maxHeight)
    {
        int height = 1;

        while(height < maxHeight && (int)(Math.random()*2 + 1) % 2 == 1)
        {
            height++;
        }
        return height;
    }

    private void growSkipList()
    {
        head.grow();
        Node<T> temp = head.next(this.height - 2);
        Node<T> heady = head;
        while(temp != null)
        {
            temp.maybeGrow();   //maybe grow each node
            if(temp.height() == this.height)
            {
                heady.setNext(this.height - 1, temp);  //connect nodes 
                heady = heady.next(this.height - 1);
            }   //traverse to the next one at that height
            temp = temp.next(this.height - 2);
        }
    }

    private void trimSkipList()
    {
        Node<T> temp = head;
        while(temp != null)
        {   //trim each node at the top height.
            temp.trim(this.height());
            temp = temp.next(this.height()-1);
        }
    }

    public static double difficultyRating()
    {
        return 5.0;
    }

    public static double hoursSpent()
    {
        return 20;
    }
}
