import java.io.*;
/*Binary Search tree*/

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
        b.insert(4);
        if(b.find(3)) System.out.println("Found it");
        //b.delete(3);
        b.display(root);
    }

    public void insert(int n){
        Node newNode = new Node(n);
       //case 1 root is null
        if(root == null){
            root = newNode;
            return;
        }
        //traverse the tree with a point of reference
        Node current = root;
        Node parent = null;

        while(current != null){
            parent = current;
            if(n < current.data){
                //go to left branch if it's null create the node there and end the loop
                current = current.left;
                if(current == null){
                    parent.left = newNode;
                }
               
            }else{
                //go to right branch if its null create the node there and end the loop
                current = current.right;
                if(current == null){
                    parent.right = newNode;
                }
            }
        }

    }
    public boolean find(int n){
        Node reference = root;
        //traverses the tree if it finds n returns true
        while(reference != null){
            if(reference.data == n){
                return true;
            }
            if(n < reference.data){
                reference = reference.left;
            }else{
                reference = reference.right;
            }
        }
        return false;
    }
    public void delete(int n){

    }
    public static void display(Node root){
        if(root!=null){
            display(root.left);
            System.out.println(" "+root.data);
            display(root.right);
        }
    }
}