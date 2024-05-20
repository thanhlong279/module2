package mini_test2;

public class NhanVienFulltime extends NhanVien{
    private double bonus;
    private double fine;
    private double hardSalary;

    public NhanVienFulltime(){
    }

    public NhanVienFulltime(double bonus, double fine, double hardSalary) {
        this.bonus = bonus;
        this.fine = fine;
        this.hardSalary = hardSalary;
    }

    public NhanVienFulltime(int code, String name, int age, String phoneNumber, String email, double bonus, double fine, double hardSalary) {
        super(code, name, age, phoneNumber, email);
        this.bonus = bonus;
        this.fine = fine;
        this.hardSalary = hardSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(double hardSalary) {
        this.hardSalary = hardSalary;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public double payroll() {
        return hardSalary + bonus - fine;
    }

    @Override
    public String toString() {
        return "NhanVienFulltime{" +
                super.toString() +
                "tiền lương: " +
                this.payroll() +
                '}';
    }
}
