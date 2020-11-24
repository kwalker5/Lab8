/*
* Binary search tree data structure
* @author : Kate Walker
*/

public class BST<T extends Comparable<T>>
{
    /*
    * The root of the BST
    */
    Node<T> root;

    /*
    * Node class for a BST
    */
    private class Node<T>
    {
        T data;
        Node<T> left;
        Node<T> right;
        int instance;

        Node(T item)
        {
            data = item;
            instance = 1;
        }
    }

    public BST()
    {
        root = null;
    }

    /*
    * Find function that finds an item in the BST
    * @param item to be found
    * @return boolean if the item was found
    */
    public boolean find(T item)
    {
        return find(item, root);
    }

    /*
    * Function override of the find function
    * @param item to be found
    * @param node the current node you are at
    * @return boolean if the item was found
    */
    private boolean find(T item, Node<T> node)
    {
        if(node == null){//if node is null
            return false;//return false
        }
        if(item == node.data){//if the item is equal to the node data
            return true;//return true
        }
        else if(item.compareTo(node.data)< 0){//if the item is less than the node data
            return find(item, node.left);//call find on the item and node.left
        }
        else{
            return find(item, node.right);//call find on the item and the node.right
        }
    }

    /*
    * Insert an item to the tree
    * @param item to insert
    */
    public void insert(T item)
    {
        root = insert(item, root);
    }

    /*
    * Helper function for insert
    * @param item to add
    * @param node you are at
    * @return node you traverse to
    */
    private Node<T> insert(T item, Node<T> node)
    {
        if(node == null){//if the node is null
            return new Node(item);//create new node with the item value in it
        }
        if(item.compareTo(node.data) < 0){//if the item is less than the data in the node
            node.left = insert(item, node.left);//set node.left to insert the node to the left of that node
        }
        else{
            node.right = insert(item,node.right);//set node.right to insert the node to the right of that node
        }
        return node;//return the node
    }

    /*
    * Function for deletion of a node
    * @param item to delete
    */
    public void delete(T item)
    {
        root = delete(item, root);
    }

    /*
    * Helper function for deletion of a node
    * @param item to delete
    * @param node you are at
    * @return node you traverse to
    */
    private Node<T> delete(T item, Node<T> node)
    {
        if(node == null){//if the node is null
            return null;//return null
        }
        if(node.data.compareTo(item) < 0){//if the node's data is less than the item
            node.right = delete(item, node.right);//set node.right to call delete on the item and node.right
            return node;//return the node
        }
        else if(node.data.compareTo(item)>0){//if the node's data is greater than the item
            node.left = delete(item, node.left);//set node.left to call delete on the item and node.left
            return node;//return the node
        }
        else{
            if(node.left == null){//if node.left is null
                return node.right;//return node.right
            }
            else if(node.right == null){//if node.right is null
                return node.left;//return node.left
            }
            else{
                if(node.right.left == null){//if node.right.left is null
                    node.data = node.right.data;//set node.data to node.right.data
                    node.right = node.right.right;//set node.right to node.right.right
                }
                else{
                    node.data = removeSmallest(node.right);//set node.data to call removeSmallest node.right
                }
                return node;//return the node
            }
        }
    }
    public T removeSmallest(Node<T> node){//helper function to remove smallest value node
        if(node.left.left == null){//if node.left.left is null
            T smallest = node.left.data;//set smallest to node.left.data
            node.left = node.left.right;//set node.left to node.left.right
            return smallest;//return smallest
        }
        else{
            return removeSmallest(node.left);//call remove smallest on node.left
        }
    }

    /*
    * Function to find the range sum of the binary tree
    * @param L the left bound
    * @param R the right bound
    * @return The sum of the range in the binary tree
    */
    int ans;//an int to store the sum of nodes
    public int rangeSum(int L, int R)
    {
        ans = 0;//set ans to 0
        rangeSum(L,R,root);//call rangeSum on L,R and root
        return ans;//return ans

    }
    private void rangeSum(int L,int R, Node<T> node){
        if (node != null) {//if the node is not null
            if (node.data.compareTo((T) String.valueOf(L))>0 && node.data.compareTo((T) String.valueOf(R)) >0) {
                ans = ans + Integer.parseInt((String) node.data);//set ans to ans plus the node's data
            }
            if (node.data.compareTo((T) String.valueOf(L)) >0) {//if the node's data is less than the left value
                rangeSum(L, R, node.left);//call rangeSum on L,R and node.left
            }
            if (node.data.compareTo((T) String.valueOf(R)) >0) {//if the node's data is greater than the right value
                rangeSum(L, R, node.right);//call rangeSum on L,R and node.right
            }
        }

    }


    /*
    * Function to print the Binary tree
    */
    public void print()
    {
        print(root);
    }

    /*
    * Helper Function to print the Binary tree
    * @param root the root of the tree
    */
    private void print(Node<T> root) {
        if(root != null) {//if the root is not null
            print(root.left);//call print on root.left
            System.out.println(root.data);//print root.data
            print(root.right);//call print on right
        }
    }

}