package ex_triangle_exception;

public class Ex_TriangleException extends Exception {
    private double a;
    private double b;
    private double c;

    public Ex_TriangleException(String string){
    }

    public Ex_TriangleException(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public void checkTriangle(double a, double b, double c)throws
            Ex_TriangleException{
        if((a + b <= c) || (b + c <= a) || (a + c <= b) || (a < 0) || (b < 0) || (c < 0)){
            throw new Ex_TriangleException(" lỗi, tam giác ko hợp lệ.");
        }else{
            System.out.println(" tam giác hợp lệ");
        }
    }
}
