/**
 * Created by Kalvin on 11/24/2016.
 */
public class BST {
    public Node overallRoot;

    public BST() {
    }

    public void add(int data) {
        Node root = overallRoot;
        overallRoot = add(data, root);
    }

    private Node add(int data, Node root) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = add(data, root.left);
        } else {
            root.right = add(data, root.right);
        }
        root.height++;
        if(Math.max(getHeight(root.left),getHeight(root.right)) > 2){
            if(getHeight(root.left) > getHeight(root.right)){ // either leftOfLeft or leftOfRight!
                Node leftSub = root.left;
                if(leftSub.right == null){ //think this is always true for left of left. need to test
                    leftOfLeft(root);
                } else{
                    leftOfRight(root);
                }
            }
        }
        return root;
    }

    private void leftOfLeft(Node root){
        Node leftSubTree = root.left;
        while(leftSubTree.right != null){
            leftSubTree = leftSubTree.right;
        }

        leftSubTree.right = root;
        overallRoot = root.left;
        root.left = null;
    }

    private void rightOfRight(Node root){
        Node rightSubTree = root.right;
        while(rightSubTree.left != null){
            rightSubTree = rightSubTree.left;
        }
        rightSubTree.left = root;
        overallRoot = root.right;
        root.right = null;
    }

    public void leftOfRight(Node root){
        Node leftSubTree = root.left;
        Node highestLeft = root.left;
        while(highestLeft.right!= null){
            highestLeft = highestLeft.right;
        }
        highestLeft.right = root;
        root.left = null;
        rightOfRight(leftSubTree);
    }

    public void rightOfLeft(Node root){
        Node rightSubTree = root.right;
        Node highestRight = root.right;
        while(highestRight.left != null){
            highestRight = highestRight.left;
        }
        highestRight.left = root;
        root.right = null;
        leftOfLeft(rightSubTree);
    }
    public void print() {
        print(overallRoot);
    }

    private void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.println(root.data);
            print(root.right);
        }
    }

    public int findMin() {
        Node root = overallRoot;
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }

    public int getHeight(Node root){
        if(root == null){
            return -1;
        }
        return root.height;
    }
}


