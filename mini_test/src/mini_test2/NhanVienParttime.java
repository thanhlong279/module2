package mini_test2;

public class NhanVienParttime extends NhanVien{
    private double workTime;

    public NhanVienParttime(){
    }

    public NhanVienParttime(double workTime) {
        this.workTime = workTime;
    }

    public NhanVienParttime(int code, String name, int age, String phoneNumber, String email, double workTime) {
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
