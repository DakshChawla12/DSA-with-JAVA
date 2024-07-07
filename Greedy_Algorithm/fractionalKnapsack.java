import java.util.Arrays;
import java.util.Comparator;

//in Java, the concept of overriding is related to inheritance and polymorphism. When a class implements an interface, it must provide concrete implementations for all methods declared in that interface. In the case of the Comparator interface, it has a single abstract method called compare.

//The reason we override the compare method in the itemComparator class is to provide a specific implementation for comparing items. By implementing the Comparator interface and overriding its compare method, we can define our own logic for comparing item objects based on their value-to-weight ratios.
//
//Here's why overriding is necessary:
//
//Interface Contract: The Comparator interface specifies that any class implementing it must provide an implementation for the compare method. Therefore, it's a requirement to override this method.
//
//Custom Comparison Logic: In this specific case, the default comparison logic provided by the Comparator interface might not be suitable for comparing item objects based on their value-to-weight ratios. Hence, we override the method to define our own logic tailored to the problem we're solving.
//
//Polymorphism: Since itemComparator implements the Comparator interface, it can be used interchangeably with any other implementation of Comparator. This allows for flexibility in sorting based on different criteria.
//
//        In summary, overriding the compare method allows us to define custom comparison logic tailored to the specific requirements of the problem domain while adhering to the contract specified by the Comparator interface.

class itemComparator implements Comparator<item>{
    @Override
    public int compare(item a , item b) {
        double r1 = (double) a.value / (double) a.weight;
        double r2 = (double) b.value / (double) b.weight;
        if (r2 > r1) return 1;
        else if (r1 > r2) return -1;
        else return 0;
    }
}
public class fractionalKnapsack {

    public double maxVal(int w , item[]arr , int n){
        Arrays.sort(arr,new itemComparator());

        int currWeight = 0;
        double totalVal = 0;

        for(int i = 0; i < n; i++){
            if(currWeight + arr[i].weight <= w){
                currWeight += arr[i].weight;
                totalVal += arr[i].value;
            }
            else{
                int remain = w - arr[i].weight;
                double valueCanPut = (double)arr[i].value / (double)arr[i].weight * (double) remain;
                totalVal += valueCanPut;
            }
        }

        return totalVal;

    }

    public static void main(String[] args) {

        item[] items = new item[3];
        items[0] = new item(60, 10); // Value = 60, Weight = 10
        items[1] = new item(100, 20); // Value = 100, Weight = 20
        items[2] = new item(120, 30); // Value = 120, Weight = 30

        // Capacity of the knapsack
        int capacity = 50;

        // Creating an instance of fractionalKnapsack
        fractionalKnapsack knapsack = new fractionalKnapsack();

        // Calculating the maximum value
        double maxValue = knapsack.maxVal(capacity, items, items.length);

        // Printing the result
        System.out.println("Maximum value obtainable: " + maxValue);
    }

}
