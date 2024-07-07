
public class SegmentTree {

    private class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int sI , int eI){
            this.startInterval = sI;
            this.endInterval = eI;
        }
    }
    Node root;
    // constructor call krega construct tree fn ko
    public SegmentTree(int[]arr){
        // we have to create a tree using this array
        this.root = constructTree(arr,0,arr.length-1);
    }
    // fn to create the tree from array
    private Node constructTree(int[]arr , int startIdx , int endIdx){
        if(startIdx == endIdx){ // this means we are at leaf node 
            Node leaf = new Node(startIdx, endIdx);
            leaf.data = arr[startIdx];
            return leaf;
        }
        // create new node with index we are currently at
        Node node = new Node(startIdx, endIdx);

        int mid = startIdx + (endIdx - startIdx)/2;

        node.left = this.constructTree(arr, startIdx, mid);
        node.right = this.constructTree(arr, mid+1, endIdx);

        node.data = node.left.data + node.right.data;
        return node;
    }
    // fn to display
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str = "";
        if(node.left != null){ // for left chid
            str = str + "Interval = [" + node.left.startInterval + "-->" + node.left.endInterval + "] and data = " + node.left.data + " => ";
        }else{
            str = str + "No left child";
        }
        // for curr node
        str = str + "Interval = [" + node.startInterval + "-->" + node.endInterval + "] and data = " + node.data + " =>";
    
        if(node.right != null){
            str = str + "Interval = [" + node.right.startInterval + "-->" + node.right.endInterval + "] and data = " + node.right.data + " => ";
        }else{
            str = str + "No right child";
        }
        System.out.println(str);

        // call recursion
        if(node.left != null) display(node.left);
        if(node.right != null) display(node.right);
    }

    public int query(int qsi , int qei){
        return this.query(this.root,qsi,qei);
    }
    private int query(Node node , int qsi , int qei){
        if(node.startInterval >= qsi && node.endInterval <= qei){
            // node is completely lying inside query
            return node.data;
        }
        else if(node.startInterval > qei || node.endInterval < qsi){
            // completely outside
            return 0;
        }
        else{
            return this.query(node.left,qsi,qei) + this.query(node.right,qsi, qei);
        }
    }

    // fn to update value at a specific index
    public void update(int index,int value){
        this.root.data = update(this.root, value, index);
    }
    private int update(Node node , int value, int index){
        if((index >= node.startInterval) && (index <= node.endInterval)){
            if(index == node.startInterval && index == node.endInterval){
                node.data = value;
                return node.data;
            }
            else{
                int leftAns = update(node.left,value, index);
                int rightAns = update(node.right,value, index);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

    public static void main(String[] args) {
        int[]arr = {3,8,6,7};
        SegmentTree tree = new SegmentTree(arr);
        tree.display();
    }
}
