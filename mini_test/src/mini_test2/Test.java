package mini_test2;

public class Test {
    public static void main(String[] args) {
        Employee[] employeeFullTime = new Employee[3];
        employeeFullTime[0] = new EmployeeFullTime(1, "FullA", 30, "123", "a@full", 5000, 2000, 10000);
        employeeFullTime[1] = new EmployeeFullTime(2, "FullB", 31, "456", "b@full", 6000, 3000, 12000);
        employeeFullTime[2] = new EmployeeFullTime(3, "FullB", 32, "789", "c@full", 3000, 1500, 9000);

        Employee[] employeePartTime = new Employee[3];
        employeePartTime[0] = new EmployeePartTime(4, "PartD", 25, "321", "d@part", 130);
        employeePartTime[1] = new EmployeePartTime(5, "PartE", 26, "654", "e@part", 140);
        employeePartTime[2] = new EmployeePartTime(6, "PartF", 27, "987", "f@part", 150);

        double avegareSalary = getAvegare(employeeFullTime, employeePartTime);

        System.out.println(" trung bình lương của nhân viên công ty = " + avegareSalary);
        System.out.println(" số nhân viên fulltime có số lương thấp hơn "+avegareSalary);

        extracted(employeeFullTime, avegareSalary);
        double total = totalPayroll(employeePartTime);
        System.out.println(" tổng số lương phải trả cho nv parttime: " + total);
        System.out.println(" sắp xếp tăng dần nhân viên fulltime theo lương");
        Employee[] sortFullTime = arrangeFullTime(employeeFullTime);
        printList(sortFullTime);
    }

    public static void printList(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double totalPayroll(Employee[] employees) {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.payroll();
        }
        return total;
    }

    private static void extracted(Employee[] employees, double avegareSalary) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee instanceof EmployeeFullTime) {
                EmployeeFullTime emp = (EmployeeFullTime) employee;
                double employeeSalary = emp.payroll();
                if (employeeSalary < avegareSalary) {
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

    private static double getAvegare(Employee[] employeeFullTime, Employee[] employeePartTime) {
        double sumFullTime = 0;
        double sumPartTime = 0;
        for (Employee empFull : employeeFullTime) {
            sumFullTime += empFull.payroll();
        }
        for (Employee empPart : employeePartTime) {
            sumPartTime += empPart.payroll();
        }
        double sum = (sumFullTime + sumPartTime) / (employeeFullTime.length + employeePartTime.length);
        return sum;
    }
}
