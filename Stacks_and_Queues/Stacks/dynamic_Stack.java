public class dynamic_Stack{

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1; // basically acts as an index in the array

    public dynamic_Stack() {
        this(DEFAULT_SIZE);
    }

    public dynamic_Stack(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public void push(int item) { // ye void h boolean nahi kyunki dynamic stack kbhi full nahi hoga

        // this handles the condition for full stack
        if (isFull()) {
            int[]newData = new int[data.length*2]; // creates a new array twice the size of previous one
            for(int i = 0; i < data.length; i++){ // copying the elements from previous array into new array
                newData[i] = data[i];
            }
            data = newData; // setting the new array as the default array
        }

        ptr++;
        data[ptr] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Cannot pop from empty stack!!");
            return -1;
        }
        return data[ptr--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Cannot peek in empty stack!!");
            return -1;
        }
        return data[ptr];
    }

    public static void main(String[] args) {
        dynamic_Stack dynamicStack = new dynamic_Stack();

        // Push elements onto the stack
        for (int i = 1; i <= 15; i++) {
            dynamicStack.push(i);
        }

        // Peek at the top element
        System.out.println("Top element: " + dynamicStack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + dynamicStack.pop());
        System.out.println("Popped element: " + dynamicStack.pop());

        // Check if the stack is empty
        System.out.println("Is stack empty? " + dynamicStack.isEmpty());
    }
}
