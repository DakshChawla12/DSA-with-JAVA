public class custom_dynamicQueue_I {

    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int end = 0;

    public custom_dynamicQueue_I() {
        this(DEFAULT_SIZE);
    }

    public custom_dynamicQueue_I(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean insert(int item) {
        if (isFull()) {
            resize();
        }
        data[end++] = item;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove from empty queue!!");
            return -1;
        }
        int removed = data[0];
        // Shift the elements to the left
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!");
            return Integer.MIN_VALUE;
        }
        return data[0];
    }

    public void display() {
        for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("END");
    }

    private void resize() {
        int newCapacity = data.length * 2;
        int[] newData = new int[newCapacity];

        for (int i = 0; i < end; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public static void main(String[] args) {
        // Create a dynamic queue with the default size
        custom_dynamicQueue_I dynamicQueue = new custom_dynamicQueue_I();

        // Insert elements into the dynamic queue
        for (int i = 1; i <= 15; i++) {
            dynamicQueue.insert(i);
        }

        // Display the elements in the dynamic queue
        System.out.println("Dynamic Queue elements:");
        dynamicQueue.display();

        // Remove elements from the dynamic queue
        for (int i = 1; i <= 5; i++) {
            dynamicQueue.remove();
        }

        // Display the updated dynamic queue
        System.out.println("Updated Dynamic Queue elements:");
        dynamicQueue.display();
    }
}
