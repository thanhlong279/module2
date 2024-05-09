public class Ex3_Print_Prime_100 {
    public static boolean isPrime(int num) {
        if(num < 2) return false;
        if(num < 4) return true;
        for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) return false;
        }
        return true;
    }
    public static void printPrime(int n){
        int count = 0;
        int num = 2;
        System.out.println("dãy số nguyên tố bé hơn 100: ");
        while (num <= 100){
            if(isPrime(num)){
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
    }

    public static void main(String[] args) {
        printPrime(100);
    }
}
