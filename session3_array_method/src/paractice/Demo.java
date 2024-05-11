package paractice;

public class Demo {
public int[] arr(int n){
    int[] arr = new int[n];
    int num1 = 0;
    int num2 = 1;
    int num3;
    if (n >= 1) {
        arr[0] = num1;
    }
    if (n >= 2) {
        arr[1] = num2;
    }
    for (int i = 2; i < n; i++) {
        num3 = num1 + num2;
        num1 = num2;
        num2 = num3;
    }
    return arr;
}
}
