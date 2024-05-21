package mini_test2;

public class Test {
    public static void main(String[] args) {
        Employee[] employees = new Employee[6];
        employees[0] = new EmployeeFullTime(1, "FullA", 30, "123", "a@full", 5000, 2000, 10000);
        employees[1] = new EmployeeFullTime(2, "FullB", 31, "456", "b@full", 6000, 3000, 12000);
        employees[2] = new EmployeeFullTime(3, "FullB", 32, "789", "c@full", 3000, 1500, 9000);
        employees[3] = new EmployeePartTime(4, "PartD", 25, "321", "d@part", 130);
        employees[4] = new EmployeePartTime(5, "PartE", 26, "654", "e@part", 140);
        employees[5] = new EmployeePartTime(6, "PartF", 27, "987", "f@part", 150);

        double avegareSalary = getAvegare(employees);

        System.out.println(" trung bình lương của nhân viên công ty = " + avegareSalary);
        System.out.println(" số nhân viên fulltime có số lương thấp hơn " + avegareSalary);

        extracted(employees, avegareSalary);
        double total = totalPayroll(employees);
        System.out.println(" tổng số lương phải trả cho nv parttime: " + total);
        System.out.println(" sắp xếp tăng dần nhân viên fulltime theo lương");
        Employee[] sortFullTime = arrangeFullTime(employees);
        printList(sortFullTime);
    }

    private static double getAvegare(Employee[] employees) {
        double avegare = 0;
        for (Employee employee : employees) {
            avegare += employee.payroll() / employees.length;
        }
        return avegare;
    }

        public static void printList(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double totalPayroll(Employee[] employees) {
        double total = 0;
        for (Employee employee : employees) {
            if (employee instanceof EmployeePartTime) {
                total += employee.payroll();
            }
        }
        return total;
    }

    private static void extracted(Employee[] employees, double avegareSalary) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee instanceof EmployeeFullTime) {
                EmployeeFullTime emp = (EmployeeFullTime) employee;
                double employeesSalary = emp.payroll();
                if (avegareSalary > employeesSalary) {
                    System.out.println(employee);
                }
            }
        }
    }

        public static Employee[] arrangeFullTime(Employee[] nvFullTime) {
            for (int i = 0; i < nvFullTime.length - 1; i++) {
                for (int j = i + 1; j < nvFullTime.length; j++) {
                    if (nvFullTime[i].payroll() > nvFullTime[j].payroll()) {
                        Employee temp = nvFullTime[i];
                        nvFullTime[i] = nvFullTime[j];
                        nvFullTime[j] = temp;
                    }
                }
            }
            return nvFullTime;
        }

}
