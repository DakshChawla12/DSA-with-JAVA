import java.util.*;

public class LemonadeChange {

    public static boolean lemonadeChange(int[]arr){
        int fives = 0 , tens = 0;

        for(int bill : arr){
            if(bill == 5) fives++;
            else if(bill == 10){
                if(fives == 0) return false;
                fives--;tens++;
            }
            else{
                if(fives > 0 && tens > 0){
                    fives--;tens--;
                }
                else if(fives >= 3) fives -= 3;
                else return false;
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        int[]arr = {5,5,5,10,5,5,10,20,20,20};
        System.out.println(lemonadeChange(arr));
    }

}
