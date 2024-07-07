public class partitionList {
    public Node head;
    public Node tail;

    public class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node List_Partition(Node head , int x){

        Node dummmy1 = new Node(0);
        Node tail1 = dummmy1;

        Node dummy2 = new Node(0);
        Node tail2 = dummy2;

        Node temp = head;

        while(temp != null){
            if(temp.value < x){
                Node res = new Node(temp.value);
                tail1.next = res;
                tail1 = res;
            }
            else if(temp.value >= x){
                Node res2 = new Node(temp.value);
                tail2.next = res2;
                tail2 = res2;
            }
            temp = temp.next;
        }


        tail2.next = null;
        tail1.next = dummy2.next;

        return dummmy1.next;
    }

    public static void main(String[] args) {
        partitionList ls = new partitionList();

        ls.insertAtTail(1);
        ls.insertAtTail(2);
        ls.insertAtTail(4);
        ls.insertAtTail(3);
        ls.insertAtTail(1);

        Node result = ls.List_Partition(ls.head , 2);
        ls.display(result);
    }

}
