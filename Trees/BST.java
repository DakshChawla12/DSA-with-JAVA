
public class BST {

    public class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }
        public int getVal(){
            return value;
        }
    }  
    
    private Node root;
    public BST(){

    }

    public void insert(int value){
        root = insert(value, root);
    }
    private Node insert(int value , Node node){ // fn to insert a node
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(value, node.left);
        }
        if(value > node.value){
            node.right = insert(value, node.right);
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;
        return node;
    }
    // fn to insert elements from an array
    public void populate(int[]nums){ // this will call insert function for each element in array
        for(int i = 0; i < nums.length; i++){
            this.insert(nums[i]);
        }
    }
    // fn to insert elements from a sorted array
    public void populateSorted(int[]nums){
        populateSorted(nums,0,nums.length);
    }
    private void populateSorted(int[]nums , int s, int e){ // this will call insert function for each element in array
        if(s >= e) return;
        int mid = s + (e - s)/2;
        this.insert(nums[mid]);
        populateSorted(nums,s,mid);
        populateSorted(nums,mid+1,e);
    }

    // function to check if a tree is balanced or not
    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){
        if(node == null) return true;
        return Math.abs(getHeight(node.left)-getHeight(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    // function to get height of a node
    public int getHeight(Node node){ // fn to get height of a node
        if(node == null) return -1;
        return node.height;
    }

    public boolean isEmpty(){ // fn to check if the tree is empty or not
        return root == null;
    }

    public void display(){ // fn to display tree
        display(root,"Root Node : ");
    }
    private void display(Node node , String details){
        if(node == null) return;
        System.out.println(details + node.getVal());
        display(node.left,"Left child of " + node.getVal() + " : ");
        display(node.right,"Right child of " + node.getVal() + " : ");
    }
    public void prettyDisplay(){
        prettyDisplay(root,0);
    }
    private void prettyDisplay(Node node,int level){
        if(node == null)  return;
        prettyDisplay(node.right,level+1);
        if(level != 0){
            for(int i = 0; i < level-1; i++){
                System.out.print("|\t");
            }
            System.out.println("|------>"+node.value);
        }
        else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
    }

    // traversals
    public void preOrder(Node node){ // pre-order traversal
        if(node == null) return;
        System.out.println(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void InOrder(Node node){ // in-order traversal
        if(node == null) return;
        InOrder(node.left);
        System.out.println(node.value+" ");
        InOrder(node.right);
    }
    public void postOrder(Node node){ // post-order traversal
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value+" ");
    }
    public static void main(String[] args) {
        BST tree = new BST();
        int[]arr = {1,2,3,4,5,6,7,8};
        tree.populateSorted(arr);
        tree.InOrder(tree.root);
        tree.prettyDisplay();
    }

}
