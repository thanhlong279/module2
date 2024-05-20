package mini_test2;

public class EmployeeFullTime extends Employee{
    private double bonus;
    private double fine;
    private double fixedSalary;

    public EmployeeFullTime(){
    }

    public EmployeeFullTime(double bonus, double fine, double fixedSalary) {
        this.bonus = bonus;
        this.fine = fine;
        this.fixedSalary = fixedSalary;
    }

    public EmployeeFullTime(int code, String name, int age, String phoneNumber, String email, double bonus, double fine, double hardSalary) {
        super(code, name, age, phoneNumber, email);
        this.bonus = bonus;
        this.fine = fine;
        this.fixedSalary = hardSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public double payroll() {
        return fixedSalary + bonus - fine;
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
