
public class custom_queue {

    private int[]data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    // this is calling the constructor below it
    public  custom_queue(){ // agr size input nahi dia toh default size ka stack bnega
        this(DEFAULT_SIZE);
    }

    public  custom_queue(int size){  // jaise he stack bnega ye constructor call hoyega jo stack la size input le raha h
        this.data = new int[size];
    }

    public boolean isFull(){
        return end == data.length; // ptr is at last index of array
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
        return true;
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Cannot remove from empty queue!!");
            return -1;
        }
        int removed = data[0];
        //shift the elements to left
        for(int i = 1; i < end; i++){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front(){
        if(isEmpty()){
            System.out.println("queue is empty!!");
            return Integer.MIN_VALUE;
        }
        return data[0];
    }

    public void display(){
        for(int i = 0; i < end; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        // Create a queue with the default size
        custom_queue myQueue = new custom_queue();

        // Insert elements into the queue
        myQueue.insert(10);
        myQueue.insert(20);
        myQueue.insert(30);

        // Display the elements in the queue
        System.out.println("Queue elements:");
        myQueue.display();

        // Remove an element from the front of the queue
        int removedElement = myQueue.remove();
        System.out.println("Removed element: " + removedElement);

        // Display the updated queue
        System.out.println("Updated queue elements:");
        myQueue.display();

        // Check the front element of the queue
        int frontElement = myQueue.front();
        System.out.println("Front element: " + frontElement);

        // Check if the queue is empty
        System.out.println("Is the queue empty? " + myQueue.isEmpty());

        // Check if the queue is full (it won't be full in this example)
        System.out.println("Is the queue full? " + myQueue.isFull());
    }

}
