public class custom_CircularQueue{
    
    protected int[]data;
    private static final int DEFAULT_SIZE = 10;

    protected int end = 0;
    protected int front = 0;
    protected int size = 0;

    // this is calling the constructor below it
    public  custom_CircularQueue(){ // agr size input nahi dia toh default size ka stack bnega
        this(DEFAULT_SIZE);
    }

    public  custom_CircularQueue(int size){  // jaise he stack bnega ye constructor call hoyega jo stack la size input le raha h
        this.data = new int[size];
    }

    public boolean isFull(){
        return size== data.length; // ptr is at last index of array
    }
    public boolean isEmpty(){
        return end == 0; // if ptr is -1 means no element is present in stack
    }

    public boolean insert(int item){
        if(isFull()){
            System.out.println("Cannot insert in full queue!!");
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Cannot remove from empty queue!!");
            return -1;
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }

    public int front(){
        if(isEmpty()){
            System.out.println("queue is empty!!");
            return Integer.MIN_VALUE;
        }
        return data[front];
    }

    public void display(){

        if(isEmpty()){
            System.out.println("queue is empty!!");
            return;
        }

        int i = front;
        do{
            System.out.println(data[i] + " -> ");
            i++;
            i = i % data.length;
        }while(i != end);
    }

}
