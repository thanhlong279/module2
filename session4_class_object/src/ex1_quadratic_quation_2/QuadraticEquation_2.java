package ex1_quadratic_quation_2;

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

    public double getDiscriminant(){
        double delta;
        delta = Math.pow(b, 2) - (4 * a * c);;
        return delta;
    }

    public double getRoot1(){
        double r1;
        r1 = (-b + Math.sqrt(Math.pow(b,2) - (4 * a * c))/(2*a));
        return r1;
    }

    public double getRoot2() {
        double r2;
        r2 = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c)) / (2 * a));
        return r2;
    }

    public void solveEquation() {
        double delta = getDiscriminant();

        if(delta > 0){
            System.out.println("phuong trinh co 2 nghiem r1 = " + getRoot1() + ", r2 = " + getRoot2());
        }else if(delta == 0){
            System.out.println(" phuong trinh co nghiem kep r1 = r2 = :" + getRoot1());
        }else{
            System.out.println("phuong trinh vo nghiem");
        }
    }
}
