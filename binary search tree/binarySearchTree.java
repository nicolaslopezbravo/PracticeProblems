import java.io.*;
/*Binary Search tree*/
//Define class node
public class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
//define class binarySearchTree
public class binarySearchTree{
    //instantiate the root.
    public static Node root;
    //The constructor for the root to create a new binarySearchTree.
    public binarySearchTree(){
        this.root = null;
    }

    public static void main(String [] args){
        /*Create a new tree, and test the methods*/
        binarySearchTree b = new binarySearchTree();
        b.insert(3);
        b.find(5);
        b.delete(3);
        b.display();
    }

    public void insert(int n){
        Node newNode = new Node(n);
        if(root == null){
            root = newNode;
            return;
        }
        if(root.left.data > n){
            
        }

    }
    public boolean find(int n){
        return true;
    }
    public void delete(int n){

    }
    public static void display(){

    }
}