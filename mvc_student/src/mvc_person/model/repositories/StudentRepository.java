package mvc_person.model.repositories;
import mvc_person.model.Student;
import java.io.*;
import java.util.*;

public class StudentRepository {
    private static final String SRC_STUDENT = "D:\\code_gym\\module_2_java\\session\\mvc_student\\src\\mvc_student.csv";
    //    private static Student[] students = new Student[100];
    // su dung ArrayList:
//    private static int count = 0;
    private static List<Student> students = new ArrayList<>();


    static {
//        students[0] = new Student(1, "HaiTT", "Quang Nam", "C03");
//        count = 1;
        students.add(new Student(1, "HaiTT", "Quang Nam", "Co3"));
//        count = 1;
    }

    public void addStudent(Student student) {
        List<Student> students = new ArrayList<>();
        students.add(student);
        writeFile(students, true);

    }


    public List<Student> getAll() {
        List<Student> students = new LinkedList<>();
        File file = new File(SRC_STUDENT);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                students.add(new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khômng tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc dữ liệu");
        } finally {
            if( br !=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file");
                }
            }
        }
        return students;
    }

//    private static List<Student> readFile() {
//        List<Student> students = new ArrayList<>();
//        try (BufferedReader br = new BufferedReader(new FileReader(SRC_STUDENT))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] temp = line.split(",");
//                students.add(new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
//            }
//        } catch (FileNotFoundException e) {
//            // File not found, return empty list
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return students;
//    }
//    private List<Student> readFile(String fileName) {
//        List<Student> students = new ArrayList<>();
//        File file = new File(fileName);
//        FileReader fr = null;
//        BufferedReader br = null;
//        try {
//            fr = new FileReader(file);
//            br = new BufferedReader(fr);
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                String[] temp = line.split(",");
//                students.add(new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println(" ko tìm thấy file");
//        } catch (IOException e) {
//            System.out.println(" lỗi đọc dữ liệu");
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    System.out.println(" lỗi đóng file");
//                }
//            }
//        }
//        return students;
//    }

    public Student findByCode(int code) {
        List<Student> students = getAll();
        for (Student student : students) {
            if (student == null) {
                return null;
            }
            if (student.getId() == code) {
                return student;
            }
        }
        return null;
    }

    public void removeStudent(Student student) {
        List<Student> students = getAll();
        int size = students.size();
        for (int i = 0; i < size; i++) {
            if (students.get(i).getId() == student.getId()) {
                students.remove(i);
//                writeFile(students, true);
//                saveFileStudent();
                updateFile(students);
                break;
            }
        }
    }

    public void editStudent(Student student) {
        List<Student> students = getAll();
        int size = students.size();
        for(Student student1 : students){
            if (student1.getId() == student.getId()) {
                student1.setId(student.getId());
               student1.setName(student.getName());
               student1.setAddress(student.getAddress());
               student1.setAddress(student.getAddress());

            }
            break;
        }
        updateFile(students);
    }

    private void writeFile(List<Student> students, boolean append) {
        File file = new File(SRC_STUDENT);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Student temp : students) {
                bufferedWriter.write(toString(temp));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file");
                }
            }
        }
    }

    private void updateFile(List<Student> students) {
        File file = new File(SRC_STUDENT);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Student temp : students) {
                bufferedWriter.write(toString(temp));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Lỗi đóng file");
                }
            }
        }
    }

    private void saveFileStudent() {
        List<Student> students1 = getAll();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SRC_STUDENT))) {
            for (Student student : students1) {
                bw.write(student.getId() + "," + student.getName() + "," + student.getAddress() + "," + student.getClassroom());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toString(Student student) {
        return student.getId() + "," + student.getName() + "," + student.getAddress() + "," + student.getClassroom();
    }
}
