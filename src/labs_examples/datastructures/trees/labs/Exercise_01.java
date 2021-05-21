package labs_examples.datastructures.trees.labs;

/*
    Trees: Exercise_01

    Please demonstrate how to create a custom Binary Search Tree (BST). Using your custom BST, demonstrate how to:

        1.) Create a new CustomBST
        2.) Insert new elements
        3.) Retrieve elements
        4.) Update elements
        5.) Delete elements
        6.) Print elements (Bonus: try in-order traversal, pre-order traversal, post-order traversal)
        7.) Keep the tree well balanced

 */

public class Exercise_01 {

    /**
     * A simple inner node class
     * For now, we'll just use a simple int variable to hold the data
     */
    private class Node {
        Node leftChild;
        Node rightChild;
        int data;
        int height;

        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private class CustomBinarySearchTree {
        //Always track the root node of the tree
        //The node where the tree starts
        Node root;
        int size;

        //We use a VarArgs int constructor that takes in 0 or more arguments
        CustomBinarySearchTree(int...data) {
            //if no data is passed, we simply initialize an *empty* tree
            if (data.length < 1) {
                root = null;
            } else {
                //Else, we iterate over data and call insert() to insert each piece of data into the tree
                for (int i = 0; i < data.length; i++) {
                    insert(data[i]);
                }
            }
        }

        /**
         * The insert() method is overloaded
         * The first method signature is non-recursive, taking a simple argument
         * If the tree is empty, it will create a new root node
         * If the tree is NOT empty, it will call the recursive insert() method signature
         * @param data to be added
         */

        public void insert(int data) {
            if (root == null) {
                //If tree is empty (i.e. there is no root node)
                //Create a new root node and increment the size
                root = new Node(data);
                size++;
            } else {
                //If tree is not empty, call the recursive method signature that takes
                //two arguments: data and the root Node
                insert(data, root);
            }
        }

        private Node insert(int data, Node node) {
            //Create a new node if node passed is null
            if (node == null) {
                node = new Node(data);
                size++;
            }

            //Traverse left
            if (data < node.data) {
                //if data is less, move to the node's left child during insertion
                node.leftChild = insert(data, node.leftChild);
            } else if (data > node.data) {
                //if data is greater, move to the node's right child during insertion
                node.rightChild = insert(data, node.rightChild);
            } else {
                //if both pieces of data are equal, avoid duplicates
                return node;
            }
            //if data is less, move to the node's left child during insertion
            return rebalanceInsert(node, data);
        }

        private Node rebalanceInsert(Node node, int data) {
            //get heights of child nodes
            int leftHeight = height(node.leftChild);
        }

    }


}