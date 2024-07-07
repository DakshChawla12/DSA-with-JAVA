package Heaps;
import java.util.*;

public class heapCreation {

    public class Heap{

        int[]arr;
        int size;
        int capacity;

        public Heap(int c){
            this.capacity = c;
            arr = new int[capacity];
            size = 0;
        }

        public void push(int x){ // *** for max-heap
            if(size == capacity){
                System.out.println("Heap is full");
                return;
            }
            arr[size] = x;
            int i = size;
            size++;


            while(i > 0){
                if(arr[i] > arr[(i-1)/2]){
                    int temp = arr[i];
                    arr[i] = arr[(i-1)/2];
                    arr[(i-1)/2] = temp;
                }
                i = (i-1)/2;
            }

        }
        public void push_1(int x){  // *** for min-heap
            if(size == capacity){
                System.out.println("Heap is full");
                return;
            }
            arr[size] = x;
            int i = size;
            size++;

            while(i > 0){
                if(arr[i] < arr[(i-1)/2]){
                    int temp = arr[i];
                    arr[i] = arr[(i-1)/2];
                    arr[(i-1)/2] = temp;
                }
                i = (i-1)/2;
            }
        }

        public int pop(){ // *** for max-heap

            if(size == 0){
                System.out.println("Heap is empty");
                return Integer.MIN_VALUE; // for max-heap
            }
            int data = arr[0];

            arr[0] = arr[size-1];
            size--;
            int i = 0;

            while(i < size){
                int left = 2*i+1;
                int right = 2*i+2;
                if(left < size && arr[left] > arr[i] && arr[left] > arr[right]){
                    int temp = arr[i];
                    arr[i] = arr[left];
                    arr[left] = temp;

                    i = left;
                }
                if(right < size && arr[right] > arr[i] && arr[right] > arr[left]){
                    int temp = arr[i];
                    arr[i] = arr[right];
                    arr[right] = temp;

                    i = right;
                }
                else break;
            }
            return data;
        }

        public int pop_1(){ // *** for min-heap

            if(size == 0){
                System.out.println("Heap is empty");
                return Integer.MAX_VALUE; // for max-heap
            }
            int data = arr[0];

            arr[0] = arr[size-1];
            size--;
            int i = 0;

            while(i < size){
                int left = 2*i+1;
                int right = 2*i+2;
                if(left < size && arr[left] < arr[i] && arr[left] < arr[right]){
                    int temp = arr[i];
                    arr[i] = arr[left];
                    arr[left] = temp;

                    i = left;
                }
                if(right < size && arr[right] < arr[i] && arr[right] < arr[left]){
                    int temp = arr[i];
                    arr[i] = arr[right];
                    arr[right] = temp;

                    i = right;
                }
                else break;
            }
            return data;
        }

        public int peek(){
            return arr[0];
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }

    }

}
