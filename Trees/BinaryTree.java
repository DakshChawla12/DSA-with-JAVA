import java.util.Scanner;

public class BinaryTree {

    public BinaryTree(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int data){
            this.value = data;
        }
    }
    private Node root;
    
    //insert elements
    public void populate(Scanner sc){
        System.out.println("enter the root node : ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc,root);
    }
    private void populate(Scanner sc,Node node){

        System.out.println("do you want to enter left of "+node.value);
        boolean Left = sc.nextBoolean();
        if(Left){
            System.out.println("enter the value of the left of "+node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc,node.left);
        }

        System.out.println("do you want to enter right of "+node.value);
        boolean Right = sc.nextBoolean();
        if(Right){
            System.out.println("enter the value of the right of "+node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc,node.right);
        }
    }

    public void display(){
        display(root,"");
    }
    private void display(Node node,String indent){
        if(node == null) return;
        System.out.println(indent+node.value);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
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
            System.out.println("|---->"+node.value);
        }
        else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.populate(input);
        tree.prettyDisplay();
    }
}