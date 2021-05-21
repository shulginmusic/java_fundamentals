//package labs_examples.datastructures.trees.labs;
//
///**BST Class
// *
// */
//
//public class MyBinarySearchTree {
//    //Keeping track of the root node
//    TreeNode root;
//    int size;
//
//    /**
//     * Constructor has VarArgs to take 0 or more arguments to insert into the tree
//     *
//     * @param data VarArgs int
//     *
//     */
//
//    public MyBinarySearchTree(int... data) {
//        //if no arguments given, then init an empty tree
//
//        if (data.length < 1) {
//            root = null;
//        } else {
//            //init tree with given data
//            for (int i = 0; i < data.length; i++) {
//                //iterate over the data and add every int there is to be added
//                insert(data[i]);
//            }
//        }
//    }
//
//    /**
//     * insert() data is  overloaded, first signature takes in a single argument
//     * @param data to be added
//     */
//    public void insert(int data) {
//        //if tree is empty, init a new root node
//        if (root == null) {
//            root = new TreeNode(data);
//            size++;
//        } else { //if root != null
//            //call the other method signature (this is recursion at work)
//            insert(data, root);
//        }
//    }
//
//    /**
//     *
//     * @param data to be added
//     * @param node the root node
//     * @return new node recursively
//     */
//
////    private TreeNode insert(int data, TreeNode node) {
////        //Create new node if empty
////        if (node == null) {
////            node = new TreeNode(data);
////            size++;
////        }
////
////        //move to left child of tree if data < the current node's data
////        if (data < node.data) {
////            node.leftChild = insert(data, node.leftChild); //this is a recursive call to this same method signature
////        } else if (data > node.data) {
////            //move to the right child if data is larger
////            node.rightChild = insert(data, node.rightChild);
////        } else { // if equal, do not insert so there are no duplicates
////            return node;
////        }
////
////        //check to rebalance after every insert()
//////        return rebalanceInsert(node, data);
////    }
//
//    /**
//     * Rebalances tree during insertion
//     * @param node root
//     * @param data data that was added
//     * @return root of balanced tree
//     */
//
////    private TreeNode rebalanceInsert(TreeNode node, int data) {
////        //get heights of the child nodes
////        int leftHeight = height(node.leftChild);
////        int rightHeight = height(node.rightChild);
////
////        //Update node height to the greatest height of its children's heights
////        node.height = 1 + Math.max(leftHeight, rightHeight);
////
////        //Get the balance factor of the tree node
////        int treeBalanceFactor = leftHeight - rightHeight;
////
////        if (treeBalanceFactor > 1 && data < node.leftChild.data) {
////            return rotateRight(node);
////        }
////
////        if (treeBalanceFactor < -1 && data > node.rightChild.data) {
////            return rotateLeft(node);
////        }
////
////        if (treeBalanceFactor > 1 && data > node.leftChild.data) {
////            node.leftChild = rotateLeft(node.leftChild);
////            return rotateRight(node);
////        }
////
////        if (treeBalanceFactor < -1 && data < node.rightChild.data) {
////            node.rightChild = rotateRight(node.rightChild);
////            return rotateLeft(node);
////        }
////
////        return node;
////    }
//
//    /**
//     * Rotates the given node's left child to the node position
//     * @param node
//     * @return - the new root of the subtree
//     */
//
//    private TreeNode rotateRight(TreeNode node) {
//        //Get left child of the given node
//        TreeNode child = node.leftChild;
//        //Store the right child (it will be overwritten)
//        TreeNode formerRightChild = child.rightChild;
//
//        //Rotate - set the new right child to the node being inserted
//        child.rightChild = node;
//        //set the left child to what used to be the right child
//        node.leftChild = formerRightChild;
//
//        //update node heights
//
//        //Update the node's height
//        int leftHeight = height(node.leftChild);
//        int rightHeight = height(node.rightChild);
//        node.height = 1 + Math.max(leftHeight, rightHeight);
//
//        //Update the child height
//        leftHeight = height(child.leftChild);
//        rightHeight = height(child.rightChild);
//        child.height = 1 + Math.max(leftHeight, rightHeight);
//
//        return child;
//
//    }
//
//    /**
//     * Get the height of a given node
//     * @param node
//     * @return height of node
//     */
//
//    private int height(TreeNode node) {
//        if (node == null) {
//            return 0;
//        }
//        return node.height;
//    }
//
//
//}
//
///**
// * BST Node Class
// */
//
//class TreeNode {
//    TreeNode leftChild;
//    TreeNode rightChild;
//    int data;
//    int height;
//
//    TreeNode (int data) {
//        this.data = data;
//        this.height = 1;
//    }
//}






