public class Ex2_Print_Prime {
    public static void main(String[] args) {
        printPrime(20);
    }
        public static void printPrime ( int n){
            int count = 0;
            int number = 2;

            System.out.println("dãy " + n + " số nguyên số đầu tiên: ");

            while (count < n) {
                if (isPrime(number)) {
                    System.out.print(number + " ");
                    count++;
                }
                number++;
            }
        }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number < 4) return true;
        int i = 2;
        while (i <= number / 2) {
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}

