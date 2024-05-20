package mini_test2;

public class EmployeePartTime extends Employee{
    private double workTime;

    public EmployeePartTime(){
    }

    public EmployeePartTime(double workTime) {
        this.workTime = workTime;
    }

    public EmployeePartTime(int code, String name, int age, String phoneNumber, String email, double workTime) {
        super(code, name, age, phoneNumber, email);
        this.workTime = workTime;
    }

    public double getWorkTime() {
        return workTime;
    }

    public void setWorkTime(double workTime) {
        this.workTime = workTime;
    }

    @Override
    public double payroll() {
        return workTime*100;
    }
}
