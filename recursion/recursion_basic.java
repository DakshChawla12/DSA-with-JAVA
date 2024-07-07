
class recursion_basic {
    
    public static void printNUm(int n){
        if(n == 0){
            return;
        }
        printNUm(n-1);  // tail recursion se n -> 1 tk print hoga
        System.out.println(n);   
    }

    public static int getSum(int n){                                       
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return n + getSum(n-1);
    }

    public static void printSum(int i , int n , int sum){
        if(i == n){
            sum += i;
            System.out.println("sum --> "+ sum);
            return;
        }
        sum += i;
        printSum(i+1, n, sum);
    }

    public static int getFactorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return n * getFactorial(n-1);
    }

    public static void printFibo(int a , int b , int n){

        if(n == 0){
            return;
        }

        int c = a + b;
        System.out.println(c);
        printFibo(b, c, n-1);
    }

    public static void A_to_Power_b(int a , int b , int prod){
        if(b == 0){
            System.out.println(prod);
            return;
        }
        prod *= a;
        A_to_Power_b(a, b-1, prod);
    }

    public static int SumOfDigits(int n){
        System.out.println(n);
        if(n == 0){
            return 0;
        }
        int ld = n % 10;
        return ld +  SumOfDigits(n/10);
    }

    public static int prodOfDigits(int n){
        int ld = n % 10;
        if(ld == n){
            return n;
        }
        return ld*prodOfDigits(n/10);
    }

    public static int reverseAnumber(int n , int rev){
        if(n == 0){
            return rev;
        }
        int rem = n % 10;
        rev = (rev *10) + rem;
        return reverseAnumber(n/10, rev);
    }

    public static int countZeroes(int n , int count){
        if(n == 0){
            return count;
        }
        int ld = n % 10;
        if(ld == 0) count += 1;

        return countZeroes(n/10, count);
    }

    public static int getSteps(int n , int count){
        if(n == 0){
            return count;
        }

        if(n % 2 == 0){
            n = n/2;
            count += 1;
        }
        else if(n % 2 != 0){
            n = n - 1;
            count += 1;
        }

        return getSteps(n,count);
    }

    public static void main(String[] args) {
        // printNUm(5);
        // System.out.println(getSum(1));
        // printSum(1 , 10 , 0);
        //System.out.println(getFactorial(6));

        // int a = 0 , b = 1 , n = 8;
        // System.out.println(a); 
        // System.out.println(b);
        // printFibo(a, b, n-2);

        A_to_Power_b(10, 3, 1);
        // System.out.println(prodOfDigits(1234));

        // System.out.println(reverseAnumber(1234567891 , 0));
        // System.out.println(countZeroes(120030980, 0));
        // System.out.println(getSteps(14, 0));
    }

}