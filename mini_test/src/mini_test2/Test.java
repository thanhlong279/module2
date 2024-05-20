package mini_test2;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        NhanVien[] nvFullTime = new NhanVien[3];
        nvFullTime[0] = new NhanVienFulltime(1, "FullA", 30, "123", "a@full", 5000, 2000, 10000);
        nvFullTime[1] = new NhanVienFulltime(2, "FullB", 31, "456", "b@full", 6000, 3000, 12000);
        nvFullTime[2] = new NhanVienFulltime(3, "FullB", 32, "789", "c@full", 3000, 1500, 9000);

        NhanVien[] nvPartTime = new NhanVien[3];
        nvPartTime[0] = new NhanVienParttime(4, "PartD", 25, "321", "d@part", 130);
        nvPartTime[1] = new NhanVienParttime(5, "PartE", 26, "654", "e@part", 140);
        nvPartTime[2] = new NhanVienParttime(6, "PartF", 27, "987", "f@part", 150);

        double avegare = getAvegare(nvFullTime, nvPartTime);

        System.out.println(" trung bình lương của nhân viên công ty = " + avegare);
        System.out.println(" số nhân viên fulltime có số lương thấp hơn "+avegare);
        extracted(nvFullTime, avegare);
        double total = totalPayroll(nvPartTime);
        System.out.println(" tổng số lương phải trả cho nv parttime: " + total);
        System.out.println(" sắp xếp tăng dần nhân viên fulltime theo lương");
        NhanVien[] sortFullTime = arrangeFullTime(nvFullTime);
        print(sortFullTime);
    }

    public static void print(NhanVien[] nvFullTime) {
        for (NhanVien nv : nvFullTime) {
            System.out.println(nv);
        }
    }

    public static double totalPayroll(NhanVien[] nvPartTime) {
        double total = 0;
        for (NhanVien nv : nvPartTime) {
            total += nv.payroll();
        }
        return total;
    }

    private static void extracted(NhanVien[] nvFullTime, double avegare) {
        int count = 0;
        for (NhanVien nv : nvFullTime) {
            if (nv instanceof NhanVienFulltime) {
                NhanVienFulltime nvFull = (NhanVienFulltime) nv;
                double employeeSalary = nvFull.payroll();
                if (employeeSalary < avegare) {
                    System.out.println(nv);
                }
            }
        }
    }

        public static NhanVien[] arrangeFullTime(NhanVien[] nvFullTime) {
            for (int i = 0; i < nvFullTime.length - 1; i++) {
                for (int j = i + 1; j < nvFullTime.length; j++) {
                    if (nvFullTime[i].payroll() > nvFullTime[j].payroll()) {
                        NhanVien temp = nvFullTime[i];
                        nvFullTime[i] = nvFullTime[j];
                        nvFullTime[j] = temp;
                    }
                }
            }
            return nvFullTime;
        }

    private static double getAvegare(NhanVien[] nvFullTime, NhanVien[] nvPartTime) {
        int sumFullTime = 0;
        int sumPartTime = 0;
        for (NhanVien nv : nvFullTime) {
            sumFullTime += nv.payroll();
        }
        for (NhanVien nv : nvPartTime) {
            sumPartTime += nv.payroll();
        }
        double avegare = (sumFullTime + sumPartTime) / (nvFullTime.length + nvPartTime.length);
        return avegare;
    }
}
