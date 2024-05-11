package ex1_quadratic__quation;

public class QuadraticEquation_2 {
    double a;
    double b;
    double c;

    public QuadraticEquation_2(double a, double b, double c) {
        if (a != 0) {
            this.a = a;
        }else{
            System.out.println("nhap lai, a khac 0.");
        }
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    
}
