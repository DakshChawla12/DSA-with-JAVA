
public class customStack {

    protected int[]data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1; // basically acts as index in array

    // this is calling the constructor below it
    public customStack(){ // agr size input nahi dia toh default size ka stack bnega
        this(DEFAULT_SIZE);
    }

    public customStack(int size){  // jaise he stack bnega ye constructor call hoyega jo stack la size input le raha h
        this.data = new int[size];
    }
    
    public boolean isFull(){
        return ptr == data.length-1; // ptr is at last index of array
    }
    public boolean isEmpty(){
        return ptr == -1; // if ptr is -1 means no element is present in stack
    }

    public boolean push(int item){

        if(isFull()){
            System.out.println("Stack is full!!");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop(){

        if(isEmpty()){
            System.out.println("Cannot pop from empty stack!!");
            return -1;
        }
        // int removed = data[ptr];
        // ptr--;
        // return removed;
        return data[ptr--];
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Cannot peek in empty stack!!");
            return -1;
        }
        return data[ptr]; // return the top or last element of stack
    }

    public void display(){
        for(int i = 0; i <= ptr; i++){
            System.out.print(this.data[i] + " ");
        }
    }

    public static void main(String[] args) {
        customStack st = new customStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println(st.peek());
        System.out.println(st.pop());
    }
}