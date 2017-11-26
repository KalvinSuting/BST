/**
 * Created by Kalvin on 11/24/2016.
 */
public class Node {
    public int data;
    public Node left;
    public Node right;
    public int height;

    public Node(int val){
        data = val;
        left = null;
        right = null;
        height = 0;
    }
    public Node(){
        left = null;
        right = null;
        height = 0;
    }
    public boolean isLeaf(){
        return (left == null && right == null);
    }

}
