package ex1_reverse_stack;

import java.util.Scanner;
import java.util.Stack;

public class BinarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println(" nhập số nguyên cần đổi sang hệ nhị phân: ");
        int x = Integer.parseInt(sc.nextLine());
        convertSystem(x);
    }

    private static void convertSystem(int x) {
        Stack<Integer> stack = new Stack<>();
        int surplus;
        while (x > 0) {
            surplus = x %2;
            System.out.println(surplus);
            stack.push(surplus);
            x = x /2;
        }
        System.out.println(" số nhị phân là: ");
        int n = stack.size();
        for (int i = 0; i < n; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}
